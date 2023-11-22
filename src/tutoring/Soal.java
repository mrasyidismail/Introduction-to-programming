package tutoring;

import java.util.Scanner;

public class Soal {
	Scanner sc = new Scanner(System.in);
	String customerName, registeredName, confirmation;
	String[] splitName;
	int menu;

	public Soal() {
		do {
			System.out.print("Select a menu\n1. Register\n2. Unregister\n3. Exit\nChoose: ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1: {
				do {
					System.out.print(
							"Enter your name [ Must start with Mr. or Mrs. and minimum length is 5 (after Mr.|Mrs.) with capital at first letter ] : ");
					customerName = sc.nextLine();
					splitName = customerName.split(" ");
				} while (!(customerName.startsWith("Mr.") || customerName.startsWith("Mrs.")) || (splitName.length < 2
						|| splitName[1].length() < 5 || !Character.isUpperCase(splitName[1].charAt(0))));
				registeredName = customerName;
				break;
			}
			case 2: {
				if (registeredName == null) {
					System.out.println("You have not yet registered ! Please register first !");
					break;
				}
				System.out.println("Registered Name : " + registeredName);
				do {
					System.out.print("Are you sure you want to unregister ? (Case Sensitive) [ Y | N ] : ");
					confirmation = sc.nextLine();
				} while (!(confirmation.equals("Y") || confirmation.equals("N")));
				
				if (confirmation.equals("Y")) {
					System.out.println("Successfully unregistered !");
					registeredName = null;
				} else {
					System.out.println("Canceled");
				}
				break;
			}
			case 3: {
				System.out.println("See you next time :)");
				break;
			}
			default:
				break;
			}
		} while (menu != 3);
	}

	public static void main(String[] args) {
		new Soal();
	}

}
