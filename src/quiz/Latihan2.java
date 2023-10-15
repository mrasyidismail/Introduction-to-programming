/**
 * @author github.com/mrasyidismail
 */
package quiz;

import java.util.Scanner;

public class Latihan2 {

	public Latihan2() {
		Scanner sc = new Scanner(System.in);
		String[] notes;
		String customerName, franchiseName, foodName, drinkName, orderNote, paymentMethod, confirmation;
		int menu, quantity, foodPrice, drinkPrice;
		double tax, paymentPoint, totalPrice;

		do {
			System.out.println("goFoT v2");
			System.out.println("=========");
			System.out.print("1. Order goFoT\n2. Exit\n>> ");
			menu = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (menu) {
			case 1: {
				do {
					System.out.print(
							"Input Customer Name [ Must be between 7 - 15 characters and Starts with Mr. or Mrs. ] : ");
					customerName = sc.nextLine();
				} while ((customerName.length() < 7 || customerName.length() > 15)
						|| (!(customerName.startsWith("Mr.") || customerName.startsWith("Mrs."))));

				do {
					System.out.print("Input Franchise Name [ Fkc | Cmd ] ( Case Sensitive ) : ");
					franchiseName = sc.nextLine();
				} while (!(franchiseName.equals("Fkc") || franchiseName.equals("Cmd")));

				do {
					System.out.print("Input Food Name [ Burger | Fried Chicken | French Fries ] ( Case Sensitive ) : ");
					foodName = sc.nextLine();
				} while (!(foodName.equals("Burger") || foodName.equals("Fried Chicken")));

				do {
					System.out
							.print("Input Drink Name [ Mineral Water | Ice Tea | Milkshake ] ( Case Insensitive ) : ");
					drinkName = sc.nextLine();
				} while (!(drinkName.equalsIgnoreCase("Mineral Water") || drinkName.equalsIgnoreCase("Ice Tea")
						|| drinkName.equalsIgnoreCase("Milkshake")));

				do {
					System.out.print("Input Order Note [ Must contain atleast 2 words and contain Thank You ] : ");
					orderNote = sc.nextLine();
					notes = orderNote.split(" ");

				} while (!(notes.length >= 2 && orderNote.contains("Thank You")));

				do {
					System.out.print("Input Quantity [ Must be more than 0 ] : ");
					quantity = sc.nextInt();
					sc.nextLine();
				} while (!(quantity > 0));

				do {
					System.out.print("Input Payment Method [ Fana | Fopay ] ( Case Sensitive ) : ");
					paymentMethod = sc.nextLine();
				} while (!(paymentMethod.equals("Fana") || paymentMethod.equals("Fopay")));

				if (foodName.equals("Burger")) {
					foodPrice = 17000;
				} else if (foodName.equalsIgnoreCase("Fried Chicken")) {
					foodPrice = 22000;
				} else {
					foodPrice = 12000;
				}

				if (drinkName.equalsIgnoreCase("Mineral Water")) {
					drinkPrice = 3000;
				} else if (drinkName.equalsIgnoreCase("Ice Tea")) {
					drinkPrice = 5000;
				} else {
					drinkPrice = 10000;
				}

				if (paymentMethod.equals("Fana")) {
					paymentPoint = (double) 10 / 100;
				} else {
					paymentPoint = (double) 20 / 100;
				}

				tax = ((foodPrice + drinkPrice) * quantity) * (paymentPoint);
				totalPrice = ((foodPrice + drinkPrice) * quantity) + tax;

				System.out.println("\n====================================");
				System.out.println("|          Order Information       |");
				System.out.println("====================================");
				System.out.println("| Customer Name        : " + customerName);
				System.out.println("| Food Name            : " + foodName);
				System.out.println("| Food Price           : " + foodPrice);
				System.out.println("| Drink Name           : " + drinkName);
				System.out.println("| Drink Price          : " + drinkPrice);
				System.out.println("| Quantity             : " + quantity);
				System.out.println("| Order Note           : " + orderNote);
				System.out.println("| Franchise Name       : " + franchiseName.toUpperCase());
				System.out.println("| Payment Method       : " + paymentMethod);
				System.out.println("| Tax                  : " + tax);
				System.out.println("| Total Price          : " + totalPrice);
				System.out.println("====================================");

				do {
					System.out.print("Confirm Order [ y | n ] ( Case Sensitive ) : ");
					confirmation = sc.nextLine();
				} while (!(confirmation.equals("y") || confirmation.equals("n")));

				if (confirmation.equals("y")) {
					System.out.println("Success Order !\n");
					break;
				} else {
					System.out.println();
					break;
				}
			}
			case 2: {
				System.out.println("Good Luck Have Fun :)");
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
		new Latihan2();
	}

}
