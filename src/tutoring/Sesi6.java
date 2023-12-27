package tutoring;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Sesi6 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String name, element, path, ability, splitAbility[], id, input;
	int atk, hp, def, menu, index;

	Vector<String> ids = new Vector<String>();
	Vector<String> names = new Vector<String>();
	Vector<String> elements = new Vector<String>();
	Vector<String> paths = new Vector<String>();
	Vector<String> abilities = new Vector<String>();
	Vector<Integer> atks = new Vector<Integer>();
	Vector<Integer> hps = new Vector<Integer>();
	Vector<Integer> defs = new Vector<Integer>();

	public Sesi6() {
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
				inputCharacter();
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
				System.out.println("Come aboard with us on the Astral Express, Trailblazers!");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 5);
	}

	private void inputCharacter() {
		inputData();

		ids.add(id);
		names.add(name);
		elements.add(element);
		abilities.add(ability);
		atks.add(atk);
		hps.add(hp);
		paths.add(path);
		defs.add(def);

		System.out.println("Successfully added Character !");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private void viewCharacters() {
		if (ids.isEmpty()) {
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
		if (ids.isEmpty()) {
			System.out.println("No Character Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyID();
			displayTable();

			do {
				System.out.print("Enter Character ID [ e.g. " + ids.get(0) + " ] : ");
				input = sc.nextLine();
			} while (!ids.contains(input));

			index = ids.indexOf(input);

			inputData();

			ids.set(index, id);
			names.set(index, name);
			elements.set(index, element);
			abilities.set(index, ability);
			atks.set(index, atk);
			defs.set(index, def);
			hps.set(index, hp);
			paths.set(index, path);

			System.out.println("Successfully Updated Character !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deleteCharacter() {
		if (ids.isEmpty()) {
			System.out.println("No Character Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyID();
			displayTable();

			do {
				System.out.print("Enter Character ID [ e.g. " + ids.get(0) + " ] : ");
				input = sc.nextLine();
			} while (!ids.contains(input));

			index = ids.indexOf(input);

			names.remove(index);
			ids.remove(index);
			elements.remove(index);
			abilities.remove(index);
			atks.remove(index);
			defs.remove(index);
			hps.remove(index);
			paths.remove(index);
			System.out.println("Successfully Removed Character !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void inputData() {
		do {
			System.out.print("Input Character Name [ Must be alphabetic and Unique ] : ");
			name = sc.nextLine();
		} while (!(isAlphabetic(name) && !names.contains(name)));

		do {
			System.out.print(
					"Input Element [ Wind | Quantum | Fire | Ice | Physical | Lightning | Imaginary ] (Case Sensitive) : ");
			element = sc.nextLine();
		} while (!(element.equals("Wind") || element.equals("Quantum") || element.equals("Fire")
				|| element.equals("Ice") || element.equals("Physical") || element.equals("Lightning")
				|| element.equals("Imaginary")));

		do {
			System.out.print(
					"Input Path [ Destruction | Harmony | Erudition | The Hunt | Nihility | Preservation | Abundance ] (Case Sensitive) : ");
			path = sc.nextLine();
		} while (!(path.equals("Destruction") || path.equals("Harmony") || path.equals("Erudition")
				|| path.equals("The Hunt") || path.equals("Nihility") || path.equals("Preservation")
				|| path.equals("Abundance")));

		do {
			System.out.print("Input Attack [ 100 - 5000 ] (Inclusive) : ");
			atk = sc.nextInt();
			sc.nextLine();
		} while (atk < 100 || atk > 5000);

		do {
			System.out.print("Input HP [ 1000 - 10000 ] (Exclusive) : ");
			hp = sc.nextInt();
			sc.nextLine();
		} while (hp <= 1000 || hp >= 10000);

		do {
			System.out.print("Input Def [ 600 - 4000 ] (Inclusive) : ");
			def = sc.nextInt();
			sc.nextLine();
		} while (def < 600 || def > 4000);

		do {
			System.out.print("Input Ability [ Must be atleast 2 words ] : ");
			ability = sc.nextLine();
		} while (!contains2Word(ability));

		id = generateID(name);
	}

	private boolean isAlphabetic(String var) {
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
		splitAbility = var.split(" ");
		return splitAbility.length >= 2;
	}

	private String generateID(String var) {
		return String
				.format("SR-%s-%03d",
						(String.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	private void sortbyName() {
		for (int i = 0; i < ids.size(); i++) {
			for (int j = 0; j < ids.size() - i - 1; j++) {
				if (names.get(j).compareTo(names.get(j + 1)) > 0) {
					String temp = names.get(j);
					names.set(j, names.get(j + 1));
					names.set(j + 1, temp);

					temp = ids.get(j);
					ids.set(j, ids.get(j + 1));
					ids.set(j + 1, temp);

					temp = elements.get(j);
					elements.set(j, elements.get(j + 1));
					elements.set(j + 1, temp);

					temp = abilities.get(j);
					abilities.set(j, abilities.get(j + 1));
					abilities.set(j + 1, temp);

					int temp1 = atks.get(j);
					atks.set(j, atks.get(j + 1));
					atks.set(j + 1, temp1);

					temp1 = defs.get(j);
					defs.set(j, defs.get(j + 1));
					defs.set(j + 1, temp1);

					temp1 = hps.get(j);
					hps.set(j, hps.get(j + 1));
					hps.set(j + 1, temp1);
				}
			}
		}
	}

	private void sortbyID() {
		for (int i = 0; i < ids.size(); i++) {
			for (int j = 0; j < ids.size() - i - 1; j++) {
				if (ids.get(j).compareTo(ids.get(j + 1)) > 0) {
					String temp = names.get(j);
					names.set(j, names.get(j + 1));
					names.set(j + 1, temp);

					temp = ids.get(j);
					ids.set(j, ids.get(j + 1));
					ids.set(j + 1, temp);

					temp = elements.get(j);
					elements.set(j, elements.get(j + 1));
					elements.set(j + 1, temp);

					temp = abilities.get(j);
					abilities.set(j, abilities.get(j + 1));
					abilities.set(j + 1, temp);

					int temp1 = atks.get(j);
					atks.set(j, atks.get(j + 1));
					atks.set(j + 1, temp1);

					temp1 = defs.get(j);
					defs.set(j, defs.get(j + 1));
					defs.set(j + 1, temp1);

					temp1 = hps.get(j);
					hps.set(j, hps.get(j + 1));
					hps.set(j + 1, temp1);
				}
			}
		}
	}

	private void displayTable() {
		String createTable = String.format("| %-14s | %-20s | %-12s | %-12s | %-8s | %-8s | %-8s | %-25s |",
				"Character ID", "Character Name", "Element", "Path", "ATK", "HP", "DEF", "Ability");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < ids.size(); i++) {
			createTable = String.format("| %-14s | %-20s | %-12s | %-12s | %-8d | %-8d | %-8d | %-25s |", ids.get(i),
					names.get(i), elements.get(i), paths.get(i), atks.get(i), hps.get(i), defs.get(i),
					abilities.get(i));
			System.out.println(createTable);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	public static void main(String[] args) {
		new Sesi6();
	}

}
