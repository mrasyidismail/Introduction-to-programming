package bluejack;

import java.util.Scanner;
import java.util.Vector;

public class Case11 {
	Scanner sc = new Scanner(System.in);

	String name, splitName[], gender, address, initial;
	int menu, age, index;

	Vector<String> names = new Vector<String>();
	Vector<String> genders = new Vector<String>();
	Vector<String> addresses = new Vector<String>();
	Vector<String> initials = new Vector<String>();
	Vector<Integer> ages = new Vector<Integer>();

	public Case11() {
		do {
			System.out.println("POWER Recruitment");
			System.out.println("=================");
			System.out.println("1. Input New Candidate");
			System.out.println("2. View Candidate's Data");
			System.out.println("3. Remove Candidate");
			System.out.println("4. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				register();
				break;
			}
			case 2: {
				viewData();
				break;
			}
			case 3: {
				removeData();
				break;
			}
			case 4: {
				System.out.println("Program has been closed !");
				break;
			}

			default:
				break;
			}
		} while (menu != 4);
	}

	private void register() {
		do {
			System.out.print("Input candidate's name [5..20] : ");
			name = sc.nextLine();

			if (name.startsWith(" ") || name.endsWith(" "))
				System.out.println("Name cannot starts with or ends with space !\n");
			else if (!isMorethan2(name))
				System.out.println("Name must be atleast 2 words!\n");
		} while (!(isMorethan2(name) && !(name.length() < 5 || name.length() > 20)));

		do {
			System.out.print("Input candidate's gender [male | female] : ");
			gender = sc.nextLine();
		} while (!(gender.equals("male") || gender.equals("female")));

		do {
			System.out.print("Input candidate's address [ must be ended with 'street'] : ");
			address = sc.nextLine();
		} while (!address.endsWith("street"));

		do {
			System.out.print("Input candidate's age [17..30] : ");
			age = sc.nextInt();
			sc.nextLine();
		} while (age < 17 || age > 30);

		System.out.println("Thank you for registering! Your initial is : " + generateIntial(name));

		initial = generateIntial(name);
		initials.add(initial);
		names.add(name);
		genders.add(gender);
		ages.add(age);
		addresses.add(address);

		System.out.println();
	}

	private void viewData() {
		if (initials.isEmpty()) {
			System.out.println("No data!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyName();
			displayTable();
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void removeData() {
		if (initials.isEmpty()) {
			System.out.println("No data!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			displayTable();
			do {
				System.out.print("Input candidate to be removed [1.." + initials.size() + "] [0 for cancel] : ");
				index = sc.nextInt();
				sc.nextLine();
			} while (index < 0 || index > initials.size());

			if (index == 0) {
				System.out.println("Canceled !");
				System.out.println("Press Enter to Continue...");
				sc.nextLine();
				return;
			} else {

				index = index - 1;

				initials.remove(index);
				names.remove(index);
				ages.remove(index);
				genders.remove(index);
				addresses.remove(index);

				System.out.println("Candidate Removed !\n");
			}

		}
	}

	private void displayTable() {
		String createTable = String.format("| %-3s | %-20s | %-7s | %-7s | %-5s | %-25s |", "No.", "Name", "Initial",
				"Gender", "Age", "Address");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < initials.size(); i++) {
			String createList = String.format("| %-3d | %-20s | %-7s | %-7s | %-5d | %-25s |", (i + 1), names.get(i),
					initials.get(i), genders.get(i), ages.get(i), addresses.get(i));
			System.out.println(createList);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	private boolean isMorethan2(String var) {
		if (var.startsWith(" ") || var.endsWith(" "))
			return false;
		splitName = var.split(" ");

		return splitName.length >= 2;
	}

	private String generateIntial(String var) {
		return String.format("%s%s", splitName[0].charAt(0), splitName[1].charAt(0)).toUpperCase();
	}

	private void sortbyName() {
		for (int i = 0; i < initials.size(); i++) {
			for (int j = 0; j < initials.size() - i - 1; j++) {
				if (names.get(j).compareTo(names.get(j + 1)) > 0) {
					String temp = names.get(j);
					names.set(j, names.get(j + 1));
					names.set(j + 1, temp);

					temp = initials.get(j);
					initials.set(j, initials.get(j + 1));
					initials.set(j + 1, temp);

					temp = addresses.get(j);
					addresses.set(j, addresses.get(j + 1));
					addresses.set(j + 1, temp);

					int temp1 = ages.get(j);
					ages.set(j, ages.get(j + 1));
					ages.set(j + 1, temp1);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Case11();
	}

}
