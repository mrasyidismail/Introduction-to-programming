package bluejack;

import java.util.Scanner;

public class Case05 {
	Scanner sc = new Scanner(System.in);
	String itemName;
	int menu, itemStock, quantity, discount, newStock;
	double itemPrice, totalPrice, money, change;

	public Case05() {

		System.out.println("ES Companies Portal - Cashier App 3");
		System.out.println("===================================");

		do {
			System.out.print("Input item's name [5..30 characters] : ");
			itemName = sc.nextLine();
		} while (itemName.length() < 5 || itemName.length() > 30);

		do {
			System.out.print("Input item's price [use decimal numbers | 10.0 - 2000.0] : $ ");
			try {
				itemPrice = sc.nextDouble();
				sc.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input must be a number !");
				sc.nextLine();
			}
		} while (itemPrice < 10.0 || itemPrice > 2000.0);

		itemStock = 50;

		do {
			System.out.println();
			System.out.println("What will you do ?");
			System.out.println("==================");
			System.out.print("1. Sell Item\n2. Restock Item\n3. Exit\nChoose : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch (menu) {
			case 1: {
				if (itemStock == 0) {
					System.out.println("The item is out of stock, please restock !");
					break;
				}
				
				do {
					try {
						System.out.print("Input Item's quantity [1..50] : ");
						quantity = sc.nextInt();
						sc.nextLine();
						if (quantity >= 100) {
							System.out.println("Out of stock !");
						}
					} catch (Exception IOError) {
						System.out.println("Input must be a number !");
						sc.nextLine();
					}
				} while (quantity < 1 || quantity > 50);
				
				do {
					try {
						System.out.print("Input item's discount [0..50] : ");
						discount = sc.nextInt();
						sc.nextLine();
					} catch (Exception IOError) {
						// TODO: handle exception
						System.out.println("Input must be a number !");
						sc.nextLine();
					}
				} while(discount < 0 || discount > 50);
				
				totalPrice = itemPrice - quantity * (100 - discount) / 100;
				System.out.println("\nES Companies Portal - Invoice");
				System.out.println("=================================");
				System.out.println("Item's Name      : " + itemName);
				System.out.println("Item's Price     : " + itemPrice);
				System.out.println("Item's Quantity  : " + quantity);
				System.out.println("Item's Discount  : " + discount + "%");
				System.out.println("\nYou have to pay : $ " + totalPrice);
				
				do {
					try {
						System.out.print("\nInput your money [use decimal numbers | min 2259.0] : ");
						money = sc.nextDouble();
					} catch (Exception IOError) {
						// TODO: handle exception
						System.out.println("Input must be a number !");
					} finally {
						sc.nextLine();
					}
				} while (money <= 2559.0 && money <= totalPrice);
				
				change = money - totalPrice;

				System.out.println("Thank you for purchasing!");
				System.out.println("Your change : $ " + change);
				itemStock = itemStock - quantity;
				break;
			}
			case 2: {
				if (itemStock >= 100) {
					System.out.println("The item's stock is full, please sell it !");
					break;
				}
				int checkStock = 100 - itemStock;

				do {
					try {
						System.out.print("Input stock to add [1.." + checkStock + "] : ");
						newStock = sc.nextInt();
					} catch (Exception IOError) {
						// TODO: handle exception
						System.out.println("Input must be a number !");
					} finally {
						sc.nextLine();
					}
				} while (newStock < 1 || newStock > checkStock);
				
				System.out.println("Success add stock !");
				itemStock = itemStock + newStock;
				
				break;
			}
			case 3: {
				System.out.println("Thanks for using this application !");
				break;
			}
			default:
				break;
			}
		} while (menu != 3);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Case05();
	}

}
