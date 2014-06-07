package fi.turtiainen.exalted;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

public class ExaltedRESTServiceImplementation {

	private Map<String, ExaltedCharacter> characterCache = new HashMap<String, ExaltedCharacter>();
	private String filepath = "data/";

	private static final String CONFIGURATIONFILELOCATION = System.getProperty("user.home") + "/exalted-configuration/exalted.conf";
	private static final String DATAFILEPATHLABEL = "data.file.path=";

	public ExaltedRESTServiceImplementation() {

		System.out.println("Reading configuration file from " + new File(CONFIGURATIONFILELOCATION).getAbsolutePath());
		this.readConfigurationFile();
	}

	private void readConfigurationFile() {
		System.out.println("Reading configuration file");
		try {
			File f = new File(CONFIGURATIONFILELOCATION);
			BufferedReader br;
			br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(DATAFILEPATHLABEL)) {
					filepath = line.split("=")[1];
					File folder = new File(filepath);
					System.out.println("Found save folder path: " + folder.getAbsolutePath());
					if (!folder.exists()) {
						System.out.println("Folder did not exist. It does now! " + folder.getAbsolutePath());
						folder.mkdir();
					}
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public ExaltedCharacter getCharacter(String name) {
		if (characterCache.containsKey(name)) {
			System.out.println("Read " + name + " from cache.");
			return characterCache.get(name);
		}
		ExaltedCharacter character = null;
		try {
			character = readCharacterFromXMLFile(name);
		} catch (JAXBException | IOException e) {
			System.err.println("Failed to read file for name: " + name);
			return null;
		}

		characterCache.put(name, character);
		System.out.print(" cache: [");
		for (String s : characterCache.keySet()) {
			System.out.print(s + ", ");
		}
		System.out.println("]");
		return character;
	}

	public ExaltedCharacter postCharacter(ExaltedCharacterRequest characterRequest) {
		if (characterRequest == null || characterRequest.getExaltedCharacter() == null)
			return null;

		ExaltedCharacter character = characterRequest.getExaltedCharacter();

		try {
			writeCharacterToXMLFile(character);
		} catch (JAXBException | IOException e) {
			System.err.println("Failed to write file for name: " + character.name);
			return null;
		}

		if (characterCache.containsKey(character.name)) {
			characterCache.remove(character.name);
		}
		return getCharacter(character.name);
	}

	public ExaltedCharacter postCharacterDummy(String name) {
		if (name == null)
			return null;
		ExaltedCharacter character = new ExaltedCharacter();
		character.name = name;

		try {
			writeCharacterToXMLFile(character);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
			return null;
		}

		if (characterCache.containsKey(character.name)) {
			characterCache.remove(character.name);
		}
		return getCharacter(character.name);
	}

	private void writeCharacterToXMLFile(ExaltedCharacter character) throws JAXBException, IOException {
		File f = new File(filepath + character.name + ".xml");
		ExaltedCharacter ex = character;

		FileOutputStream os = new FileOutputStream(f);
		javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(ex.getClass());
		javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(ex, os);
		os.close();

		System.out.println("Wrote file " + f.getAbsolutePath());
	}

	private ExaltedCharacter readCharacterFromXMLFile(String characterName) throws JAXBException, IOException {
		File f = new File(filepath + characterName + ".xml");
		FileInputStream is = new FileInputStream(f);
		;
		ExaltedCharacter ex = new ExaltedCharacter();

		javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(ex.getClass());
		javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
		Object character = unmarshaller.unmarshal(is);
		is.close();

		System.out.println("Read from the file " + f.getAbsolutePath());
		return (ExaltedCharacter) character;
	}

	public List<String> getCharacterList() {
		ArrayList<String> result = new ArrayList<String>();
		File dataFolder = new File(filepath);
		for (final File file : dataFolder.listFiles()) {
			result.add(file.getName().substring(0, file.getName().indexOf('.')));
		}

		return result;
	}

}
