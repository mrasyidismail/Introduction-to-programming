/**
 * @author github.com/mrasyidismail
 */
package quiz;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan7 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	Vector<String> customerName = new Vector<String>();
	Vector<String> coffeeName = new Vector<String>();
	Vector<String> cupSize = new Vector<String>();
	Vector<Integer> quantity = new Vector<Integer>();
	Vector<Double> totalPrice = new Vector<Double>();
	Vector<String> orderID = new Vector<String>();

	String custName, coffName, cSize;
	int menu, qty, coffeePrice, cupPrice;
	double tax, tPrice, money, change;

	public Latihan7() {
		do {
			System.out.println("Janji efte coffee");
			System.out.println("1. Order Coffee");
			System.out.println("2. View Order History");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				orderCoffee();
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

	public void orderCoffee() {
		do {
			System.out.print("Input Customer Name [ Must be alphanumeric ]: ");
			custName = sc.nextLine();
		} while (!custName.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$"));

		do {
			System.out.print("Input Coffee Name [ Caffe Latte | Caramel Macchiato | Espresso ] (Case Sensitive) : ");
			coffName = sc.nextLine();
		} while (!(coffName.equals("Caffe Latte") || coffName.equals("Caramel Macchiato")
				|| coffName.equals("Espresso")));

		do {
			System.out.print("Input Cup Size [ Small | Medium ] (Case Insensitive): ");
			cSize = sc.nextLine();
		} while (!(cSize.equalsIgnoreCase("Small") || cSize.equalsIgnoreCase("Medium")));

		do {
			System.out.print("Input Quantity [ Must be more than 0 ]: ");
			qty = sc.nextInt();
			sc.nextLine();
		} while (qty <= 0);

		if (coffName.equals("Caffe Latte"))
			coffeePrice = 30000;
		else if (coffName.equals("Caramel Macchiato"))
			coffeePrice = 35000;
		else
			coffeePrice = 40000;

		if (cSize.equalsIgnoreCase("Small"))
			cupPrice = 3000;
		else
			cupPrice = 5000;

		tPrice = (qty * coffeePrice) + cupPrice;
		tax = tPrice * (double) 10 / 100;
		tPrice = tPrice + tax;

		String id = String.format("OI%03d", (rand.nextInt(999) + 1));
		System.out.println("============================================");
		System.out.println("|              Order Information            |");
		System.out.println("============================================");
		System.out.println("| Order ID          : " + id);
		System.out.println("| Customer Name     : " + custName);
		System.out.println("| Coffee Name       : " + coffName);
		System.out.println("| Cup Size          : " + cSize);
		System.out.println("| Quantity          : " + qty);
		System.out.println("| Total Price       : " + tPrice);
		System.out.println("============================================");
		System.out.println();

		do {
			System.out.print("Input Money [ >= Total Price ] : ");
			money = sc.nextDouble();
			sc.nextLine();
		} while (!(money >= tPrice));

		change = money - tPrice;
		System.out.println("Change : " + change);

		System.out.println("\nThank You :)");

		System.out.println("Press Enter to Continue...");
		sc.nextLine();

		orderID.add(id);
		customerName.add(custName);
		coffeeName.add(coffName);
		cupSize.add(cSize);
		quantity.add(qty);
		totalPrice.add(tPrice);
	}

	public void viewOrder() {
		if (orderID.size() == 0) {
			System.out.println("There is no order history!\n\nPress Enter to Continue...");
			sc.nextLine();
		} else {
			System.out.println("=====================================================================");
			System.out.println("Order ID - Customer Name - Coffee Name - Cup Size - Quantity - Total Price");
			System.out.println("=====================================================================");
			for (int i = 0; i < orderID.size(); i++) {
				System.out.println(orderID.get(i) + " - " + customerName.get(i) + " - " + coffeeName.get(i) + " - "
						+ cupSize.get(i) + " - " + quantity.get(i) + " - " + totalPrice.get(i));
			}
			System.out.println("=====================================================================");
		}
	}

	public static void main(String[] args) {
		new Latihan7();
	}
}