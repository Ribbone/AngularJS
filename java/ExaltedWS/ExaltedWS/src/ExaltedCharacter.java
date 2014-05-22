import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ExaltedCharacter {

	public String name = "asdasf";
	public String player = "asdasf";
	public String caste = "asdasf";
	public String concept = "asdasf";
	public String motivation = "asdasf";
	public String anima = "asdasf";
	
	public int strength = 1;
	public int dexterity = 1;
	public int stamina = 1;
	public int charisma = 1;
	public int manipulation = 1;
	public int appearance = 1;
	public int perception = 1;
	public int intelligence = 1;
	public int wits = 1;
	
	public int archery = 1;
	public int martialArts = 1;
	public int melee = 1;
	public int thrown = 1;
	public int war = 1;
	public int athletics = 1;
	public int dodge = 1;
	public int larceny = 1;
	public int stealth = 1;
	public int integrity = 1;
	public int performance = 1;
	public int precence = 1;
	public int resistance = 1;
	public int survival = 1;
	public int bureaucracy = 1;
	public int linquistics = 1;
	public int ride = 1;
	public int sail = 1;
	public int socialize = 1;
	public int craft = 1;
	public int investigation = 1;
	public int lore = 1;
	public int occult = 1;
	
	public Map<String, Integer> specialities = new HashMap<String, Integer>();
	public List<ExaltedWeapon> weapons = new ArrayList<ExaltedWeapon>();
	
	public ExaltedCharacter(){
		specialities.put("hippiäiinen", 1);
		specialities.put("happiainen", 2);
		specialities.put("huppiainen", 3);
		
		weapons.add(new ExaltedWeapon());
		weapons.add(new ExaltedWeapon());
		
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
	public class ExaltedWeapon {
		public String nimi = "alsdkjak";
		public int speed = 1;
		public int accuracy = 1;
	}
	
}
