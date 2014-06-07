package fi.turtiainen.exalted;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExaltedCharacterDto {

	public ExaltedCharacter exaltedCharacter;

	public ExaltedCharacterDto(ExaltedCharacter exaltedCharacter) {
		this.exaltedCharacter = exaltedCharacter;
	}

	public ExaltedCharacterDto() {
		this.exaltedCharacter = null;
	}

}
