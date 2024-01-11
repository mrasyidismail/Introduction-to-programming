package oop;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Character {
	String name, element, path, ability, id;
	int atk, hp, def;

	public Character(String name, String element, String path, String ability, String id, int atk, int hp, int def) {
		this.name = name;
		this.element = element;
		this.path = path;
		this.ability = ability;
		this.id = id;
		this.atk = atk;
		this.hp = hp;
		this.def = def;
	}
}

public class HsR {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String characterName, characterElement, characterPath, characterAbility, splitAbilities[], characterId, input;
	int characterAtk, characterHp, characterDef, menu, index;

	Vector<Character> characters = new Vector<Character>();

	public HsR() {
		do {
			System.out.println("Honkai: Star Rail Character Maker");
			System.out.println("=================================");
			System.out.println("1. Create a Character");
			System.out.println("2. View Characters");
			System.out.println("3. Update a Character");
			System.out.println("4. Delete a Character");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				createCharacter();
				break;
			}
			case 2: {
				viewCharacters();
				break;
			}
			case 3: {
				updateCharacter();
				break;
			}
			case 4: {
				deleteCharacter();
				break;
			}
			case 5: {
				System.out.println("");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 5);
	}

	private void createCharacter() {
		inputData();

		characters.add(new Character(characterName, characterElement, characterPath, characterAbility, characterId,
				characterAtk, characterHp, characterDef));

		System.out.println("Successfully added Character !");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private void viewCharacters() {
		if (characters.isEmpty()) {
			System.out.println("No Character Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyName();
			displayTable();
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void updateCharacter() {
		if (characters.isEmpty()) {
			System.out.println("No Character Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyID();
			displayTable();

			do {
				System.out.print("Enter Character ID [ e.g. " + characters.get(0).id + " ] : ");
				input = sc.nextLine();
			} while (!isMatched(input));

			for (int i = 0; i < characters.size(); i++) {
				if (characters.get(i).id.equals(input))
					index = i;
				else
					continue;
			}

			inputData();

			characters.set(index, new Character(characterName, characterElement, characterPath, characterAbility,
					characterId, characterAtk, characterHp, characterDef));

			System.out.println("Successfully Updated Character !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deleteCharacter() {
		if (characters.isEmpty()) {
			System.out.println("No Character Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyID();
			displayTable();

			do {
				System.out.print("Enter Character ID [ e.g. " + characters.get(0).id + " ] : ");
				input = sc.nextLine();
			} while (!isMatched(input));

			for (int i = 0; i < characters.size(); i++) {
				if (characters.get(i).id.equals(input))
					index = i;
				else
					continue;
			}

			characters.remove(index);
			System.out.println("Successfully Removed Character !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void inputData() {
		do {
			System.out.print("Input Character Name [ Must be alphabetic and Unique ] : ");
			characterName = sc.nextLine();
		} while (!(isUnique(characterName) && isAlphabetic(characterName)));

		do {
			System.out.print(
					"Input Element [ Wind | Quantum | Fire | Ice | Physical | Lightning | Imaginary ] (Case Sensitive) : ");
			characterElement = sc.nextLine();
		} while (!(characterElement.equals("Wind") || characterElement.equals("Quantum")
				|| characterElement.equals("Fire") || characterElement.equals("Ice")
				|| characterElement.equals("Physical") || characterElement.equals("Lightning")
				|| characterElement.equals("Imaginary")));

		do {
			System.out.print(
					"Input Path [ Destruction | Harmony | Erudition | The Hunt | Nihility | Preservation | Abundance ] (Case Sensitive) : ");
			characterPath = sc.nextLine();
		} while (!(characterPath.equals("Destruction") || characterPath.equals("Harmony")
				|| characterPath.equals("Erudition") || characterPath.equals("The Hunt")
				|| characterPath.equals("Nihility") || characterPath.equals("Preservation")
				|| characterPath.equals("Abundance")));

		do {
			System.out.print("Input Attack [ 100 - 5000 ] (Inclusive) : ");
			characterAtk = sc.nextInt();
			sc.nextLine();
		} while (characterAtk < 100 || characterAtk > 5000);

		do {
			System.out.print("Input HP [ 1000 - 10000 ] (Exclusive) : ");
			characterHp = sc.nextInt();
			sc.nextLine();
		} while (characterHp <= 1000 || characterHp >= 10000);

		do {
			System.out.print("Input Def [ 600 - 4000 ] (Inclusive) : ");
			characterDef = sc.nextInt();
			sc.nextLine();
		} while (characterDef < 600 || characterDef > 4000);

		do {
			System.out.print("Input Ability [ Must be atleast 2 words ] : ");
			characterAbility = sc.nextLine();
		} while (!contains2Word(characterAbility));

		characterId = generateID(characterName);
	}

	private void displayTable() {
		String createTable = String.format("| %-14s | %-20s | %-12s | %-12s | %-8s | %-8s | %-8s | %-25s |",
				"Character ID", "Character Name", "Element", "Path", "ATK", "HP", "DEF", "Ability");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < characters.size(); i++) {
			createTable = String.format("| %-14s | %-20s | %-12s | %-12s | %-8d | %-8d | %-8d | %-25s |",
					characters.get(i).id, characters.get(i).name, characters.get(i).element, characters.get(i).path,
					characters.get(i).atk, characters.get(i).hp, characters.get(i).def, characters.get(i).ability);
			System.out.println(createTable);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	private void sortbyName() {
		for (int i = 0; i < characters.size(); i++) {
			for (int j = 0; j < characters.size() - i - 1; j++) {
				if (characters.get(j).name.compareTo(characters.get(j + 1).name) > 0) {
					Character temp = characters.get(j);
					characters.set(j, characters.get(j + 1));
					characters.set(j + 1, temp);
				}
			}
		}
	}

	private void sortbyID() {
		for (int i = 0; i < characters.size(); i++) {
			for (int j = 0; j < characters.size() - i - 1; j++) {
				if (characters.get(j).id.compareTo(characters.get(j + 1).id) > 0) {
					Character temp = characters.get(j);
					characters.set(j, characters.get(j + 1));
					characters.set(j + 1, temp);
				}
			}
		}
	}

	public boolean isUnique(String var) {
		boolean isUnique = true;
		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i).name.equals(var))
				isUnique = false;
		}

		return isUnique;
	}

	private boolean isMatched(String var) {
		boolean isMatch = false;

		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i).id.equals(var))
				isMatch = true;
		}

		return isMatch;
	}

	public boolean isAlphabetic(String var) {
		boolean isChar = false;
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
				isChar = true;
			else
				return false;
		}
		return isChar;
	}

	private boolean contains2Word(String var) {
		splitAbilities = var.split(" ");
		return splitAbilities.length >= 2;
	}

	private String generateID(String var) {
		return String
				.format("SR-%s-%03d",
						(String.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	public static void main(String[] args) {
		new HsR();
	}

}
