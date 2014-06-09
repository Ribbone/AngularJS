package fi.turtiainen.pathfinder;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PathfinderCharacter {

	public Nature nature = new Nature();

	public Abilities abilities = new Abilities();
	public Abilities tempAbilities = new Abilities();

	public Speed speed = new Speed();

	public Combat combat = new Combat();

	public Skills skillRanks = new Skills();
	public Skills skillModifiers = new Skills();
	public Skills skillTempModifiers = new Skills();
	public Skills skillIsClassSkill = new Skills();

	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public ArrayList<Armor> armor = new ArrayList<Armor>();
	public ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<Feat> feats = new ArrayList<Feat>();
	public ArrayList<SpecialAbility> specialAbilities = new ArrayList<SpecialAbility>();
	public SpellList spellList = new SpellList();

	public Resources resources = new Resources();

	public PathfinderCharacter() {
		// For dummy purposes
		// Kaikki tullaan alustamaan nulleiksi lopullisessa versiossa

		this.skillRanks.craft.put("ThisBeNull", "ThisBeNull");
		this.skillRanks.perform.put("ThisBeNull", "ThisBeNull");
		this.skillRanks.profession.put("ThisBeNull", "ThisBeNull");

		this.skillModifiers.craft.put("ThisBeNull", "ThisBeNull");
		this.skillModifiers.perform.put("ThisBeNull", "ThisBeNull");
		this.skillModifiers.profession.put("ThisBeNull", "ThisBeNull");

		this.skillTempModifiers.craft.put("ThisBeNull", "ThisBeNull");
		this.skillTempModifiers.perform.put("ThisBeNull", "ThisBeNull");
		this.skillTempModifiers.profession.put("ThisBeNull", "ThisBeNull");

		this.skillIsClassSkill.craft.put("ThisBeNull", "ThisBeNull");
		this.skillIsClassSkill.perform.put("ThisBeNull", "ThisBeNull");
		this.skillIsClassSkill.profession.put("ThisBeNull", "ThisBeNull");

		this.armor.add(new Armor());
		this.weapons.add(new Weapon());
		this.items.add(new Item());

		this.spellList.get(0).spells.add(new Spell());
		this.spellList.get(1).spells.add(new Spell());
		this.spellList.get(2).spells.add(new Spell());
		this.spellList.get(3).spells.add(new Spell());
		this.spellList.get(4).spells.add(new Spell());
		this.spellList.get(5).spells.add(new Spell());
		this.spellList.get(6).spells.add(new Spell());
		this.spellList.get(7).spells.add(new Spell());
		this.spellList.get(8).spells.add(new Spell());
		this.spellList.get(9).spells.add(new Spell());
	}

	// Classes

	public static class Nature {
		public String name = "askdjh";
		public String alignment = "askdjh";
		public String player = "askdjh";
		public String deity = "askdjh";
		public String homeland = "askdjh";
		public String race = "askdjh";
		public String size = "askdjh";
		public String gender = "askdjh";
		public String age = "askdjh";
		public String height = "askdjh";
		public String weight = "askdjh";
		public String hair = "askdjh";
		public String eyes = "askdjh";
		public String languages = "askdjh";
	}

	public static class Speed {
		public String baseSpeed = "askdjh";
		public String armoredSpeed = "askdjh";
		public String flySpeed = "askdjh";
		public String swimSpeed = "askdjh";
		public String climbSpeed = "askdjh";
		public String burrowSpeed = "askdjh";
		public String speedNotes = "askdjh";
	}

	public static class Combat {
		public String healthPoints = "askdjh";
		public String damageReduction = "askdjh";
		public String damage = "askdjh";
		public String damageNotes = "askdjh";

		public String fortitudeBaseSave = "askdjh";
		public String reflexBaseSave = "askdjh";
		public String willBaseSave = "askdjh";
		public String fortitudeModifier = "askdjh";
		public String reflexModifier = "askdjh";
		public String willModifier = "askdjh";
		public String saveNotes = "askdjh";

		public String baseAttackBonus = "askdjh";
		public String spellResistance = "askdjh";
		public String cmbModifier = "askdjh";
	}

	public static class Abilities {
		public String strength = "askdjh";
		public String dexterity = "askdjh";
		public String constitution = "askdjh";
		public String intelligence = "askdjh";
		public String wisdom = "askdjh";
		public String charisma = "askdjh";
	}

	public static class Skills {
		public String acrobatics = "askdjh";
		public String climb = "askdjh";
		public String appraise = "askdjh";
		public String bluff = "askdjh";
		public String diplomacy = "askdjh";
		public String disableDevice = "askdjh";
		public String disguise = "askdjh";
		public String escapeArtist = "askdjh";
		public String fly = "askdjh";
		public String handleAnimal = "askdjh";
		public String heal = "askdjh";
		public String intimidate = "askdjh";
		public String linguistics = "askdjh";
		public String perception = "askdjh";
		public String ride = "askdjh";
		public String senseMotive = "askdjh";
		public String sleightOfHand = "askdjh";
		public String spellcraft = "askdjh";
		public String stealth = "askdjh";
		public String survival = "askdjh";
		public String swim = "askdjh";
		public String useMagicDevice = "askdjh";

		public String skillConditionalModifiers = "askdjh";

		public HashMap<String, String> knowledge = new HashMap<String, String>();
		public HashMap<String, String> craft = new HashMap<String, String>();
		public HashMap<String, String> perform = new HashMap<String, String>();
		public HashMap<String, String> profession = new HashMap<String, String>();

		public Skills() {
			this.knowledge.put("arcana", "ThisBeNull");
			this.knowledge.put("dungeoneering", "ThisBeNull");
			this.knowledge.put("engineering", "ThisBeNull");
			this.knowledge.put("geography", "ThisBeNull");
			this.knowledge.put("history", "ThisBeNull");
			this.knowledge.put("local", "ThisBeNull");
			this.knowledge.put("nobility", "ThisBeNull");
			this.knowledge.put("planes", "ThisBeNull");
			this.knowledge.put("religion", "ThisBeNull");

		}
	}

	public static class Weapon {
		public String name = "askdjh";
		public String attackBonus = "askdjh";
		public String critical = "askdjh";
		public String type = "askdjh";
		public String range = "askdjh";
		public String ammunition = "askdjh";
		public String damage = "askdjh";
		public String notes = "askdjh";
	}

	public static class Armor {
		public String name = "askdjh";
		public String bonus = "askdjh";
		public String type = "askdjh";
		public String checkPenalty = "askdjh";
		public String spellFailure = "askdjh";
		public String weight = "askdjh";
		public String properties = "askdjh";
		public String notes = "askdjh";
	}

	public static class Item {
		public String name = "askdjh";
		public String weight = "askdjh";
		public String notes = "askdjh";
	}

	public static class Feat {
		public String name = "askdjh";
		public String notes = "askdjh";
	}

	public static class SpecialAbility {
		public String name = "askdjh";
		public String notes = "askdjh";
	}

	@SuppressWarnings("serial")
	public static class SpellList extends ArrayList<SpellListEntry> {
		public SpellList() {
			this.add(new SpellListEntry("0"));
			this.add(new SpellListEntry("1st"));
			this.add(new SpellListEntry("2nd"));
			this.add(new SpellListEntry("3rd"));
			this.add(new SpellListEntry("4th"));
			this.add(new SpellListEntry("5th"));
			this.add(new SpellListEntry("6th"));
			this.add(new SpellListEntry("7th"));
			this.add(new SpellListEntry("8th"));
			this.add(new SpellListEntry("9th"));
		}
	}

	public static class SpellListEntry {
		public SpellListEntry(String spellLvl) {
			this.spellLvl = spellLvl;
		}

		public SpellListEntry() {
		}

		public String spellLvl = "askdjh";
		public String spellsKnown = "askdjh";
		public String spellSaveDC = "askdjh";
		public String spellsPerDay = "askdjh";
		public String bonusSpells = "askdjh";
		public ArrayList<Spell> spells = new ArrayList<Spell>();
	}

	public static class Spell {
		public String name = "askdjh";
		public String school = "askdjh";
		public String castingTime = "askdjh";
		public String components = "askdjh";
		public String range = "askdjh";
		public String target = "askdjh";
		public String duration = "askdjh";
		public String savingThrow = "askdjh";
		public String SpellResistance = "askdjh";
		public String notes = "askdjh";
	}

	public static class Resources {
		public String moneycp = "askdjh";
		public String moneysp = "askdjh";
		public String moneygp = "askdjh";
		public String moneypp = "askdjh";

		public String experience = "askdjh";
		public String experienceUsed = "askdjh";
		public String experienceNotes = "askdjh";
		public String experienceTarget = "askdjh";
	}

}
