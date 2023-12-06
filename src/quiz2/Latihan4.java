package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan4 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String customerName, drinkName, cupType, paymentMethod, billId;
	int menu, paymentPoint, quantity;

	double totalPrice, totalDiscount, money, change;
	int drinkPrice, cupPrice;

	Vector<String> billIds = new Vector<String>();
	Vector<String> customerNames = new Vector<String>();
	Vector<String> drinkNames = new Vector<String>();
	Vector<String> cupTypes = new Vector<String>();
	Vector<Integer> quantities = new Vector<Integer>();
	Vector<String> paymentMethods = new Vector<String>();
	Vector<Double> totalPrices = new Vector<Double>();

	public Latihan4() {
		do {
			System.out.println("FixTue");
			System.out.println("======");
			System.out.println("1. Order Drink");
			System.out.println("2. View all Order History");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				orderDrink();
				break;
			}
			case 2: {
				viewOrderHistory();
				break;
			}
			case 3: {
				System.out.println("Never Give Up :)");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void orderDrink() {
		do {
			System.out.print("Input Customer Name [ Must be between 5 - 15 Characters ] (Inclusive) : ");
			customerName = sc.nextLine();
		} while (customerName.length() < 5 || customerName.length() > 15);

		do {
			System.out.print("Input Drink Name [ Brown Sugar | Red Bean | Oats ] (Case Sensitive) : ");
			drinkName = sc.nextLine();
		} while (!(drinkName.equals("Brown Sugar") || drinkName.equals("Red Bean") || drinkName.equals("Oats")));

		do {
			System.out.print("Input Cup Type [ Small | Medium | Large ] (Case Sensitive) : ");
			cupType = sc.nextLine();
		} while (!(cupType.equals("Small") || cupType.equals("Medium") || cupType.equals("Large")));

		do {
			System.out.print("Input Quantity [ Must be more than 0 ] : ");
			quantity = sc.nextInt();
			sc.nextLine();
		} while (quantity <= 0);

		do {
			System.out.print("Input Payment Method [ Transfer | QRIS ] (Case Sensitive) : ");
			paymentMethod = sc.nextLine();
		} while (!(paymentMethod.equals("Transfer") || paymentMethod.equals("QRIS")));

		if (drinkName.equals("Brown Sugar"))
			drinkPrice = 20000;
		else if (drinkName.equals("Red Bean"))
			drinkPrice = 17000;
		else
			drinkPrice = 15000;

		if (cupType.equals("Small"))
			cupPrice = 0;
		else if (cupType.equals("Medium"))
			cupPrice = 2000;
		else
			cupPrice = 5000;

		if (paymentMethod.equals("Transfer"))
			paymentPoint = 5;
		else
			paymentPoint = 10;

		totalPrice = (drinkPrice + cupPrice) * quantity;

		if (totalPrice > 100000) {
			totalDiscount = customerName.length() + paymentPoint;
			totalPrice = totalPrice - (totalPrice * (totalDiscount / 100));
		}

		billId = String.format("BL%03d", (rand.nextInt(999) + 1));

		int barrier = 10;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Bill Information",
				" ".repeat(barrier));

		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "s |\n",
				"Bill ID", billId);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "s |\n",
				"Customer Name", customerName);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "s |\n",
				"Drink Name", drinkName);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "d |\n",
				"Drink Price", drinkPrice);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "s |\n",
				"Cup Type", cupType);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "d |\n",
				"Cup Price", cupPrice);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "d |\n",
				"Quantity", quantity);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "s |\n",
				"Payment Method", paymentMethod);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "f |\n",
				"Total Discount", totalDiscount);
		System.out.printf(
				"| %-" + "Total Discount".length() + "s : %-"
						+ (createTable.length() - "Payment Method".length() - paymentMethod.length() - 3) + "f |\n",
				"Total Price", totalPrice);
		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Input Money [ >= " + totalPrice + " ] : ");
			money = sc.nextDouble();
			sc.nextLine();
		} while (!(money >= totalPrice));

		change = money - totalPrice;
		System.out.println("Change : " + change);
		System.out.println("\nThank You :)\n");

		billIds.add(billId);
		customerNames.add(customerName);
		drinkNames.add(drinkName);
		cupTypes.add(cupType);
		quantities.add(quantity);
		paymentMethods.add(paymentMethod);
		totalPrices.add(totalPrice);

	}

	private void viewOrderHistory() {
		if (billIds.isEmpty()) {
			System.out.println("There is no order history!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-13s | %-20s | %-20s | %-15s | %-10s | %-20s | %-20s | ", "Order ID",
					"Customer Name", "Drink Name", "Cup Type", "Quantity", "Payment Method", "Total Price");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));

			for (int i = 0; i < billIds.size(); i++) {
				String createList = String.format("| %-13s | %-20s | %-20s | %-15s | %-10d | %-20s | %-20f | ",
						billIds.get(i), customerNames.get(i), drinkNames.get(i), cupTypes.get(i), quantities.get(i),
						paymentMethods.get(i), totalPrices.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}

	}

	public static void main(String[] args) {
		new Latihan4();
	}

}
