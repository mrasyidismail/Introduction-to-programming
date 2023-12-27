package uap;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class FokemonT {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String pokemonName, pokemonType, pokemonAbility, splitAbilities[], pokemonId;
	int pokemonHP, pokemonATK, menu, index;

	Vector<String> pokemonIds = new Vector<String>();
	Vector<String> pokemonNames = new Vector<String>();
	Vector<String> pokemonTypes = new Vector<String>();
	Vector<String> pokemonAbilities = new Vector<String>();
	Vector<Integer> pokemonHPs = new Vector<Integer>();
	Vector<Integer> pokemonATKs = new Vector<Integer>();

	public FokemonT() {
		do {
			System.out.println("FokemonT");
			System.out.println("===========");
			System.out.println("1. Insert a FokemonT");
			System.out.println("2. View Fokedex");
			System.out.println("3. Update FokemonT");
			System.out.println("4. Delete FokemonT");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				insertFokemonT();
				break;
			}
			case 2: {
				viewFokedex();
				break;
			}
			case 3: {
				updateFokemonT();
				break;
			}
			case 4: {
				deleteFokemonT();
				break;
			}
			case 5: {
				System.out.println("Thank You :)");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 5);
	}

	private void insertFokemonT() {
		do {
			System.out.print("Input FokemonT Name [ Must be alphabetic and Unique ] : ");
			pokemonName = sc.nextLine();
		} while (!isAlphabetic(pokemonName) || pokemonNames.contains(pokemonName));

		do {
			System.out.print("Input FokemonT Type [ Fire | Grass | Water ] (Case Sensitive) : ");
			pokemonType = sc.nextLine();
		} while (!(pokemonType.equals("Fire") || pokemonType.equals("Grass") || pokemonType.equals("Water")));

		do {
			System.out.print("Input FokemonT HP [ 100 - 1000 ] (Inclusive) : ");
			pokemonHP = sc.nextInt();
			sc.nextLine();
		} while (pokemonHP < 100 || pokemonHP > 1000);

		do {
			System.out.print("Input FokemonT Attack [ 100 - 200 ] (Exclusive) : ");
			pokemonATK = sc.nextInt();
			sc.nextLine();
		} while (pokemonATK <= 100 || pokemonATK >= 200);

		do {
			System.out.print("Input FokemonT Abilities [ Must contain atleast 2 words ] : ");
			pokemonAbility = sc.nextLine();
			splitAbilities = pokemonAbility.split(" ");
		} while (splitAbilities.length < 2);

		pokemonId = generateID(pokemonName);

		pokemonIds.add(pokemonId);
		pokemonNames.add(pokemonName);
		pokemonTypes.add(pokemonType);
		pokemonATKs.add(pokemonATK);
		pokemonHPs.add(pokemonHP);
		pokemonAbilities.add(pokemonAbility);
	}

	private void viewFokedex() {
		if (pokemonIds.isEmpty()) {
			System.out.println("There is no FokemonT !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortByID();
			String createTable = String.format("| %-5s | %-12s | %-20s | %-15s | %-7s | %-9s | %-20s |", "No",
					"FokemonT ID", "FokemonT Name", "FokemonT Type", "HP", "Attack", "Abilities");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < pokemonIds.size(); i++) {
				String createList = String.format("| %-5d | %-12s | %-20s | %-15s | %-7d | %-9d | %-20s |", (i + 1),
						pokemonIds.get(i), pokemonNames.get(i), pokemonTypes.get(i), pokemonHPs.get(i),
						pokemonATKs.get(i), pokemonAbilities.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void updateFokemonT() {
		if (pokemonIds.isEmpty()) {
			System.out.println("There is no FokemonT !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortByID();
			String createTable = String.format("| %-5s | %-12s | %-20s | %-15s | %-7s | %-9s | %-20s |", "No",
					"FokemonT ID", "FokemonT Name", "FokemonT Type", "HP", "Attack", "Abilities");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < pokemonIds.size(); i++) {
				String createList = String.format("| %-5d | %-12s | %-20s | %-15s | %-7d | %-9d | %-20s |", (i + 1),
						pokemonIds.get(i), pokemonNames.get(i), pokemonTypes.get(i), pokemonHPs.get(i),
						pokemonATKs.get(i), pokemonAbilities.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));

			do {
				System.out.print("Input FokemonT Number [ 1 - " + pokemonIds.size() + " ] : ");
				index = sc.nextInt();
				sc.nextLine();
			} while (index < 1 || index > pokemonIds.size());

			do {
				System.out.print("Input FokemonT Type [ Fire | Grass | Water ] (Case Sensitive) : ");
				pokemonType = sc.nextLine();
			} while (!(pokemonType.equals("Fire") || pokemonType.equals("Grass") || pokemonType.equals("Water")));

			pokemonTypes.set(index - 1, pokemonType);

			System.out.println("Successfully Updated FokemonT !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deleteFokemonT() {
		if (pokemonIds.isEmpty()) {
			System.out.println("There is no FokemonT !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortByID();
			String createTable = String.format("| %-5s | %-12s | %-20s | %-15s | %-7s | %-9s | %-20s |", "No",
					"FokemonT ID", "FokemonT Name", "FokemonT Type", "HP", "Attack", "Abilities");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < pokemonIds.size(); i++) {
//				String createList = String.format("| %-5d | %-12s | %-20s | %-15s | %-7d | %-9d | %-20s |", (i + 1),
//						pokemonIds.get(i), pokemonNames.get(i), pokemonTypes.get(i), pokemonHPs.get(i),
//						pokemonATKs.get(i), pokemonAbilities.get(i));
//				System.out.println(createList);
				
				System.out.println("No : " + (i + 1));
			}
			System.out.println("=".repeat(createTable.length()));

			do {
				System.out.print("Input FokemonT Number [ 1 - " + pokemonIds.size() + " ] : ");
				index = sc.nextInt();
				sc.nextLine();
			} while (index < 1 || index > pokemonIds.size());

			index = index - 1;
			pokemonIds.remove(index);
			pokemonAbilities.remove(index);
			pokemonATKs.remove(index);
			pokemonHPs.remove(index);
			pokemonNames.remove(index);
			pokemonTypes.remove(index);

			System.out.println("Successfully Deleted FokemonT !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
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

	private String generateID(String var) {
		return String
				.format("PI%s%03d",
						(String.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	private void sortByID() {
		for (int i = 0; i < pokemonIds.size(); i++) {
			for (int j = 0; j < pokemonIds.size() - i - 1; j++) {
				if (pokemonIds.get(j).compareTo(pokemonIds.get(j + 1)) > 0) {
					String temp = pokemonIds.get(j);
					pokemonIds.set(j, pokemonIds.get(j + 1));
					pokemonIds.set(j + 1, temp);

					temp = pokemonNames.get(j);
					pokemonNames.set(j, pokemonNames.get(j + 1));
					pokemonNames.set(j + 1, temp);

					temp = pokemonTypes.get(j);
					pokemonTypes.set(j, pokemonTypes.get(j + 1));
					pokemonTypes.set(j + 1, temp);

					temp = pokemonAbilities.get(j);
					pokemonAbilities.set(j, pokemonAbilities.get(j + 1));
					pokemonAbilities.set(j + 1, temp);

					int temp1 = pokemonATKs.get(j);
					pokemonATKs.set(j, pokemonATKs.get(j + 1));
					pokemonATKs.set(j + 1, temp1);

					temp1 = pokemonHPs.get(j);
					pokemonHPs.set(j, pokemonHPs.get(j + 1));
					pokemonHPs.set(j + 1, temp1);
				}
			}
		}
	}

	public static void main(String[] args) {
		new FokemonT();
	}

}
