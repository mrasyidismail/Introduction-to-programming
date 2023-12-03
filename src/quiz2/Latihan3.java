package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan3 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String customerName, franchiseName, foodName, orderNote, splitNotes[], orderId, confirmation;
	int menu, quantity;
	double tax, foodPrice, totalPrice;

	Vector<String> orderIds = new Vector<String>();
	Vector<String> customerNames = new Vector<String>();
	Vector<String> franchiseNames = new Vector<String>();
	Vector<String> foodNames = new Vector<String>();
	Vector<Integer> quantities = new Vector<Integer>();
	Vector<String> orderNotes = new Vector<String>();
	Vector<Double> totalPrices = new Vector<Double>();

	public Latihan3() {
		do {
			System.out.print("goFot\n======\n1. Order goFoT\n2. View all Order History\n3. Exit\n>> ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1: {
				ordergoFot();
				break;
			}
			case 2: {
				viewOrderHistory();
				break;
			}
			case 3: {
				System.out.println("Good Luck Have Fun :)");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void ordergoFot() {
		do {
			System.out
					.print("Input Customer Name [ Must be between 7 - 15 characters and starts with Mr. or Mrs. ] : ");
			customerName = sc.nextLine();
		} while ((customerName.length() < 7 || customerName.length() > 15)
				|| !(customerName.startsWith("Mr.") || customerName.startsWith("Mrs.")));

		do {
			System.out.print("Input Franchise Name [ Fkc | Cmd ] (Case Insensitive) : ");
			franchiseName = sc.nextLine();
		} while (!(franchiseName.equalsIgnoreCase("Fkc") || franchiseName.equalsIgnoreCase("Cmd")));

		do {
			System.out.print("Input Food Name [ Burger | Fried Chicken | French Fries ] (Case Sensitive): ");
			foodName = sc.nextLine();
		} while (!(foodName.equals("Burger") || foodName.equals("Fried Chicken") || foodName.equals("French Fries")));

		do {
			System.out.print("Input Order Note [ Must contain atleast 2 words and contain Thank You ] : ");
			orderNote = sc.nextLine();
		} while (!contain2Words(orderNote) || !(orderNote.contains("Thank You")));

		do {
			System.out.print("Input Quantity [ Must be more than 0 ] : ");
			quantity = sc.nextInt();
			sc.nextLine();
		} while (quantity <= 0);

		if (foodName.equals("Burger"))
			foodPrice = 17000;
		else if (foodName.equals("Fried Chicken"))
			foodPrice = 22000;
		else
			foodPrice = 12000;

		tax = (foodPrice * quantity) * (double) 10 / 100;
		totalPrice = (foodPrice * quantity) + tax;

		orderId = generateID(franchiseName);
		int barrier = 15;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Order Information",
				" ".repeat(barrier));

		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf("| %-" + "Franchise Name".length() + "s : %-"
				+ (createTable.length() - "Franchise Name : ".length() - 4) + "s |\n", "Order ID", orderId);
		System.out.printf(
				"| %-" + "Franchise Name".length() + "s : %-"
						+ (createTable.length() - "Franchise Name : ".length() - 4) + "s |\n",
				"Customer Name", customerName);
		System.out.printf("| %-" + "Franchise Name".length() + "s : %-"
				+ (createTable.length() - "Franchise Name : ".length() - 4) + "s |\n", "Food Name", foodName);
		System.out.printf("| %-" + "Franchise Name".length() + "s : %-"
				+ (createTable.length() - "Franchise Name : ".length() - 4) + "f |\n", "Food Price", foodPrice);
		System.out.printf("| %-" + "Franchise Name".length() + "s : %-"
				+ (createTable.length() - "Franchise Name : ".length() - 4) + "d |\n", "Quantity", quantity);
		System.out.printf("| %-" + "Franchise Name".length() + "s : %-"
				+ (createTable.length() - "Franchise Name : ".length() - 4) + "s |\n", "Order Note", orderNote);
		System.out.printf(
				"| %-" + "Franchise Name".length() + "s : %-"
						+ (createTable.length() - "Franchise Name : ".length() - 4) + "s |\n",
				"Franchise Name", franchiseName.toUpperCase());
		System.out.printf("| %-" + "Franchise Name".length() + "s : %-"
				+ (createTable.length() - "Franchise Name : ".length() - 4) + "f |\n", "Tax", tax);
		System.out.printf(
				"| %-" + "Franchise Name".length() + "s : %-"
						+ (createTable.length() - "Franchise Name : ".length() - 4) + "f |\n",
				"Total Price", totalPrice);
		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Confirm Order [ y | n ] (Case Sensitive) : ");
			confirmation = sc.nextLine();
		} while (!(confirmation.equals("y") || confirmation.equals("n")));

		if (confirmation.equals("y")) {
			System.out.println("Success Order!\n");
			orderIds.add(orderId);
			customerNames.add(customerName);
			franchiseNames.add(franchiseName.toUpperCase());
			foodNames.add(foodName);
			quantities.add(quantity);
			orderNotes.add(orderNote);
			totalPrices.add(totalPrice);
		}

	}

	private void viewOrderHistory() {
		if (orderIds.isEmpty()) {
			System.out.println("There is no order history !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-12s | %-20s | %-15s | %-14s | %-10s | %-30s | %-15s |", "Order ID",
					"Customer Name", "Franchise Name", "Food Name", "Quantity", "Order Note", "Total Price");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));

			for (int i = 0; i < orderNotes.size(); i++) {
				String createList = String.format("| %-12s | %-20s | %-15s | %-14s | %-10d | %-30s | %-15f |",
						orderIds.get(i), customerNames.get(i), franchiseNames.get(i), foodNames.get(i),
						quantities.get(i), orderNotes.get(i), totalPrices.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}

	}

	private boolean contain2Words(String var) {
		splitNotes = var.split(" ");
		return splitNotes.length >= 3;
	}

	private String generateID(String var) {
		return String
				.format("RI%s%03d",
						(String.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	public static void main(String[] args) {
		new Latihan3();
	}

}
