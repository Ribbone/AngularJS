package fi.turtiainen.exalted;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExaltedCharacterResponse {

	private ExaltedCharacter exaltedCharacter;
	
	public ExaltedCharacterResponse(ExaltedCharacter exaltedCharacter) {
		// TODO Auto-generated constructor stub
		// TODO: kirjoita character muuttujiin
		this.exaltedCharacter = exaltedCharacter;
	}

	public ExaltedCharacterResponse() {
		// TODO Auto-generated constructor stub
		// TODO: kirjoita character muuttujiin
		this.exaltedCharacter = null;
	}

	@XmlElement
	public ExaltedCharacter getExaltedCharacter() {
		return exaltedCharacter;
	}

	
	
}
