package fi.turtiainen.exalted;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import fi.turtiainen.io.XMLFileWriter;

public class ExaltedRESTServiceImplementation {

	private static final String SERVICEID = "exalted";

	private Map<String, ExaltedCharacter> characterCache = new HashMap<String, ExaltedCharacter>();
	XMLFileWriter xmlwriter;

	public ExaltedRESTServiceImplementation() {
		xmlwriter = new XMLFileWriter();
	}

	public ExaltedCharacter getCharacter(String name) {
		if (characterCache.containsKey(name)) {
			// System.out.println("Read " + name + " from cache.");
			return characterCache.get(name);
		}
		ExaltedCharacter character = null;
		try {
			character = xmlwriter.readExaltedCharacterFromXMLFile(name);
		} catch (JAXBException | IOException e) {
			System.err.println("Failed to read file for name: " + name);
			return null;
		}

		characterCache.put(name, character);
		// System.out.print(" cache: [");
		// for (String s : characterCache.keySet()) {
		// System.out.print(s + ", ");
		// }
		// System.out.println("]");
		return character;
	}

	public ExaltedCharacter postCharacter(ExaltedCharacter characterRequest) {
		if (characterRequest == null || characterRequest == null) {
			System.err.println("Null character for post!");
			return null;
		}

		ExaltedCharacter character = characterRequest;

		try {
			xmlwriter.writeCharacterToXMLFile(character);
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
			xmlwriter.writeCharacterToXMLFile(character);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
			return null;
		}

		if (characterCache.containsKey(character.name)) {
			characterCache.remove(character.name);
		}
		return getCharacter(character.name);
	}

	public List<String> getCharacterList() {
		ArrayList<String> result = xmlwriter.getFileList(SERVICEID);

		return result;
	}

	public void deleteCharacter(String name) {
		xmlwriter.deleteFile(name, SERVICEID);
		if (characterCache.containsKey(name)) {
			characterCache.remove(name);
		}
	}

}
