import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;


public class ExaltedRESTServiceImplementation {

	private static Map<String, ExaltedCharacter> characterCache = new HashMap<String, ExaltedCharacter>();
	private final static String filepath = "data/";
	
	public static ExaltedCharacter getCharacter(String name) {
		if(characterCache.containsKey(name)){
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

	public static ExaltedCharacter postCharacter(ExaltedCharacterRequest characterRequest) {
		if(characterRequest == null || characterRequest.getExaltedCharacter() == null) return null;

		ExaltedCharacter character = characterRequest.getExaltedCharacter();
		
		try {
			writeCharacterToXMLFile(character);
		} catch (JAXBException | IOException e) {
			System.err.println("Failed to write file for name: " + character.name);
			return null;
		}
		
		if(characterCache.containsKey(character.name)){
			characterCache.remove(character.name);
		}
		return getCharacter(character.name);
	}

	public static ExaltedCharacter postCharacterDummy(String name) {
		if(name == null) return null;
		ExaltedCharacter character = new ExaltedCharacter();
		character.name = name;

		try {
			writeCharacterToXMLFile(character);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
			return null;
		}
		
		if(characterCache.containsKey(character.name)){
			characterCache.remove(character.name);
		}
		return getCharacter(character.name);
	}

	private static void writeCharacterToXMLFile(ExaltedCharacter character) throws JAXBException, IOException {
		File f = new File(filepath + character.name + ".xml");
		ExaltedCharacter ex = character;
		
		FileOutputStream os = new FileOutputStream(f);
		javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(ex.getClass());
        javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal( ex, os );
		os.close();
		
		System.out.println("Wrote file " + f.getAbsolutePath());
	}
	
	private static ExaltedCharacter readCharacterFromXMLFile(String characterName) throws JAXBException, IOException {
		File f = new File(filepath + characterName + ".xml");
		FileInputStream is = new FileInputStream(f);;
		ExaltedCharacter ex = new ExaltedCharacter();

		javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(ex.getClass());
        javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
        Object character = unmarshaller.unmarshal(is);
		is.close();
		
		System.out.println("Read from the file " + f.getAbsolutePath());
		return (ExaltedCharacter) character;
	}

}
