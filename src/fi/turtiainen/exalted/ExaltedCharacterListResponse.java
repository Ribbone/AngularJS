package fi.turtiainen.exalted;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExaltedCharacterListResponse {

	private List<String> exaltedCharacterList;

	public ExaltedCharacterListResponse(List<String> list) {
		this.exaltedCharacterList = list;
	}

	public ExaltedCharacterListResponse() {
		this.exaltedCharacterList = null;
	}

	@XmlElement
	public List<String> getExaltedCharacter() {
		return exaltedCharacterList;
	}

}
