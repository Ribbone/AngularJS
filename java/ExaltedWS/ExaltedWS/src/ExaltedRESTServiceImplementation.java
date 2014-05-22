import java.util.HashMap;
import java.util.Map;


public class ExaltedRESTServiceImplementation {

	private static Map<String, ExaltedCharacter> characterCache;
	
	public static ExaltedCharacter getCharacter(String name) {
		if(characterCache == null){
			characterCache = new HashMap<String, ExaltedCharacter>();
		} else {
			if(characterCache.containsKey(name)){
				return characterCache.get(name);
			}
		}
		//character = getCharacterFromXML(name)
		//characterCache.put(name, character);
		//return character
		return new ExaltedCharacter();
	}

	public static ExaltedCharacter postCharacter(ExaltedCharacterRequest character) {

		//character = getCharacterFromXML(name)


		// TODO: XML kirjoitus, kakutuksen nollaus
		return null;
	}

}
