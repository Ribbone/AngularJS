package fi.turtiainen.pathfinder;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PathfinderCharacterListResponse {

	private List<String> exaltedCharacterList;

	public PathfinderCharacterListResponse(List<String> list) {
		this.exaltedCharacterList = list;
	}

	public PathfinderCharacterListResponse() {
		this.exaltedCharacterList = null;
	}

	@XmlElement
	public List<String> getExaltedCharacter() {
		return exaltedCharacterList;
	}

}
