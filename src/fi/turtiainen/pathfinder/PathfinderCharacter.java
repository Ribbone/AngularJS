package fi.turtiainen.pathfinder;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PathfinderCharacter {

	public Nature nature = new Nature();

	public Abilities abilities = new Abilities();

	public Speed speed = new Speed();

	public Combat combat = new Combat();

	public ArrayList<Skill> skills = new ArrayList<Skill>();

	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public ArrayList<Armor> armor = new ArrayList<Armor>();
	public ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<Feat> feats = new ArrayList<Feat>();
	public ArrayList<SpecialAbility> specialAbilities = new ArrayList<SpecialAbility>();

	public SpellList spellList = new SpellList();
	public ArrayList<Spell> spells = new ArrayList<Spell>();

	public Resources resources = new Resources();

	public PathfinderCharacter() {
		// For dummy purposes
		// TODO: Kaikki tullaan alustamaan nulleiksi lopullisessa versiossa
		this.armor.add(new Armor());
		this.armor.add(new Armor());
		this.weapons.add(new Weapon());
		this.weapons.add(new Weapon());
		this.items.add(new Item());
		this.items.add(new Item());
		this.feats.add(new Feat());
		this.feats.add(new Feat());
		this.specialAbilities.add(new SpecialAbility());
		this.specialAbilities.add(new SpecialAbility());
		this.spells.add(new Spell());
		this.spells.add(new Spell());

		this.skills.add(new Skill("Acrobatics"));
		this.skills.add(new Skill("Appraise"));
		this.skills.add(new Skill("Bluff"));
		this.skills.add(new Skill("Climb"));
		this.skills.add(new Skill("Craft religion"));
		this.skills.add(new Skill("Diplomacy"));
		this.skills.add(new Skill("DisableDevice"));
		this.skills.add(new Skill("Disguise"));
		this.skills.add(new Skill("EscapeArtist"));
		this.skills.add(new Skill("Fly"));
		this.skills.add(new Skill("HandleAnimal"));
		this.skills.add(new Skill("Heal"));
		this.skills.add(new Skill("Intimidate"));
		this.skills.add(new Skill("Knowledge arcana"));
		this.skills.add(new Skill("Knowledge dungeoneering"));
		this.skills.add(new Skill("Knowledge engineering"));
		this.skills.add(new Skill("Knowledge geography"));
		this.skills.add(new Skill("Knowledge history"));
		this.skills.add(new Skill("Knowledge local"));
		this.skills.add(new Skill("Knowledge nobility"));
		this.skills.add(new Skill("Knowledge planes"));
		this.skills.add(new Skill("Knowledge religion"));
		this.skills.add(new Skill("Linguistics"));
		this.skills.add(new Skill("Perception"));
		this.skills.add(new Skill("Perform religion"));
		this.skills.add(new Skill("Profession religion"));
		this.skills.add(new Skill("Ride"));
		this.skills.add(new Skill("SenseMotive"));
		this.skills.add(new Skill("SleightOfHand"));
		this.skills.add(new Skill("Spellcraft"));
		this.skills.add(new Skill("Stealth"));
		this.skills.add(new Skill("Survival"));
		this.skills.add(new Skill("Swim"));
		this.skills.add(new Skill("UseMagicDevice"));

	}

	// Classes

	public static class Nature {
		public StringValue name = new StringValue("Name");
		public StringValue alignment = new StringValue("Alignment");
		public StringValue player = new StringValue("Player");
		public StringValue deity = new StringValue("Deity");
		public StringValue homeland = new StringValue("Homeland");
		public StringValue race = new StringValue("Race");
		public StringValue size = new StringValue("Size");
		public StringValue gender = new StringValue("Gender");
		public StringValue age = new StringValue("Age");
		public StringValue height = new StringValue("Height");
		public StringValue weight = new StringValue("Weight");
		public StringValue hair = new StringValue("Hair");
		public StringValue eyes = new StringValue("Eyes");
		public StringValue languages = new StringValue("Languages");
	}

	public static class Speed {
		public StringValue baseSpeed = new StringValue("Base speed");
		public StringValue armoredSpeed = new StringValue("Armored speed");
		public StringValue flySpeed = new StringValue("Fly speed");
		public StringValue swimSpeed = new StringValue("Swim speed");
		public StringValue climbSpeed = new StringValue("Climb speed");
		public StringValue burrowSpeed = new StringValue("Burrow speed");
		public StringValue speedNotes = new StringValue("Notes");
	}

	public static class Combat {
		public StringValue healthPoints = new StringValue("HP");
		public StringValue damageReduction = new StringValue("DR");
		public StringValue damage = new StringValue("Damage");
		public StringValue damageNotes = new StringValue("Notes");

		public StringValue fortitudeBaseSave = new StringValue("Fortitude save");
		public StringValue reflexBaseSave = new StringValue("Reflex save");
		public StringValue willBaseSave = new StringValue("Will save");
		public StringValue fortitudeModifier = new StringValue("Fortitude mod");
		public StringValue reflexModifier = new StringValue("Fortitude mod");
		public StringValue willModifier = new StringValue("Fortitude mod");
		public StringValue saveNotes = new StringValue("Notes");

		public StringValue baseAttackBonus = new StringValue("Base attack bonus");
		public StringValue spellResistance = new StringValue("Spell resistance");
		public StringValue cmbModifier = new StringValue("CMB modifier");
	}

	public static class Abilities {
		public IntegerValue strength = new IntegerValue("Strength");
		public IntegerValue dexterity = new IntegerValue("Dexterity");
		public IntegerValue constitution = new IntegerValue("Constitution");
		public IntegerValue intelligence = new IntegerValue("Intelligence");
		public IntegerValue wisdom = new IntegerValue("Wisdom");
		public IntegerValue charisma = new IntegerValue("Charsima");
	}

	public static class Skill {
		public Skill(String name) {
			this.name = name;
		}

		public Skill() {
		}

		public boolean classSkill = false;
		public String name = "Name";
		public int rank = 0;
		public int miscModifier = 0;
		public int raceModifier = 0;
	}

	public static class Weapon {
		public StringValue name = new StringValue("Name");
		public IntegerValue attackBonus = new IntegerValue("Attack bonus");
		public StringValue critical = new StringValue("Critical");
		public StringValue type = new StringValue("Type");
		public IntegerValue range = new IntegerValue("Range");
		public StringValue ammunition = new StringValue("Ammunition");
		public StringValue damage = new StringValue("Damage");
		public StringValue notes = new StringValue("Notes");
	}

	public static class Armor {
		public StringValue name = new StringValue("Name");
		public IntegerValue bonus = new IntegerValue("AC bonus");
		public StringValue type = new StringValue("Type");
		public IntegerValue checkPenalty = new IntegerValue("AC check penalty");
		public IntegerValue spellFailure = new IntegerValue("Spell failure %");
		public StringValue weight = new StringValue("Weight");
		public StringValue properties = new StringValue("Properties");
		public StringValue notes = new StringValue("Notes");
	}

	public static class Item {
		public StringValue name = new StringValue("Name");
		public StringValue weight = new StringValue("Weight");
		public StringValue notes = new StringValue("Notes");
	}

	public static class Feat {
		public StringValue name = new StringValue("Name");
		public StringValue notes = new StringValue("Notes");
	}

	public static class SpecialAbility {
		public StringValue name = new StringValue("Name");
		public StringValue notes = new StringValue("Notes");
	}

	@SuppressWarnings("serial")
	public static class SpellList extends ArrayList<SpellListEntry> {
		public SpellList() {
			this.add(new SpellListEntry(0));
			this.add(new SpellListEntry(1));
			this.add(new SpellListEntry(2));
			this.add(new SpellListEntry(3));
			this.add(new SpellListEntry(4));
			this.add(new SpellListEntry(5));
			this.add(new SpellListEntry(6));
			this.add(new SpellListEntry(7));
			this.add(new SpellListEntry(8));
			this.add(new SpellListEntry(9));
		}
	}

	public static class SpellListEntry {
		public SpellListEntry(int spellLvl) {
			this.spellLvl = new IntegerValue("Spell Level", spellLvl);
		}

		public SpellListEntry() {
		}

		public IntegerValue spellLvl = new IntegerValue("Spell level");
		public IntegerValue spellsKnown = new IntegerValue("Spells known");
		public IntegerValue spellSaveDC = new IntegerValue("Save DC");
		public IntegerValue spellsPerDay = new IntegerValue("Spells/day");
		public IntegerValue bonusSpells = new IntegerValue("Bonus spells");
	}

	public static class Spell {
		public StringValue name = new StringValue("Name");
		public StringValue school = new StringValue("School");
		public IntegerValue level = new IntegerValue("Level");
		public StringValue castingTime = new StringValue("Casting time");
		public StringValue components = new StringValue("Components");
		public StringValue range = new StringValue("Range");
		public StringValue target = new StringValue("Target");
		public StringValue duration = new StringValue("Duration");
		public StringValue savingThrow = new StringValue("Saving throw");
		public StringValue spellResistance = new StringValue("Spell resistance");
		public StringValue notes = new StringValue("Notes");
	}

	public static class Resources {
		public IntegerValue moneycp = new IntegerValue("Copper");
		public IntegerValue moneysp = new IntegerValue("Silver");
		public IntegerValue moneygp = new IntegerValue("Gold");
		public IntegerValue moneypp = new IntegerValue("Platinum");

		public IntegerValue experience = new IntegerValue("Experience");
		public IntegerValue experienceUsed = new IntegerValue("Used Experience");
		public IntegerValue experienceNotes = new IntegerValue("Notes");
		public IntegerValue experienceTarget = new IntegerValue("Next level");
	}

	public static class StringValue {

		public String label = "a";
		public String value = "a";

		public StringValue() {
		}

		public StringValue(String label) {
			this.label = label;
		}

		public StringValue(String label, String value) {
			this.label = label;
			this.value = value;
		}


	}

	public static class IntegerValue {

		public String label = "a";
		public int value = 99;

		public IntegerValue() {
		}

		public IntegerValue(String label) {
			this.label = label;
		}

		public IntegerValue(String label, int value) {
			this.label = label;
			this.value = value;
		}

	}

}
