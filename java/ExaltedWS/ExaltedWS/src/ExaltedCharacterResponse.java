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

	@XmlElement
	public ExaltedCharacter getExaltedCharacter() {
		return exaltedCharacter;
	}

	
	
}
