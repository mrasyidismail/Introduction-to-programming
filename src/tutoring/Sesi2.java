package tutoring;

import java.util.Random;
import java.util.Scanner;

public class Sesi2 {

	public Sesi2() {
		Scanner sc = new Scanner(System.in);

		Random rand = new Random();

		String cname, fname, foodName, drinkName, note, payMethod, confirm = null;
		int foodPrice, drinkPrice, menu, qty, tax, totalPrice;
		double payPoint;
		String[] notes;

		do {
			System.out.println("goFoT");
			System.out.println("=====");
			System.out.println("1. Order goFoT");
			System.out.println("2. Exit");
			System.out.print(">>");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				do {
					System.out.println("Input Customer Name: ");
					cname = sc.nextLine();
				} while (!(cname.length() >= 7 || cname.length() <= 15 && cname.startsWith("Mr.")
						|| cname.startsWith("Mrs.")));

				do {
					System.out.println("Input Franchise Name: ");
					fname = sc.nextLine();
				} while (!(fname.equals("Fkc") || (fname.equals("Cmd"))));

				do {
					System.out.println("Input Food Name:");
					foodName = sc.nextLine();
				} while (!(foodName.equals("Burger") || foodName.equals("Fried Chicken")
						|| foodName.equals("French Fries")));
				if (foodName.equals("Burger")) {
					foodPrice = 17000;
				} else if (foodName.equals("Fried Chicken")) {
					foodPrice = 22000;
				} else {
					foodPrice = 12000;

				}

				do {
					System.out.println("Input Drink Name: ");
					drinkName = sc.nextLine();
				} while (!(drinkName.equalsIgnoreCase("Mineral Water") || drinkName.equalsIgnoreCase("Ice Tea")
						|| drinkName.equalsIgnoreCase("Milkshake")));
				if (drinkName.equalsIgnoreCase("Mineral Water")) {
					drinkPrice = 3000;
				} else if (drinkName.equalsIgnoreCase("Ice Tea")) {
					drinkPrice = 5000;
				} else {
					drinkPrice = 10000;
				}

				do {
					System.out.println("Input Quantity: ");
					qty = sc.nextInt();
					sc.nextLine();
				} while (qty <= 0);

				do {
					System.out.println("Input Order Note: ");
					note = sc.nextLine();
					notes = note.split(" ");
				} while (!(note.contains("Thank You") && notes.length >= 2));

				do {
					System.out.println("Input Payment Method: ");
					payMethod = sc.nextLine();
				} while (!(payMethod.equals("Fana") || payMethod.equals("Fopay")));
				if (payMethod.equals("Fana")) {
					payPoint = (double) 10 / 100;

				} else {
					payPoint = (double) 20 / 100;
				}

				tax = (int) (((foodPrice + drinkPrice) * qty) * (payPoint));
				totalPrice = ((foodPrice + drinkPrice) * qty) + tax;

				System.out.println("========================");
				System.out.println("Customer Name :" + cname);
				System.out.println("Food Name :" + foodName);
				System.out.println("Food Price :" + foodPrice);
				System.out.println("Drink Name :" + drinkName);
				System.out.println("Drink Price :" + drinkPrice);
				System.out.println("Quantity :" + qty);
				System.out.println("Order Notes :" + note);
				System.out.println("Franchise name :" + fname.toUpperCase());
				System.out.println("Payment method :" + payMethod);
				System.out.println("Tax :" + tax);
				System.out.println("Total Price :" + totalPrice);

				do {
					System.out.println("confirm order");
					confirm = sc.nextLine();
				} while (!(confirm.equals("y") || confirm.equals("n")));
				if (confirm.equals("y")) {
					System.out.println("Succes Order!");

				} else {
					break;
				}
				break;

			}
			case 2:
				System.out.println("Good Luck Have Fun :)");
				break;
			}
		} while (menu != 2);

	}

	public static void main(String[] args) {
		new Sesi2();
	}

}
