package fi.turtiainen.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;

import fi.turtiainen.exalted.ExaltedCharacter;
import fi.turtiainen.pathfinder.PathfinderCharacter;

public class XMLFileWriter {
	private HashMap<String, String> filepaths = new HashMap<String, String>();

	private static final String CONFIGURATIONFILELOCATION = System.getProperty("user.home") + "/exalted-configuration/exalted.conf";
	private static final String DATAFILEEXALTEDLABEL = "data.file.path.exalted=";
	private static final String DATAFILEPATHFINDERLABEL = "data.file.path.pathfinder=";
	private static final String EXALTED = "exalted";
	private static final String PATHFINDER = "pathfinder";

	public XMLFileWriter() {
		readConfigurationFile();
	}

	private void readConfigurationFile() {
		try {
			File f = new File(CONFIGURATIONFILELOCATION);
			BufferedReader br;
			br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(DATAFILEEXALTEDLABEL)) {
					extractData(line, EXALTED);
				} else if (line.contains(DATAFILEPATHFINDERLABEL)) {
					extractData(line, PATHFINDER);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private void extractData(String line, String label) {
		String value = line.split("=")[1];
		filepaths.put(label, value);
		ensureFolderExists(value);
	}

	private void ensureFolderExists(String value) {
		File folder = new File(value);
		System.out.println("Found save folder path: " + folder.getAbsolutePath());
		if (!folder.exists()) {
			System.out.println("Folder did not exist. It does now! " + folder.getAbsolutePath());
			folder.mkdir();
		}
	}

	public void writeCharacterToXMLFile(ExaltedCharacter character) throws JAXBException, IOException {
		String filepath = filepaths.get(EXALTED);
		File f = new File(filepath + character.name + ".xml");
		writeObjectToXMLFile(f, character);
	}

	public void writeCharacterToXMLFile(PathfinderCharacter character) throws JAXBException, IOException {
		String filepath = filepaths.get(PATHFINDER);
		File f = new File(filepath + character.nature.name + ".xml");
		writeObjectToXMLFile(f, character);
	}

	private void writeObjectToXMLFile(File f, Object o) throws FileNotFoundException, JAXBException, PropertyException, IOException {
		FileOutputStream os = new FileOutputStream(f);
		javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(o.getClass());
		javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(o, os);
		os.close();
	}

	public ExaltedCharacter readExaltedCharacterFromXMLFile(String characterName) throws JAXBException, IOException {
		String filepath = filepaths.get(EXALTED);
		File file = new File(filepath + characterName + ".xml");
		Object character = readObjectFromXMLFile(file, ExaltedCharacter.class);
		return (ExaltedCharacter) character;
	}

	public PathfinderCharacter readPathfinderCharacterFromXMLFile(String characterName) throws JAXBException, IOException {
		String filepath = filepaths.get(PATHFINDER);
		File file = new File(filepath + characterName + ".xml");
		Object character = readObjectFromXMLFile(file, PathfinderCharacter.class);
		return (PathfinderCharacter) character;
	}

	private Object readObjectFromXMLFile(File file, Class<?> objectClass) throws FileNotFoundException, JAXBException, IOException {
		FileInputStream is = new FileInputStream(file);
		javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(objectClass);
		javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
		Object character = unmarshaller.unmarshal(is);
		is.close();
		return character;
	}

	public ArrayList<String> getFileList(String service) {
		String filepath = filepaths.get(service);
		ArrayList<String> result = new ArrayList<String>();
		File dataFolder = new File(filepath);
		for (final File file : dataFolder.listFiles()) {
			result.add(file.getName().substring(0, file.getName().indexOf('.')));
		}
		return result;
	}

	public void deleteFile(String name, String service) {
		String filepath = filepaths.get(service);
		File f = new File(filepath + name + ".xml");
		f.delete();
	}
}
