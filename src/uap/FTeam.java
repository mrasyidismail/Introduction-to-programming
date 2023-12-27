package uap;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class FTeam {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String gameName, gameGenre, gameID, devName, pubName, confirmation, updateID, updateGameName;
	double gamePrice, change, money;
	int menu;

	Vector<String> gameIDs = new Vector<String>();
	Vector<String> gameNames = new Vector<String>();
	Vector<Double> gamePrices = new Vector<Double>();
	Vector<String> gameGenres = new Vector<String>();
	Vector<String> devNames = new Vector<String>();
	Vector<String> pubNames = new Vector<String>();

	public FTeam() {
		do {
			System.out.println("FTeam");
			System.out.println("==========");
			System.out.println("1. Release a game");
			System.out.println("2. View all games");
			System.out.println("3. Update game");
			System.out.println("4. Delete game");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				registerGame();
				break;
			}
			case 2: {
				viewGames();
				break;
			}
			case 3: {
				updateGame();
				break;
			}
			case 4: {
				deleteGame();
				break;
			}
			case 5: {
				System.out.println("Program has been closed !");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 5);
	}

	private void registerGame() {
		do {
			System.out.print("Input Game Name [ Must be alphanumberic and Unique ] : ");
			gameName = sc.nextLine();
		} while (!isAlphanumberic(gameName) || gameNames.contains(gameName));

		do {
			System.out.print("Input Game Price [ Must be more than 10000 ] : ");
			gamePrice = sc.nextDouble();
			sc.nextLine();
		} while (gamePrice <= 10000);

		do {
			System.out.print("Input Game Genre [ MMORPG | RPG | FPS ] (Case Sensitive) : ");
			gameGenre = sc.nextLine();
		} while (!(gameGenre.equals("MMORPG") || gameGenre.equals("RPG") || gameGenre.equals("FPS")));

		do {
			System.out.print("Input Developer Name [ Must be alphabetic and more than 5 characters ] : ");
			devName = sc.nextLine();
		} while (!isAlphabetic(devName) || devName.length() < 5);

		do {
			System.out.print("Input Publisher Name [ Must be more than 3 characters ] : ");
			pubName = sc.nextLine();
		} while (pubName.length() <= 3);

		do {
			System.out.print("Are you sure you want to buy this game [ Y | N ] (Case Sensitive) : ");
			confirmation = sc.nextLine();
		} while (!(confirmation.equals("Y") || confirmation.equals("N")));

		if (confirmation.equals("N"))
			return;

		do {
			System.out.print("Input Money [ >= " + gamePrice + " ] : ");
			money = sc.nextDouble();
			sc.nextLine();
		} while (!(money >= gamePrice));

		gameID = generateID(gameName);
		change = money - gamePrice;

		System.out.println("Change : " + change);

		gameIDs.add(gameID);
		gamePrices.add(gamePrice);
		gameNames.add(gameName);
		gameGenres.add(gameGenre);
		devNames.add(devName);
		pubNames.add(pubName);

		System.out.println("Data has been added !\n");
	}

	private void viewGames() {
		if (gameIDs.isEmpty()) {
			System.out.println("No games have been released yet!\nPress Enter to Continue...");
			sc.nextLine();
		} else {
			sortTable("price");
			String createTable = String.format("| %-15s | %-30s | %-10s | %-20s | %-20s | %-20s |", "Game ID",
					"Game Name", "Genre", "Price", "Developer", "Publisher");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < gameIDs.size(); i++) {
				String createList = String.format("| %-15s | %-30s | %-10s | %-20f | %-20s | %-20s |", gameIDs.get(i),
						gameNames.get(i), gameGenres.get(i), gamePrices.get(i), devNames.get(i), pubNames.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void updateGame() {
		if (gameIDs.isEmpty()) {
			System.out.println("No games have been released yet!\nPress Enter to Continue...");
			sc.nextLine();
		} else {
			sortTable("id");
			String createTable = String.format("| %-15s | %-30s | %-10s | %-20s | %-20s | %-20s |", "Game ID",
					"Game Name", "Genre", "Price", "Developer", "Publisher");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < gameIDs.size(); i++) {
				String createList = String.format("| %-15s | %-30s | %-10s | %-20f | %-20s | %-20s |", gameIDs.get(i),
						gameNames.get(i), gameGenres.get(i), gamePrices.get(i), devNames.get(i), pubNames.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));

			do {
				System.out.print("Input Game ID [ e.g " + gameIDs.get(0) + " ] : ");
				updateID = sc.nextLine();
			} while (!gameIDs.contains(updateID));

			do {
				System.out.print("Update Game Name [ Must be alphanumberic and Unique ] : ");
				updateGameName = sc.nextLine();
			} while (!isAlphanumberic(updateGameName) || gameNames.contains(updateGameName));

			int index = gameIDs.indexOf(updateID);
			gameNames.set(index, updateGameName);

			System.out.println("Successfully Updated game !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deleteGame() {
		if (gameIDs.isEmpty()) {
			System.out.println("No games have been released yet!\nPress Enter to Continue...");
			sc.nextLine();
		} else {
			sortTable("price");
			String createTable = String.format("| %-15s | %-30s | %-10s | %-20s | %-20s | %-20s |", "Game ID",
					"Game Name", "Genre", "Price", "Developer", "Publisher");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < gameIDs.size(); i++) {
				String createList = String.format("| %-15s | %-30s | %-10s | %-20f | %-20s | %-20s |", gameIDs.get(i),
						gameNames.get(i), gameGenres.get(i), gamePrices.get(i), devNames.get(i), pubNames.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));

			do {
				System.out.print("Input Game ID [ e.g " + gameIDs.get(0) + " ] : ");
				updateID = sc.nextLine();
			} while (!gameIDs.contains(updateID));
			int index = gameIDs.indexOf(updateID);

			gameIDs.remove(index);
			gameNames.remove(index);
			gamePrices.remove(index);
			gameGenres.remove(index);
			devNames.remove(index);
			pubNames.remove(index);

			System.out.println("Successfully deleted game!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private boolean isAlphanumberic(String var) {
		boolean isChar = false, isNum = false;
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')
				isChar = true;
			else if (c >= '0' && c <= '9')
				isNum = true;
			else
				return false;
		}
		return isChar && isNum;
	}

	private boolean isAlphabetic(String var) {
		boolean isChar = false;
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')
				isChar = true;
			else
				return false;
		}
		return isChar;
	}

	private String generateID(String var) {
		return String
				.format("FT%s%03d",
						(String.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	private void sortTable(String type) {
		for (int i = 0; i < gameIDs.size(); i++) {
			for (int j = 0; j < gameIDs.size() - 1 - i; j++) {
				if (type.equalsIgnoreCase("price") ? gamePrices.get(j).compareTo(gamePrices.get(j + 1)) < 0
						: gameIDs.get(j).compareTo(gameIDs.get(j + 1)) < 0) {
					Double temp = gamePrices.get(j);
					gamePrices.set(j, gamePrices.get(j + 1));
					gamePrices.set(j + 1, temp);

					String temp1 = gameIDs.get(j);
					gameIDs.set(j, gameIDs.get(j + 1));
					gameIDs.set(j + 1, temp1);

					temp1 = gameNames.get(j);
					gameNames.set(j, gameNames.get(j + 1));
					gameNames.set(j + 1, temp1);

					temp1 = gameGenres.get(j);
					gameGenres.set(j, gameGenres.get(j + 1));
					gameGenres.set(j + 1, temp1);

					temp1 = devNames.get(j);
					devNames.set(j, devNames.get(j + 1));
					devNames.set(j + 1, temp1);

					temp1 = pubNames.get(j);
					pubNames.set(j, pubNames.get(j + 1));
					pubNames.set(j + 1, temp1);
				}
			}
		}
	}

	public static void main(String[] args) {
		new FTeam();
	}

}
