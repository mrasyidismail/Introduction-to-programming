package quiz;

import java.util.Random;
import java.util.Scanner;

public class Latihan1 {

	public Latihan1() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		String customerName, drinkName, cupType, sugarType, paymentMethod;
		int menu, price, quantity, cupPrice, paymentPoint, money;
		double totalDiscount = 0, totalPrice, change;

		do {
			System.out.println("\nFixTue v2");
			System.out.println("=========");
			System.out.print("1. Order FixTue\n2. Exit\n>> ");
			menu = sc.nextInt();
			sc.nextLine();
			System.out.println();
			switch (menu) {
			case 1: {
				do {
					System.out.print("Input Customer Name [ Must be between 5 - 15 characters ] : ");
					customerName = sc.nextLine();
				} while (customerName.length() < 5 || customerName.length() > 15);

				do {
					System.out.print("Input Drink Name [ Brown Sugar | Red Bean | Oats ] ( Case Sensitive ) : ");
					drinkName = sc.nextLine();
				} while (!(drinkName.equals("Brown Sugar") || drinkName.equals("Red Bean")
						|| drinkName.equals("Oats")));

				do {
					System.out.print("Enter Cup Type [ Large | Medium | Small ] ( Case Sensitive ) : ");
					cupType = sc.nextLine();
				} while (!(cupType.equals("Large") || cupType.equals("Medium") || cupType.equals("Small")));

				do {
					System.out.print("Enter Sugar Type [ Less | Normal ] ( Case Sensitive ) : ");
					sugarType = sc.nextLine();
				} while (!(sugarType.equals("Less") || sugarType.equals("Normal")));

				do {
					System.out.print("Input Quantity [ Must be more than 0 ] : ");
					quantity = sc.nextInt();
					sc.nextLine();
				} while (!(quantity > 0));

				do {
					System.out.print("Input Payment Method [ Transfer | QRIS ] ( Case Sensitive ) : ");
					paymentMethod = sc.nextLine();
				} while (!(paymentMethod.equals("Transfer") || paymentMethod.equals("QRIS")));

				if (drinkName.equals("Brown Sugar")) {
					price = 20000;
				} else if (drinkName.equals("Red Bean")) {
					price = 17000;
				} else {
					price = 15000;
				}

				if (cupType.equals("Small")) {
					cupPrice = 0;
				} else if (cupType.equals("Medium")) {
					cupPrice = 2000;
				} else {
					cupPrice = 5000;
				}

				if (paymentMethod.equals("Transfer")) {
					paymentPoint = 5;
				} else {
					paymentPoint = 10;
				}

				totalPrice = (price + cupPrice) * quantity;

				if (totalPrice > 100000) {
					totalDiscount = customerName.length() + paymentPoint;
					totalPrice = (int) (totalPrice - (totalPrice * ((double) totalDiscount / 100)));
				}

				System.out.println("\n==========================================");
				System.out.println("|            Bill Information            |");
				System.out.println("==========================================");
				System.out.println("| Bill ID            : " + String.format("BL%03d", (rand.nextInt(999) + 1)));
				System.out.println("| Customer Name      : " + customerName);
				System.out.println("| Drink Name         : " + drinkName);
				System.out.println("| Drink Price        : " + price);
				System.out.println("| Cup Type           : " + cupType);
				System.out.println("| Cup Price          : " + cupPrice);
				System.out.println("| Quantity           : " + quantity);
				System.out.println("| Total Discount     : " + totalDiscount + "%");
				System.out.println("| Total Price        : " + totalPrice);
				System.out.println("==========================================");

				do {
					System.out.print("Input Money [ >= Total Price ] : ");
					money = sc.nextInt();
					sc.nextLine();
				} while (!(money >= totalPrice));

				change = money - totalPrice;
				System.out.println("Change : " + change + "\n\nThank you :)");
				break;
			}
			case 2: {
				System.out.println("\nNever Give up :)");
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
		new Latihan1();
	}

}
