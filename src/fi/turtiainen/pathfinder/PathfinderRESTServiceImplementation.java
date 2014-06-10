package fi.turtiainen.pathfinder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import fi.turtiainen.io.XMLFileWriter;

public class PathfinderRESTServiceImplementation {

	private Map<String, PathfinderCharacter> characterCache = new HashMap<String, PathfinderCharacter>();

	private XMLFileWriter xmlwriter;
	private static final String PATHFINDER = "pathfinder";

	public PathfinderRESTServiceImplementation() {
		xmlwriter = new XMLFileWriter();
	}

	public PathfinderCharacter getCharacter(String name) {
		if (characterCache.containsKey(name)) {
			// System.out.println("Read " + name + " from cache.");
			return characterCache.get(name);
		}

		PathfinderCharacter character = null;
		if (name == null) {
			// TODO: DUMMY
			PathfinderCharacter c = new PathfinderCharacter();
			return c;
		}
		try {
			character = xmlwriter.readPathfinderCharacterFromXMLFile(name);
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

	public PathfinderCharacter postCharacter(PathfinderCharacter character) {
		if (character == null) {
			System.err.println("Null character for post!");
			return null;
		}
		try {
			xmlwriter.writeCharacterToXMLFile(character);
		} catch (JAXBException | IOException e) {
			System.err.println("Failed to write file for name: " + character.nature.name);
			return null;
		}

		if (characterCache.containsKey(character.nature.name)) {
			characterCache.remove(character.nature.name);
		}
		return getCharacter(character.nature.name.value);
	}

	public PathfinderCharacter postCharacterDummy(String name) {
		if (name == null)
			return null;
		PathfinderCharacter character = new PathfinderCharacter();
		character.nature.name.value = name;

		try {
			xmlwriter.writeCharacterToXMLFile(character);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
			return null;
		}

		if (characterCache.containsKey(character.nature.name)) {
			characterCache.remove(character.nature.name);
		}
		return getCharacter(character.nature.name.value);
	}

	public List<String> getCharacterList() {
		return xmlwriter.getFileList(PATHFINDER);
	}

	public void deleteCharacter(String name) {
		xmlwriter.deleteFile(name, PATHFINDER);
	}

}
