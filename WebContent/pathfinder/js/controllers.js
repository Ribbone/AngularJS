"use strict";

app.controller('mainController', function($scope, characterService) {

	function getCharList() {
		characterService.getCharList().success(function(response) {
			$scope.characterList = response;
			$scope.status = 'Hahmolista ladattu';
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmolistaa';
		});
	}

	function getChar(name) {
		characterService.getChar(name).success(function(response) {
			$scope.character = response;
			$scope.status = 'Ladattiin hahmo ' + name;
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmoa ' + name;
		});
	}
	
	function getCharPlain() {
		characterService.getCharPlain().success(function(response) {
			$scope.character = response;
			$scope.status = 'Ladattiin tyhjä hahmo';
		}).error(function(error) {
			$scope.status = 'Ei pysty lataamaan hahmoa';
		});
	}

	function init() {
		getCharList();
		getCharPlain();

		$scope.fields = {};
		$scope.fields.nature = [ "name", "alignment", "player", "deity", "homeland", "race", "size", "gender", "age", "height", "weight", "hair", "eyes",
				"languages" ];
		$scope.fields.abilities = [ "strength", "dexterity", "constitution", "intelligence", "wisdom", "charisma" ];
		$scope.fields.speed = [ "baseSpeed", "armoredSpeed", "flySpeed", "swimSpeed", "climbSpeed", "burrowSpeed", "speedNotes" ];
		$scope.fields.combat = [ "healthPoints", "damageReduction", "damage", "damageNotes", "fortitudeBaseSave", "reflexBaseSave", "willBaseSave",
				"fortitudeModifier", "reflexModifier", "willModifier", "saveNotes", "baseAttackBonus", "spellResistance", "cmbModifier" ];
		$scope.fields.skills = [ "acrobatics", "climb", "appraise", "bluff", "diplomacy", "disableDevice", "disguise", "escapeArtist", "fly", "handleAnimal",
				"heal", "intimidate", "linguistics", "perception", "ride", "senseMotive", "sleightOfHand", "spellcraft", "stealth", "survival", "swim",
				"useMagicDevice", "skillConditionalModifiers", "knowledge", "craft", "perform", "profession" ];
		$scope.fields.weapons = [ "name", "attackBonus", "critical", "type", "range", "ammunition", "damage", "notes" ];
		$scope.fields.armor = [ "name", "bonus", "type", "checkPenalty", "spellFailure", "weight", "properties", "notes" ];
		$scope.fields.items = [ "name", "weight", "notes" ];
		$scope.fields.spellList = [ "spellLvl", "spellsKnown", "spellSaveDC", "spellsPerDay", "bonusSpells", "spells" ];
		$scope.fields.spell = [ "name", "school", "castingTime", "components", "range", "target", "duration", "savingThrow", "SpellResistance", "notes" ];
		$scope.fields.resources = [ "moneycp", "moneysp", "moneygp", "moneypp", "experience", "experienceUsed", "experienceNotes", "experienceTarget" ];

	}

	init();
});
