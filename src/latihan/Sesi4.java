/**
 * @author github.com/mrasyidismail
 */
package latihan;

import java.util.Random;
import java.util.Scanner;

public class Sesi4 {

	public Sesi4() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		String customerName, product, paymentMethod, iceCream = null, topping = null, isTopping = null, cupType = null,
				milkName = null;
		int billID = rand.nextInt(999) + 1, menu, price, quantity, totalPrice = 0, paymentPoint, toppingPrice = 0,
				cupPrice = 0, discount = 0, money, change;

		System.out.println("Welcome to FixTue");
		System.out.println("=================");
		System.out.print("1. Order FixTue\n2. Exit\n>> ");
		menu = scan.nextInt();
		scan.nextLine();

		switch (menu) {
		case 1:
			System.out.print("\nEnter Customer Name [ e.g. Fred ]             : ");
			customerName = scan.nextLine();
			System.out.print("Choose Product [ Fresh Ice Cream | Milk Tea ] : ");
			product = scan.nextLine();

			switch (product) {
			case "Fresh Ice Cream":

				System.out.print("Input Ice Cream Name [ Vanilla Ice Cream | Boba Sundae | Oreo Sundae ] : ");
				iceCream = scan.nextLine();

				switch (iceCream) {
				case "Vanilla Ice Cream":
					price = 12000;
					break;
				case "Boba Sundae":
					price = 16000;
					break;
				case "Oreo Sundae":
					price = 14000;
					break;
				default:
					System.out.println("Please enter a valid Ice Cream !");
					scan.close();
					return;
				}
				System.out.print("Additional Topping [ YES | NO ] : ");
				isTopping = scan.nextLine();

				switch (isTopping) {
				case "YES":
					System.out.print("Input Additional Topping [ Jelly | Cookies ] : ");
					topping = scan.nextLine();
					switch (topping) {
					case "Jelly":
						toppingPrice = 2000;
						break;
					case "Cookies":
						toppingPrice = 5000;
						break;
					default:
						System.out.println("Please enter a valid topping !");
						scan.close();
						return;
					}
					break;
				case "NO":
					toppingPrice = 0;
					break;
				default:
					System.out.println("Please enter a valid answer !");
					scan.close();
					return;
				}
				break;
			case "Milk Tea":
				System.out.print("Input Drink Name [ Brown Sugar | Red Bean | Oats ] : ");
				milkName = scan.nextLine();

				switch (milkName) {
				case "Brown Sugar":
					price = 20000;
					break;
				case "Red Bean":
					price = 17000;
					break;
				case "Oats":
					price = 15000;
					break;
				default:
					System.out.println("Please enter a valid drink !");
					scan.close();
					return;
				}
				System.out.print("Input Cup Type [ Small | Medium | Large ] : ");
				cupType = scan.nextLine();

				switch (cupType) {
				case "Small":
					cupPrice = 0;
					break;
				case "Medium":
					cupPrice = 2000;
					break;
				case "Large":
					cupPrice = 5000;
					break;
				default:
					System.out.println("Please enter a valid cup type !");
					scan.close();
					return;
				}
				break;
			default:
				System.out.println("Please enter a valid Product !");
				scan.close();
				return;
			}
			System.out.print("Input Quantity [ e.g. 10 ] : ");
			quantity = scan.nextInt();
			scan.nextLine();
			System.out.print("Input Payment Method [ e.g. QRIS | Transfer ] : ");
			paymentMethod = scan.nextLine();

			switch (paymentMethod) {
			case "QRIS":
				paymentPoint = 10;
				break;
			case "Transfer":
				paymentPoint = 5;
				break;
			default:
				System.out.println("Please enter a valid payment method !");
				scan.close();
				return;
			}

			switch (product) {
			case "Fresh Ice Cream":
				totalPrice = (price + toppingPrice) * quantity;
				break;
			case "Milk Tea":
				totalPrice = (price + cupPrice) * quantity;
				break;
			default:
				break;
			}
			if (totalPrice > 100000) {
				discount = customerName.length() + paymentPoint;
				totalPrice = (int) (totalPrice - (totalPrice * ((double) discount / 100)));
			}
			System.out.println("\n====================================");
			System.out.println("|                Bill              |");
			System.out.println("====================================");
			System.out.println("| Bill ID                    : BL" + billID);
			System.out.println("| Customer Name              : " + customerName);
			System.out.println("| Product Name               : " + product);
			switch (product) {
			case "Fresh Ice Cream":
				System.out.println("| Ice Cream Name             : " + iceCream);
				System.out.println("| Ice Cream Price            : " + price);
				switch (isTopping) {
				case "YES":
					System.out.println("| Additional Topping         : " + topping);
					System.out.println("| Additional Topping Price   : " + toppingPrice);
					break;
				case "NO":
					System.out.println("| Additional Topping         : -");
					System.out.println("| Additional Topping Price   : " + toppingPrice);
					break;
				}
				break;
			case "Milk Tea":
				System.out.println("| Drink Name                 : " + milkName);
				System.out.println("| Drink Price                : " + price);
				System.out.println("| Cup Type                   : " + cupType);
				System.out.println("| Cup Type Price             : " + cupPrice);
				break;
			}
			System.out.println("| Quantity                   : " + quantity);
			System.out.println("| Payment Method             : " + paymentMethod);
			System.out.println("| Total Discount             : " + discount + "%");
			System.out.println("| Total Price                : " + totalPrice);
			System.out.println("====================================");

			System.out.print("Input Money [ >= Total Price ] : ");
			money = scan.nextInt();
			change = money - totalPrice;
			System.out.println("Change : " + change);
			System.out.println("\nThank you for you purchase :)");
			break;
		case 2:
			System.out.println("Never Give Up :)");
			break;
		default:
			System.out.println("Please enter a valid menu !");
			scan.close();
			return;
		}
		scan.close();
	}

	public static void main(String[] args) {
		new Sesi4();
	}

}
