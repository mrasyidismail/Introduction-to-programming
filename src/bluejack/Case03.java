/**
 * @author github.com/mrasyidismail
 */
package bluejack;

import java.util.Scanner;

public class Case03 {

	public Case03() {
		Scanner scan = new Scanner(System.in);

		String itemName;
		double price, totalPrice, change;
		int quantity, discount, money;

		System.out.println("ES Companies Portal - Cashier App");
		System.out.println("=================================");
		System.out.print("Input item's Name                         : ");
		itemName = scan.nextLine();
		System.out.print("Input item's price  [use decimal numbers] : $ ");
		price = scan.nextDouble();
		scan.nextLine();
		System.out.print("Input item's quantity [1..20]             : ");
		quantity = scan.nextInt();
		scan.nextLine();
		System.out.print("Input item's discount [1..50]             : ");
		discount = scan.nextInt();
		scan.nextLine();

		totalPrice = price * quantity * (100 - discount) / 100;

		System.out.println("ES Companies Portal - Invoices");
		System.out.println("==============================");
		System.out.println("Item's Name     : " + itemName);
		System.out.println("Item's Price    : $ " + price);
		System.out.println("Item's Quantity : " + quantity);
		System.out.println("Item's Discount : " + discount + "%");
		System.out.println("\nYou have to pay $" + totalPrice);

		System.out.print("\nInput your money : ");
		money = scan.nextInt();
		scan.nextLine();
		change = money - totalPrice;

		if (money < totalPrice) {
			System.out.println("You don't have enough money !");
		} else {
			System.out.println("Thank you for purchasing!\nYour Change: $" + change);
		}
		scan.close();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Case03();
	}

}
