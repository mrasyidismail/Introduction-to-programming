/**
 * @author github.com/mrasyidismail
 */
package quiz;

import java.util.Random;
import java.util.Scanner;

public class Latihan5 {

	public Latihan5() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		String customerName, foodName, paymentMethod;
		int menu, foodPrice, quantity, totalPrice, paymentPoint, totalDiscount, change, money;

		do {
			System.out.println("Bakmi eFeTe v2");
			System.out.println("=============");
			System.out.print("1. Order Menu\n2. Exit\n>> ");
			menu = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (menu) {
			case 1: {
				do {
					System.out.print("Input Customer Name [ Must be more than 5 characters ] : ");
					customerName = sc.nextLine();
				} while (!(customerName.length() > 5));

				do {
					System.out.print("Input Food Name [ Bakmi Keriting | Bakmi Lebar ] ( Case Insensitive ) : ");
					foodName = sc.nextLine();
				} while (!(foodName.equalsIgnoreCase("Bakmi Keriting") || foodName.equalsIgnoreCase("Bakmi Lebar")));

				do {
					System.out.print("Input Food Price [ Must be more than 10000 ] : ");
					foodPrice = sc.nextInt();
					sc.nextLine();
				} while (!(foodPrice > 10000));

				do {
					System.out.print("Input Quantity [ Must be more than 0 ] : ");
					quantity = sc.nextInt();
					sc.nextLine();
				} while (!(quantity > 0));

				do {
					System.out.print("Input Payment Method [ Cash | Transfer | QRIS ] ( Case Sensitive ) : ");
					paymentMethod = sc.nextLine();
				} while (!(paymentMethod.equals("Cash") || paymentMethod.equals("Transfer")
						|| paymentMethod.equals("QRIS")));

				if (paymentMethod.equals("Cash")) {
					paymentPoint = 0;
				} else if (paymentMethod.equals("Transfer")) {
					paymentPoint = 5;
				} else {
					paymentPoint = 10;
				}

				totalDiscount = customerName.length() + paymentPoint;
				totalPrice = (int) ((foodPrice * quantity) - ((foodPrice * quantity) * ((double) totalDiscount / 100)));

				System.out.println("========================================");
				System.out.println("|                 BIll                 |");
				System.out.println("========================================");
				System.out.println("| Bill ID            : " + String.format("BL%d", (rand.nextInt(999) + 1)));
				System.out.println("| Customer Name      : " + customerName);
				System.out.println("| Food Price         : " + foodPrice);
				System.out.println("| Quantity           : " + quantity);
				System.out.println("| Total Discount     : " + totalDiscount + "%");
				System.out.println("| Total Price        : " + totalPrice);
				System.out.println("| Payment Method     : " + paymentMethod);
				System.out.println("========================================");

				do {
					System.out.print("Enter Money [ >= Total Price ] : ");
					money = sc.nextInt();
					sc.nextLine();
				} while (!(money >= totalPrice));

				change = money - totalPrice;

				System.out.println("Change : " + change + "\n\nThank you for your purchase :)\n");
				break;
			}
			case 2: {
				System.out.println("Nyam nyam nyam :)\n");
				break;
			}
			default: {
				break;
			}
			}
		} while (menu != 2);
		sc.close();
	}

	public static void main(String[] args) {
		new Latihan5();
	}

}
