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

		this.skillRanks.craft.put("c1", "a");
		this.skillRanks.perform.put("p2", "a");
		this.skillRanks.profession.put("p3", "a");

		this.skillModifiers.craft.put("c1", "a");
		this.skillModifiers.perform.put("p2", "a");
		this.skillModifiers.profession.put("p3", "a");

		this.skillTempModifiers.craft.put("c1", "a");
		this.skillTempModifiers.perform.put("p2", "a");
		this.skillTempModifiers.profession.put("p3", "a");

		this.skillIsClassSkill.craft.put("c1", "a");
		this.skillIsClassSkill.perform.put("p2", "a");
		this.skillIsClassSkill.profession.put("p3", "a");

		this.armor.add(new Armor());
		this.armor.add(new Armor());
		this.weapons.add(new Weapon());
		this.weapons.add(new Weapon());
		this.items.add(new Item());
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
		public String name = "a";
		public String alignment = "a";
		public String player = "a";
		public String deity = "a";
		public String homeland = "a";
		public String race = "a";
		public String size = "a";
		public String gender = "a";
		public String age = "a";
		public String height = "a";
		public String weight = "a";
		public String hair = "a";
		public String eyes = "a";
		public String languages = "a";
	}

	public static class Speed {
		public String baseSpeed = "a";
		public String armoredSpeed = "a";
		public String flySpeed = "a";
		public String swimSpeed = "a";
		public String climbSpeed = "a";
		public String burrowSpeed = "a";
		public String speedNotes = "a";
	}

	public static class Combat {
		public String healthPoints = "a";
		public String damageReduction = "a";
		public String damage = "a";
		public String damageNotes = "a";

		public String fortitudeBaseSave = "a";
		public String reflexBaseSave = "a";
		public String willBaseSave = "a";
		public String fortitudeModifier = "a";
		public String reflexModifier = "a";
		public String willModifier = "a";
		public String saveNotes = "a";

		public String baseAttackBonus = "a";
		public String spellResistance = "a";
		public String cmbModifier = "a";
	}

	public static class Abilities {
		public String strength = "a";
		public String dexterity = "a";
		public String constitution = "a";
		public String intelligence = "a";
		public String wisdom = "a";
		public String charisma = "a";
	}

	public static class Skills {
		public String acrobatics = "a";
		public String climb = "a";
		public String appraise = "a";
		public String bluff = "a";
		public String diplomacy = "a";
		public String disableDevice = "a";
		public String disguise = "a";
		public String escapeArtist = "a";
		public String fly = "a";
		public String handleAnimal = "a";
		public String heal = "a";
		public String intimidate = "a";
		public String linguistics = "a";
		public String perception = "a";
		public String ride = "a";
		public String senseMotive = "a";
		public String sleightOfHand = "a";
		public String spellcraft = "a";
		public String stealth = "a";
		public String survival = "a";
		public String swim = "a";
		public String useMagicDevice = "a";

		public String skillConditionalModifiers = "a";

		public HashMap<String, String> knowledge = new HashMap<String, String>();
		public HashMap<String, String> craft = new HashMap<String, String>();
		public HashMap<String, String> perform = new HashMap<String, String>();
		public HashMap<String, String> profession = new HashMap<String, String>();

		public Skills() {
			this.knowledge.put("arcana", "a");
			this.knowledge.put("dungeoneering", "a");
			this.knowledge.put("engineering", "a");
			this.knowledge.put("geography", "a");
			this.knowledge.put("history", "a");
			this.knowledge.put("local", "a");
			this.knowledge.put("nobility", "a");
			this.knowledge.put("planes", "a");
			this.knowledge.put("religion", "a");

		}
	}

	public static class Weapon {
		public String name = "a";
		public String attackBonus = "a";
		public String critical = "a";
		public String type = "a";
		public String range = "a";
		public String ammunition = "a";
		public String damage = "a";
		public String notes = "a";
	}

	public static class Armor {
		public String name = "a";
		public String bonus = "a";
		public String type = "a";
		public String checkPenalty = "a";
		public String spellFailure = "a";
		public String weight = "a";
		public String properties = "a";
		public String notes = "a";
	}

	public static class Item {
		public String name = "a";
		public String weight = "a";
		public String notes = "a";
	}

	public static class Feat {
		public String name = "a";
		public String notes = "a";
	}

	public static class SpecialAbility {
		public String name = "a";
		public String notes = "a";
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

		public String spellLvl = "a";
		public String spellsKnown = "a";
		public String spellSaveDC = "a";
		public String spellsPerDay = "a";
		public String bonusSpells = "a";
		public ArrayList<Spell> spells = new ArrayList<Spell>();
	}

	public static class Spell {
		public String name = "a";
		public String school = "a";
		public String castingTime = "a";
		public String components = "a";
		public String range = "a";
		public String target = "a";
		public String duration = "a";
		public String savingThrow = "a";
		public String SpellResistance = "a";
		public String notes = "a";
	}

	public static class Resources {
		public String moneycp = "a";
		public String moneysp = "a";
		public String moneygp = "a";
		public String moneypp = "a";

		public String experience = "a";
		public String experienceUsed = "a";
		public String experienceNotes = "a";
		public String experienceTarget = "a";
	}

}
