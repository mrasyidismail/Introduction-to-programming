package bluejack;

import java.util.Scanner;
import java.util.Vector;

public class Case10 {
	Scanner sc = new Scanner(System.in);

	String name, address, age;
	int menu, sortmenu;

	Vector<String> names = new Vector<String>();
	Vector<String> addresses = new Vector<String>();
	Vector<String> ages = new Vector<String>();

	public Case10() {
		do {
			System.out.println("Patient's Data");
			System.out.println("==============");
			System.out.println("1. Input new Data");
			System.out.println("2. View Patient's Data");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				inputData();
				break;
			}
			case 2: {
				viewData();
				break;
			}
			case 3: {
				System.out.println("Program has been closed !");
				break;
			}

			default:
				break;
			}
		} while (menu != 3);
	}

	private void inputData() {
		do {
			System.out.print("Input name [3..20] : ");
			name = sc.nextLine();
		} while (name.length() < 3 || name.length() > 20);

		do {
			System.out.print("Input Age [10..100] : ");
			age = sc.nextLine();

			if (!isNumeric(age))
				System.out.println("Input must be numeric!\n");
		} while (!isNumeric(age));

		do {
			System.out.print("Input Address [5..30] : ");
			address = sc.nextLine();
		} while (address.length() < 5 || address.length() > 30);

		names.add(name);
		addresses.add(address);
		ages.add(age);
		System.out.println("Data has been successfully inserted !");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private void viewData() {
		if (names.isEmpty()) {
			System.out.println("There is no data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			do {
				displayTable();
				System.out.println("1. Sort data by Name Ascending");
				System.out.println("2. Sort data by Name Descending");
				System.out.println("3. Sort data by Age Ascending");
				System.out.println("4. Sort data by Age Descending");
				System.out.println("5. Back");
				System.out.print(">> ");
				sortmenu = sc.nextInt();
				sc.nextLine();

				switch (sortmenu) {
				case 1: {
					sortAscending("name");
					break;
				}
				case 2: {
					sortDescending("name");
					break;
				}
				case 3: {
					sortAscending("age");
					break;
				}
				case 4: {
					sortDescending("age");
					break;
				}
				case 5: {
					System.out.println("Back to Menu\n");
					break;
				}

				default: {
					break;
				}
				}
			} while (sortmenu != 5);
		}

	}

	private void sortAscending(String var) {
		for (int i = 0; i < names.size(); i++) {
			for (int j = 0; j < names.size() - i - 1; j++) {
				if ((var.equals("name")) ? names.get(j).compareTo(names.get(j + 1)) > 0
						: ages.get(j).compareTo(ages.get(j + 1)) > 0) {
					String temp = names.get(j);
					names.set(j, names.get(j + 1));
					names.set(j + 1, temp);

					temp = ages.get(j);
					ages.set(j, ages.get(j + 1));
					ages.set(j + 1, temp);

					temp = addresses.get(j);
					addresses.set(j, addresses.get(j + 1));
					addresses.set(j + 1, temp);
				}
			}
		}
	}

	private void sortDescending(String var) {
		for (int i = 0; i < names.size(); i++) {
			for (int j = 0; j < names.size() - i - 1; j++) {
				if ((var.equals("name")) ? names.get(j).compareTo(names.get(j + 1)) < 0
						: ages.get(j).compareTo(ages.get(j + 1)) < 0) {
					String temp = names.get(j);
					names.set(j, names.get(j + 1));
					names.set(j + 1, temp);

					temp = ages.get(j);
					ages.set(j, ages.get(j + 1));
					ages.set(j + 1, temp);

					temp = addresses.get(j);
					addresses.set(j, addresses.get(j + 1));
					addresses.set(j + 1, temp);
				}
			}
		}
	}

	private boolean isNumeric(String var) {
		boolean isNum = false;

		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);
			if (c >= '0' && c <= '9')
				isNum = true;
			else
				return false;
		}
		return isNum;
	}

	private void displayTable() {
		String createTable = String.format("| %-3s | %-20s | %-7s | %-30s |", "No.", "Name", "Age", "Address");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < names.size(); i++) {
			String createList = String.format("| %-5s | %-20s | %-7s | %-30s |", (i + 1), names.get(i), ages.get(i),
					addresses.get(i));
			System.out.println(createList);
		}
		System.out.println("=".repeat(createTable.length()));
		System.out.println();
	}

	public static void main(String[] args) {
		new Case10();
	}

}
