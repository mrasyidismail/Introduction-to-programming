package bluejack;

import java.util.Scanner;

public class Case09 {
	Scanner sc = new Scanner(System.in);

	String username, password;
	int menu, age;
	double idealweight, height;

	public Case09() {
		do {
			System.out.println("Ideal Body Weight Calculation");
			System.out.println("=============================");
			System.out.println("1. Login");
			System.out.println("2. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				login();
				break;
			}
			case 2: {
				System.out.println("Program has been closed !");
				break;
			}

			default:
				break;
			}
		} while (menu != 2);
	}

	private void login() {
		while (true) {
			do {
				System.out.print("Input Username [5..20] : ");
				username = sc.nextLine();
			} while (username.length() < 5 || username.length() > 20);

			System.out.print("Input Password [\"cancel\" for cancel] : ");
			password = sc.nextLine();

			if (password.equals("cancel"))
				break;
			if (!(password.equals(username) && username.equals(password)))
				System.out.println("Invalid username and password!\n");
			else
				break;
		}
		if (password.equals("cancel")) {
			System.out.println("Login canceled !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
			return;
		} else {
			System.out.println("\nWelcome, " + username);
			do {
				System.out.print("Input your Age [1..60] : ");
				age = sc.nextInt();
				sc.nextLine();
			} while (age < 1 || age > 60);

			if (age <= 10 && age >= 1)
				idealweight = (age * 2) + 8;
			else {
				do {
					System.out.print("Input your Height [150..300] : ");
					height = sc.nextDouble();
					sc.nextLine();
				} while (height < 150 || height > 300);

				idealweight = (height - 100) * 0.9;
			}
			String output = "Your ideal weight is : " + idealweight + " kg";
			System.out.println(output);
			System.out.println("=".repeat(output.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	public static void main(String[] args) {
		new Case09();
	}

}
