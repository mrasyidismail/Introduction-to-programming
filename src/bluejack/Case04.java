/**
 * @author github.com/mrasyidismail
 */
package bluejack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Case04 {

	public Case04() {
		Scanner scan = new Scanner(System.in);
		String itemName;
		int menu, quantity;
		double price, money;
		String totalPrice, change;

		System.out.println("ES Companies Portal - Cashier App 2");
		System.out.println("===================================");
		System.out.println("1. Keyboard -  $49.99\n2. Mouse   -  $19.99\n3. Monitor   -  $99.99\n4. Exit");
		System.out.print("Choose : ");
		menu = scan.nextInt();
		switch (menu) {
		case 1:
			itemName = "Keyboard";
			price = 49.99;
			break;
		case 2:
			itemName = "Mouse";
			price = 19.99;
			break;
		case 3:
			itemName = "Monitor";
			price = 99.99;
			break;
		case 4:
			System.out.println("Thank you for using this application :D");
			scan.close();
			return;
		default:
			System.out.println("Please enter a valid menu !");
			scan.close();
			return;
		}
		System.out.print("Input Quantity [1..20] : ");
		quantity = scan.nextInt();
		scan.nextLine();
		if (quantity > 20) {
			System.out.println("Out of Stock !");
			System.out.println("\nThank you for using this application :D");
			scan.close();
			return;
		}
		DecimalFormat dc = new DecimalFormat("0.00");
		totalPrice = dc.format((price * quantity));

		System.out.println("\nES Companies Portal - Invoice");
		System.out.println("=================================");
		System.out.println("Item's Name : " + itemName);
		System.out.println("Price       : " + price);
		System.out.println("\nTotal Price : " + totalPrice);
		System.out.print("Enter your money [min " + totalPrice + "] : ");
		money = scan.nextDouble();
		scan.nextLine();
		if (money < Double.parseDouble((totalPrice))) {
			System.out.println("Not enough money !");
			System.out.println("\nThank you for using this application :D");
			scan.close();
			return;
		}
		change = dc.format((money - Double.parseDouble((totalPrice))));
		System.out.println("Thank you for purchashing !");
		System.out.println("Your change : " + change);
		System.out.println("\nThank you for using this application :D");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Case04();
	}

}
