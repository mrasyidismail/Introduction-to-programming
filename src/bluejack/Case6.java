package bluejack;

import java.util.Scanner;

public class Case6 {
	Scanner sc = new Scanner(System.in);
	double currentMoney, investedMoney;
	String validate;
	int multiplier, month, menu;

	public Case6() {
		// TODO Auto-generated constructor stub
		while (true) {
			month = 0;
			System.out.println("ES Companies Portal - Investment Calculator");
			System.out.println("===========================================");
			System.out.println("Beginning");
			do {
				try {
					System.out.print("Input your money to be invested [1...5000 | can use decimal ] : $ ");
					currentMoney = sc.nextDouble();
					sc.nextLine();
				} catch (Exception IOException) {
					// TODO: handle exception
					System.out.println("The input must be a number !");
				}
			} while (currentMoney < 1 || currentMoney > 5000);

			do {
				try {
					System.out.print("Input the investment multiplier [1..99] : ");
					multiplier = sc.nextInt();
					sc.nextLine();
				} catch (Exception IOException) {
					// TODO: handle exception
					System.out.println("The input must be a number !");
				}
			} while (multiplier < 1 || multiplier > 99);

			do {
				month++;
				System.out.println("Month " + month);
				System.out.println("Current Money : $ " + currentMoney);
				System.out.println("\nWhat happened ?");
				System.out.println("===================");
				System.out.print(
						"1. Nothing\n2. Take all the money invested\n3. Drop the investment\n4. No additional to investment\nChoose : ");
				menu = sc.nextInt();
				sc.nextLine();
				switch (menu) {
					case 1: {
						System.out.println("Nothing bad happened... Everything is normal");
						currentMoney = currentMoney + ( currentMoney * ((double) multiplier / 100));
						break;
					}
					case 2: {
						System.out.println("You have taken all of your money...");
						continue;
					}
					case 3: {
					    System.out.println("Oh no! The drop in investment causes your money to decrease...");
					    currentMoney = currentMoney + ((double) currentMoney * multiplier * ((double)-1/100));
					    break;
					}
					case 4: {
						System.out.println("There's no change in the investment money...");
						break;
					}
				}

				System.out.println();
			} while (menu != 2 && month != 12);

			System.out.println("\nYour money after investing : $ " + currentMoney);
			System.out.println();

			do {
				System.out.print("Do you want to try again [y|n] : ");
				validate = sc.nextLine();
			} while (!(validate.equals("y") || validate.equals("n")));

			if (validate.equals("n")) {
				System.out.println("\nThanks for using this application !");
				break;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Case6();
	}

}
