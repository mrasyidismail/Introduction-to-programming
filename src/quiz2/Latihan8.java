package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan8 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String customerName, coffeeName, cupSize, orderId;
	int quantity, menu;

	double coffeePrice, cupPrice, totalPrice, tax, money, change;

	Vector<String> orderIds = new Vector<String>();
	Vector<String> customerNames = new Vector<String>();
	Vector<String> coffeeNames = new Vector<String>();
	Vector<String> cupSizes = new Vector<String>();
	Vector<Integer> quantities = new Vector<Integer>();
	Vector<Double> totalPrices = new Vector<Double>();

	public Latihan8() {
		do {
			System.out.println("Janji efte coffee");
			System.out.println("================");
			System.out.println("1. Order Coffee");
			System.out.println("2. View Order History");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				orderCofee();
				break;
			}
			case 2: {
				viewOrder();
				break;
			}
			case 3: {
				System.out.println("Program has been closed !");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void orderCofee() {
		do {
			System.out.print("Input Customer Name [ Must be alphanumeric ] : ");
			customerName = sc.nextLine();
		} while (!isAlphanumeric(customerName));

		do {
			System.out.print("Input Coffee Name [ Caffe Latte | Caramel Macchiato | Espresso ] (Case Senstive) : ");
			coffeeName = sc.nextLine();
		} while (!(coffeeName.equals("Caffe Latte") || coffeeName.equals("Caramel Macchiato")
				|| coffeeName.equals("Espresso")));

		do {
			System.out.print("Input Cup Size [ Small | Medium ] (Case Insensitive) : ");
			cupSize = sc.nextLine();
		} while (!(cupSize.equalsIgnoreCase("Small") || cupSize.equalsIgnoreCase("Medium")));

		do {
			System.out.print("Input Quantity [ Must be more than 0 ] : ");
			quantity = sc.nextInt();
			sc.nextLine();
		} while (quantity <= 0);

		if (coffeeName.equals("Caffe Latte"))
			coffeePrice = 30000;
		else if (coffeeName.equals("Caramel Macchiato"))
			coffeePrice = 35000;
		else
			coffeePrice = 40000;

		if (cupSize.equalsIgnoreCase("Small"))
			cupPrice = 3000;
		else
			cupPrice = 5000;

		totalPrice = (quantity * coffeePrice) + cupPrice;
		tax = ((quantity * coffeePrice) + cupPrice) * (double) 10 / 100;
		totalPrice = totalPrice + tax;

		orderId = String.format("OI%03d", (rand.nextInt(999) + 1));

		int barrier = 15;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Order Information",
				" ".repeat(barrier));

		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf("| %-" + "Customer Name".length() + "s : %-"
				+ (createTable.length() - "Customer Name :".length() - 5) + "s |\n", "Order ID", orderId);
		System.out.printf("| %-" + "Customer Name".length() + "s : %-"
				+ (createTable.length() - "Customer Name :".length() - 5) + "s |\n", "Customer Name", customerName);
		System.out.printf("| %-" + "Customer Name".length() + "s : %-"
				+ (createTable.length() - "Customer Name :".length() - 5) + "s |\n", "Coffee Name", coffeeName);
		System.out.printf("| %-" + "Customer Name".length() + "s : %-"
				+ (createTable.length() - "Customer Name :".length() - 5) + "d |\n", "Quantity", quantity);
		System.out.printf("| %-" + "Customer Name".length() + "s : %-"
				+ (createTable.length() - "Customer Name :".length() - 5) + "f |\n", "Total Price", totalPrice);
		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Input Money [ >= " + totalPrice + " ] : ");
			money = sc.nextDouble();
			sc.nextLine();
		} while (!(money >= totalPrice));

		change = money - totalPrice;
		System.out.println("Change : " + change);
		System.out.println("\nPress Enter to Continue...");
		sc.nextLine();

		orderIds.add(orderId);
		customerNames.add(customerName);
		coffeeNames.add(coffeeName);
		cupSizes.add(cupSize);
		quantities.add(quantity);
		totalPrices.add(totalPrice);
	}

	private void viewOrder() {
		if (orderIds.isEmpty()) {
			System.out.println("There is no order history!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-13s | %-25s | %-25s | %-15s | %-10s | %-25s |", "Order ID",
					"Customer Name", "Coffee Name", "Cup Size", "Quantity", "Total Price");

			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < orderIds.size(); i++) {
				String createList = String.format("| %-13s | %-25s | %-25s | %-15s | %-10d | %-25f |", orderIds.get(i),
						customerNames.get(i), coffeeNames.get(i), cupSizes.get(i), quantities.get(i),
						totalPrices.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private boolean isAlphanumeric(String var) {
		boolean isNum = false, isChar = false;
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
				isChar = true;
			else if (c >= '0' && c <= '9')
				isNum = true;

			if (isNum && isChar)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new Latihan8();
	}

}
