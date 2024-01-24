package tutoring;

import java.util.Scanner;

public class Sesi11 {
	Scanner sc = new Scanner(System.in);

	int menu;

	public Sesi11() {
		do {
			System.out.println("1. Menu 1");
			System.out.println("2. Menu 2");
			System.out.println("3. Exit");

			try {
				System.out.print("Enter menu : ");
				menu = sc.nextInt();
				
				switch (menu) {
				case 1: {
					System.out.println("Ini adalah menu 1");
					break;
				}
				case 2: {
					System.out.println("Ini adalah menu 2");
					break;
				}
				case 3: {
					System.out.println("Exit");
					break;
				}
				default:
					System.out.println("Angka ini tidak ada menunya");
					break;
				}
			} catch (Exception e) {
				System.out.println("Tolong masukin angka yang bener");
			} finally {
				sc.nextLine();
			}
		} while (menu != 3);
	}

	public static void main(String[] args) {
		new Sesi11();
	}

}
