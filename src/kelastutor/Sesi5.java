/**
 * @author github.com/mrasyidismail
 */
package kelastutor;

import java.util.Scanner;

public class Sesi5 {
	Scanner sc = new Scanner(System.in);
	String name, soupFlavour, noodleType, meatballType, meatType, vegetableType;
	int menu, meatballAmount, meatGram, noodleWeight, meatballWeight, totalWeight, totalPrice, vegetableWeight;

	public Sesi5() {
		do {
			System.out.println("Welcome to LAburi Hotpot");
			System.out.println("========================");
			System.out.print("1. Order Hotpot\n2. Exit\nChoose Menu : ");
			menu = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (menu) {
			case 1: {
				do {
					System.out.print("Enter your Name [ More than 4 character ] : ");
					name = sc.nextLine();
				} while (!(name.length() > 4));

				while (true) {
					System.out.print(
							"Choose Soup Flavour [ Tom Yum Base | Mushroom Base | Beef Collagen Base ] ( Case Sensitive ) : ");
					soupFlavour = sc.nextLine();
					if (soupFlavour.equals("Tom Yum Base") || soupFlavour.equals("Mushroom Base")
							|| soupFlavour.equals("Beef Collagen Base")) {
						break;
					}

				}
//					do {
//						System.out.print("Choose Soup Flavour [ Tom Yum Base | Mushroom Base | Beef Collagen Base ] ( Case Sensitive ) : ");
//						soupFlavour = sc.nextLine();
//					} while(!(soupFlavour.equals("Tom Yum Base") || soupFlavour.equals("Mushroom Base") || soupFlavour.equals("Beef Collagen Base")));

				do {
					System.out.print(
							"Choose Noodle Type [ Egg Noodles | Udon Noodles | Shirataki Noodles ] ( Case Sensitive ) : ");
					noodleType = sc.nextLine();
				} while (!(noodleType.equals("Egg Noodles") || noodleType.equals("Udon Noodles")
						|| noodleType.equals("Shiratala Noodles")));

				do {
					System.out.print(
							"Choose Meatball [ Beef Meatball | Fish Meatball | Fried Meatball ] ( Case Sensitive ) : ");
					meatballType = sc.nextLine();
				} while (!(meatballType.equals("Beef Meatball") || meatballType.equals("Fish Meatball")
						|| meatballType.equals("Fried Meatball")));

				do {
					System.out.print("Amount of Meatball [ 1 - 10 ] : ");
					meatballAmount = sc.nextInt();
					sc.nextLine();
				} while ((meatballAmount < 1 || meatballAmount > 10));

				do {
					System.out.print("Choose Meat [ Beef | Shrimp | Fish ] ( Case Sensitive ) : ");
					meatType = sc.nextLine();
				} while (!(meatType.equals("Beef") || meatType.equals("Shrimp") || meatType.equals("Fish")));

				do {
					System.out.print("Meat Grams [ 10 - 100 ] : ");
					meatGram = sc.nextInt();
					sc.nextLine();
				} while ((meatGram < 10 || meatGram > 100));

				do {
					System.out.print("Choose Vegetables [ Cabbage | Mushroom | Brocolli ] ( Case Sensitive ) : ");
					vegetableType = sc.nextLine();
				} while (!(vegetableType.equals("Cabbage") || vegetableType.equals("Mushroom")
						|| vegetableType.equals("Brocolli")));

				if (noodleType.equals("Shirataki Noodles")) {
					noodleWeight = 60;
				} else if (noodleType.equals("Egg Noodles")) {
					noodleWeight = 70;
				} else {
					noodleWeight = 90;
				}

				if (meatballType.equals("Fish Meatball")) {
					meatballWeight = 4;
				} else if (meatballType.equals("Beef Meatball")) {
					meatballWeight = 5;
				} else {
					meatballWeight = 7;
				}

				vegetableWeight = 20;
				totalWeight = noodleWeight + (meatballWeight * meatballAmount) + meatGram + vegetableWeight;
				totalPrice = 50000 + ((totalWeight - 90) * 2000);

				System.out.println();
				System.out.println("Name          : " + name);
				System.out.println("Soup Base     : " + soupFlavour);
				System.out.println("Meatball      : " + meatballAmount + " pc(s) " + meatballType);
				System.out.println("Meat          : " + meatGram + " gr " + meatType);
				System.out.println("Vegetable     : " + vegetableType);
				System.out.println("Total Weight  : " + totalWeight + " gr");
				System.out.println("Total Price   : Rp " + totalPrice);
				System.out.println("\nPress Enter to Continue...");
				sc.nextLine();
				break;
			}
			case 2: {
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
		new Sesi5();
	}
}
