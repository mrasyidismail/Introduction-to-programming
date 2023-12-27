package bluejack;

import java.util.Scanner;
import java.util.Vector;

public class Case07 {
	Scanner sc = new Scanner(System.in);

	String staffName, staffPosition;
	int menu, age;

	Vector<String> staffNames = new Vector<String>();
	Vector<String> staffPositions = new Vector<String>();
	Vector<Integer> ages = new Vector<Integer>();
	Vector<Integer> staffIds = new Vector<Integer>();

	public Case07() {
		do {
			System.out.println("Job Vacancy");
			System.out.println("===========");
			System.out.println("1. Insert new staff");
			System.out.println("2. List of staff");
			System.out.println("3. Search staff");
			System.out.println("4. Exit");
			System.out.print("Choose : ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1: {
				inputStaff();
				break;
			}
			case 2: {
				viewStaff();
				break;
			}
			case 3: {
				searchStaff();
				break;
			}
			case 4: {
				System.out.println("Program has been closed!");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 4);
	}

	private void inputStaff() {
		do {
			System.out.print("Input staff's name [3-20] : ");
			staffName = sc.nextLine();
		} while (staffName.length() < 3 || staffName.length() > 20 || staffNames.contains(staffName));

		do {
			System.out.print("Input staff's position [ Manager | Analyst | Programmer ] : ");
			staffPosition = sc.nextLine();
		} while (!(staffPosition.equalsIgnoreCase("Manager") || staffPosition.equalsIgnoreCase("Analyst")
				|| staffPosition.equalsIgnoreCase("Programmer")));

		do {
			System.out.print("Input staff's age [ more than 17 years old ] : ");
			age = sc.nextInt();
			sc.nextLine();
		} while (age <= 17);
		System.out.println("Data has been successfully inserted!\n");

		staffNames.add(staffName);
		staffPositions.add(staffPosition);
		ages.add(age);
		staffIds.add(staffIds.size() + 1);
	}

	private void viewStaff() {
		if (staffIds.isEmpty()) {
			System.out.println("No Data!");
		} else {
			String createTable = String.format("| %-10s | %-20s | %-15s | %-7s |", "Staff ID", "Name", "Position",
					"Age");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < staffIds.size(); i++) {
				String createList = String.format("| %-10d | %-20s | %-15s | %-7d |", staffIds.get(i),
						staffNames.get(i), staffPositions.get(i), ages.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void searchStaff() {
		do {
			System.out.print("Input staff's name [3-20] : ");
			staffName = sc.nextLine();
		} while (staffName.length() < 3 || staffName.length() > 20);

		if (staffNames.contains(staffName)) {
			System.out.println();
			System.out.println("Staff ID : " + staffIds.get(staffNames.indexOf(staffName)));
			System.out.println("==================");
			System.out.println("Name     : " + staffNames.get(staffNames.indexOf(staffName)));
			System.out.println("Position : " + staffPositions.get(staffNames.indexOf(staffName)));
			System.out.println("Age      : " + ages.get(staffNames.indexOf(staffName)));
			System.out.println("==================\n");
		} else {
			System.out.println("No data found !\n");
		}
	}

	public static void main(String[] args) {
		new Case07();
	}

}
