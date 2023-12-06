package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan5 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String customerName, foodName, paymentMethod, billId;
	int foodPrice, paymentPoint, quantity, menu;

	double totalPrice, totalDiscount, money, change;

	Vector<String> billIds = new Vector<String>();
	Vector<String> customerNames = new Vector<String>();
	Vector<String> foodNames = new Vector<String>();
	Vector<Integer> quantities = new Vector<Integer>();
	Vector<String> paymentMethods = new Vector<String>();
	Vector<Double> totalPrices = new Vector<Double>();

	public Latihan5() {
		do {
			System.out.println("Bakmi eFeTe");
			System.out.println("1. Order Menu");
			System.out.println("2. View Order History");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				orderMenu();
				break;
			}
			case 2: {
				viewOrderHistory();
				break;
			}
			case 3: {
				System.out.println("Nyam nyam nyam :)");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void orderMenu() {
		do {
			System.out.print("Input Customer Name [ Must be more than 5 characters ] : ");
			customerName = sc.nextLine();
		} while (customerName.length() < 5);

		do {
			System.out.print("Input Food Name [ Bakmi Keriting | Bakmi Lebar ] (Case Insensitive) : ");
			foodName = sc.nextLine();
		} while (!(foodName.equalsIgnoreCase("Bakmi Keriting") || foodName.equalsIgnoreCase("Bakmi Lebar")));

		do {
			System.out.print("Input Food Price [ Must be more than 10000 ] : ");
			foodPrice = sc.nextInt();
			sc.nextLine();
		} while (foodPrice <= 10000);

		do {
			System.out.print("Input Quantity [ Must be more than 0 ] : ");
			quantity = sc.nextInt();
			sc.nextLine();
		} while (quantity <= 0);

		do {
			System.out.print("Input Payment Method [ Cash | Transfer | QRIS ] (Case Sensitive) : ");
			paymentMethod = sc.nextLine();
		} while (!(paymentMethod.equals("Cash") || paymentMethod.equals("Transfer") || paymentMethod.equals("QRIS")));

		if (paymentMethod.equals("Cash"))
			paymentPoint = 0;
		else if (paymentMethod.equals("Transfer"))
			paymentPoint = 5;
		else
			paymentPoint = 10;

		totalDiscount = customerName.length() + paymentPoint;

		totalPrice = (foodPrice * quantity) - ((double) (foodPrice * quantity) * (totalDiscount / 100));

		billId = String.format("BI%03d", (rand.nextInt(999) + 1));

		int barrier = 15;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Bill", " ".repeat(barrier));
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "s |\n", "Bill ID", billId);
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "s |\n", "Customer Name", customerName);
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "s |\n", "Food Name", foodName);
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "d |\n", "Food Price", foodPrice);
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "d |\n", "Quantity", quantity);
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "f |\n", "Total Discount", totalDiscount);
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "f |\n", "Total Price", totalPrice);
		System.out.printf("| %-" + "Payment Method".length() + "s : %-"
				+ (createTable.length() - "Payment Method :".length() - 5) + "s |\n", "Payment Method", paymentMethod);
		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Input Money [ >= " + totalPrice + " ] : ");
			money = sc.nextDouble();
			sc.nextLine();
		} while (!(money >= totalPrice));

		change = money - totalPrice;
		System.out.println("Change : " + change);

		System.out.println("\nThank you for your purchase :)\n");

		billIds.add(billId);
		customerNames.add(customerName);
		foodNames.add(foodName);
		quantities.add(quantity);
		paymentMethods.add(paymentMethod);
		totalPrices.add(totalPrice);
	}

	private void viewOrderHistory() {
		if (billIds.isEmpty()) {
			System.out.println("There is no order history!");
			System.out.println("Press Enter To Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-12s | %-20s | %-20s | %-13s | %-20s | %-15s |", "Order ID",
					"Customer Name", "Food Name", "Quantity", "Payment Method", "Total Price");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < billIds.size(); i++) {
				String createList = String.format("| %-12s | %-20s | %-20s | %-13d | %-20s | %-15f |", billIds.get(i),
						customerNames.get(i), foodNames.get(i), quantities.get(i), paymentMethods.get(i),
						totalPrices.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	public static void main(String[] args) {
		new Latihan5();
	}

}
