package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan1 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String pokemonName, pokemonType, pokemonID, pokemonAbility, splitAbility[];
	int pokemonHP, pokemonATK, menu;

	Vector<String> pokemonIDs = new Vector<String>();
	Vector<String> pokemonNames = new Vector<String>();
	Vector<String> pokemonTypes = new Vector<String>();
	Vector<Integer> pokemonHPs = new Vector<Integer>();
	Vector<Integer> pokemonATKs = new Vector<Integer>();
	Vector<String> pokemonAbilities = new Vector<String>();

	public Latihan1() {
		do {
			System.out.println("FokemonT");
			System.out.println("================");
			System.out.println("1. Insert a FokemonT");
			System.out.println("2. View Fokedex");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				insertPokemon();
				break;
			}
			case 2: {
				viewPokedex();
				break;
			}
			case 3: {
				System.out.println("Thank you :)");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void insertPokemon() {
		do {
			System.out.print("Input FokemonT Name [ Must be alphabetic and Unique ] : ");
			pokemonName = sc.nextLine();
		} while (!isAlphabetic(pokemonName) || pokemonNames.contains(pokemonName));

		do {
			System.out.print("Input FokemonT Type [ Fire | Grass | Water ] (Case Sensitive) : ");
			pokemonType = sc.nextLine();
		} while (!(pokemonType.equals("Fire") || pokemonType.equals("Grass") || pokemonType.equals("Water")));

		do {
			System.out.print("Input FokemonT Hp [ Must be between 100 - 1000 ] (Inclusive) : ");
			pokemonHP = sc.nextInt();
			sc.nextLine();
		} while (pokemonHP < 100 || pokemonHP > 1000);

		do {
			System.out.print("Input FokemonT Attack [ Must be between 100 - 200 ] (Exclusive) : ");
			pokemonATK = sc.nextInt();
			sc.nextLine();
		} while (pokemonATK <= 100 || pokemonATK >= 200);

		do {
			System.out.print("Input FokemonT Abilities [ Must contain atleast 2 words ] : ");
			pokemonAbility = sc.nextLine();
		} while (!contains2Word(pokemonAbility));

		pokemonID = generateID(pokemonName);

		pokemonIDs.add(pokemonID);
		pokemonNames.add(pokemonName);
		pokemonTypes.add(pokemonType);
		pokemonHPs.add(pokemonHP);
		pokemonATKs.add(pokemonATK);
		pokemonAbilities.add(pokemonAbility);
		System.out.println("Data has been added !\n");

	}

	private void viewPokedex() {
		if (pokemonIDs.isEmpty()) {
			System.out.println("There is no FokemonT!\nPress Enter to Continue...\n");
			sc.nextLine();
		} else {
			String createTables = String.format("| %-11s | %-20s | %-15s | %-5s | %-7s | %-20s |", "FokemonT ID",
					"FokemonT Name", "FokemonT Type", "HP", "Attack", "Abilities");
			System.out.println("-".repeat(createTables.length()));
			System.out.println(createTables);
			System.out.println("-".repeat(createTables.length()));

			for (int i = 0; i < pokemonIDs.size(); i++) {
				String createList = String.format("| %-11s | %-20s | %-15s | %-5d | %-7d | %-20s |", pokemonIDs.get(i),
						pokemonNames.get(i), pokemonTypes.get(i), pokemonHPs.get(i), pokemonATKs.get(i),
						pokemonAbilities.get(i));
				System.out.println(createList);
			}
			System.out.println("-".repeat(createTables.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private boolean isAlphabetic(String var) {
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
				return true;

		}
		return false;
	}

	private boolean contains2Word(String var) {
		splitAbility = var.split(" ");
		return splitAbility.length >= 2;
	}

	private String generateID(String var) {
		return String
				.format("PI%s%03d",
						(Character.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	public static void main(String[] args) {
		new Latihan1();
	}

}
