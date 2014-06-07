package fi.turtiainen.exalted;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExaltedCharacterRequest {

	private ExaltedCharacter exaltedCharacter;

	public ExaltedCharacterRequest() {
	}

	@XmlElement
	public ExaltedCharacter getExaltedCharacter() {
		return exaltedCharacter;
	}

}
