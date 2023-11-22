package quiz;

import java.util.Scanner;

public class Latihan6 {
	Scanner sc = new Scanner(System.in);
	final int MAX_DATA = 100;
	String[] staffName = new String[MAX_DATA];
	String[] staffPosition = new String[MAX_DATA];
	int[] staffAge = new int[MAX_DATA];
	int count = 0, menu;

	public Latihan6() {
		do {
			System.out
					.print("Job Vacancy\n1. Insert a new staff\n2. List of staff\n3. Search staff\n4. Exit\nChoose: ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1: {
				String name, position;
				int age;

				do {
					System.out.print("Input staff name [3..20]: ");
					name = sc.nextLine();
				} while (name.length() < 3 || name.length() > 20);

				staffName[count] = name;

				do {
					System.out.print("Enter staff's position [Manager|Analyst|Programmer]: ");
					position = sc.nextLine();
				} while (!(position.equalsIgnoreCase("manager") || position.equalsIgnoreCase("analyst")
						|| position.equalsIgnoreCase("programmer")));

				staffPosition[count] = position;

				do {
					System.out.print("Enter staff's age [must be more than 17 years old]: ");
					age = sc.nextInt();
					sc.nextLine();
				} while (age < 17);

				staffAge[count] = age;
				System.out.println("");
				count++;
				break;
			}
			case 2: {
				if (count == 0) {
					System.out.println("No data !\n");
				} else {
					for (int i = 0; i < count; i++) {
						System.out.println("Staff ID       : " + (i + 1));
						System.out.println("=========================");
						System.out.println("Staff Name     : " + staffName[i]);
						System.out.println("Staff Position : " + staffPosition[i]);
						System.out.println("Staff Age      : " + staffAge[i]);
					}
				}
				break;
			}
			case 3: {
				String name;
				if (count == 0) {
					System.out.println("No data !\n");
				} else {
					do {
						System.out.print("Input staff's name [3..20] : ");
						name = sc.nextLine();
					} while (name.length() < 3 || name.length() > 20);
					System.out.println();
					boolean found = false; // Variable to track whether the data is found

					for (int i = 0; i < count; i++) {
						if (staffName[i].equalsIgnoreCase(name)) {
							System.out.println("Staff ID       : " + (i + 1));
							System.out.println("=========================");
							System.out.println("Staff Name     : " + staffName[i]);
							System.out.println("Staff Position : " + staffPosition[i]);
							System.out.println("Staff Age      : " + staffAge[i]);
							found = true;
							break;
						}
					}
					System.out.println();

					if (!found) {
						System.out.println("Data not found!");
					}

				}
				break;
			}
			case 4: {
				System.out.println("Program has been closed !");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 4);
	}

	public static void main(String[] args) {
		new Latihan6();
	}

}
