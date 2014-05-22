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

	public String name = "name";
	public String player = "player";
	public String caste = "caste";
	public String concept = "concept";
	public String motivation = "motivation";
	public String anima = "anima";
	
	public int willpower = 1;
	public int essence = 1;
	public int experience = 1;

	public int healthLevels0 = 1;
	public int healthLevels1 = 2;
	public int healthLevels2 = 2;
	public int healthLevels4 = 1;
	public int healthLevelsInc = 1;

	public int lostHealthLevels0 = 0;
	public int lostHealthLevels1 = 0;
	public int lostHealthLevels2 = 0;
	public int lostHealthLevels4 = 0;
	public int lostHealthLevelsInc = 0;
	
	public int compassion = 1;
	public int conviction = 1;
	public int temperance = 1;
	public int valor = 1;
	
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
	public ExaltedArmor armor = new ExaltedArmor();
	
	public ExaltedCharacter(){
		specialities.put("specialityItem", 1);
		weapons.add(new ExaltedWeapon());
	}

	public static class ExaltedWeapon {
		public String nimi = "weaponName";
		public int speed = 1;
		public int accuracy = 1;
		public int damage = 1;
		public char damageType = 'L';
		public int defence = 1;
		public int rate = 1;
		public int range = 1;
	}

	public static class ExaltedArmor {
		public String nimi = "armorName";
		public int soakB = 1;
		public int soakL = 1;
		public int hardnessB = 1;
		public int hardnessL = 1;
		public int mobilityPenalty = 1;
		public int fatique = 1;
	}

}
