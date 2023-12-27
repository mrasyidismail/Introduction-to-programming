package uap;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class GNBatik {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String batikName, batikPattern, batikSize, batikId;
	int batikPrice, menu;
	double total, average;

	Vector<String> batikNames = new Vector<String>();
	Vector<String> batikPatterns = new Vector<String>();
	Vector<String> batikSizes = new Vector<String>();
	Vector<Integer> batikPrices = new Vector<Integer>();
	Vector<String> batikIds = new Vector<String>();

	public GNBatik() {
		do {
			System.out.println("GNBatik");
			System.out.println("=======");
			System.out.println("1. Create Batik");
			System.out.println("2. View Batiks");
			System.out.println("3. Delete Batik");
			System.out.println("4. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				createBatik();
				break;
			}
			case 2: {
				viewBatik();
				break;
			}
			case 3: {
				deleteBatik();
				break;
			}
			case 4: {
				System.out.println("Program has been closed !");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 4);
	}

	private void createBatik() {
		do {
			System.out.print("Input Batik Name [ Must starts with 'Batik' and Unique ] : ");
			batikName = sc.nextLine();
		} while (!(batikName.startsWith("Batik") && !batikNames.contains(batikName)));

		do {
			System.out.print("Input Batik Pattern [ Kawung | Parang | Gendongan ] (Case Sensitive) : ");
			batikPattern = sc.nextLine();
		} while (!(batikPattern.equals("Kawung") || batikPattern.equals("Parang") || batikPattern.equals("Gendongan")));

		do {
			System.out.print("Input Batik Size [ S | M | L ] (Case Sensitive) : ");
			batikSize = sc.nextLine();
		} while (!(batikSize.equals("S") || batikSize.equals("M") || batikSize.equals("L")));

		do {
			System.out.print("Input Batik Price [ 100000 - 1000000 ] (Inclusive) : ");
			batikPrice = sc.nextInt();
			sc.nextLine();
		} while (batikPrice < 100000 || batikPrice > 1000000);

		batikId = generateID();
		batikIds.add(batikId);
		batikNames.add(batikName);
		batikPatterns.add(batikPattern);
		batikSizes.add(batikSize);
		batikPrices.add(batikPrice);

		System.out.println(batikName + " successfully added to the data !");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private void viewBatik() {
		if (batikIds.isEmpty()) {

		} else {

		}
	}

	private void deleteBatik() {
		// TODO Auto-generated method stub

	}

	private String generateID() {
		return String.format("BA%03d", (rand.nextInt(999) + 1));
	}

	private void displayTable(boolean isEmpty) {
		String createTable = String.format("| %-5s | %-5 | %-20s | %-20s | %-7s | %-15s |", "No.", "ID", "Batik Name",
				"Batik Pattern", "Size", "Price");

		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		if (isEmpty) {

		} else {

		}
		System.out.println("=".repeat(createTable.length()));
	}

	public static void main(String[] args) {
		new GNBatik();
	}

}
