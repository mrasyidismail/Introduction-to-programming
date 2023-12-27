package lecture;

import java.util.Scanner;
import java.util.Vector;

public class Registration {
	Scanner sc = new Scanner(System.in);
	Vector<String> customerNames = new Vector<String>();
	Vector<String> customerPasswords = new Vector<String>();
	Vector<String> phoneNumbers = new Vector<String>();

	int menu, deleteIndex;
	String customerName, customerPassword, phoneNumber;

	public Registration() {

		do {
			try {
				System.out.print("1. Input Data\n2. Show Data\n3. Delete Data\n4. Sort Data\n5. Exit\nYour choice: ");
				menu = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please input a number !\n");
			} finally {
				sc.nextLine();
			}

			switch (menu) {
			case 1: {
				inputData();
				break;
			}
			case 2: {
				showData();
				break;
			}
			case 3: {
				deleteData();
				break;
			}
			case 4: {
				sortData();
				break;
			}
			case 5: {
				System.out.println("Program has been closed !");
				break;
			}

			default: {
				break;
			}
			}

		} while (menu != 5);

	}

	private void deleteData() {
		showData();
		if (customerNames.isEmpty())
			return;

		while (true) {
			try {
				while (true) {
					System.out.print("Input data number to be deleted : ");
					deleteIndex = sc.nextInt();
					try {
						customerNames.remove(deleteIndex - 1);
						customerPasswords.remove(deleteIndex - 1);
						phoneNumbers.remove(deleteIndex - 1);
						break;
					} catch (Exception e) {
						System.out.println("Please input a valid number on the table !");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println("Please input a number !");
			} finally {
				sc.nextLine();
			}

		}

		System.out.println("Data is removed !\n");

	}

	private void showData() {
		if (customerNames.isEmpty())
			System.out.println("No data exists !\n");
		else {
			displayTable();
		}
	}

	private void displayTable() {
		System.out.println("-------------------------------------------");
		System.out.printf("|%-2s| %-10s | %-10s | %-10s |\n", "No", "Name", "Pass", "Phone");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < customerNames.size(); i++) {
			System.out.printf("|%-2d| %-10s | %-10s | %-10s |\n", (i + 1), customerNames.get(i),
					customerPasswords.get(i), phoneNumbers.get(i));
		}
		System.out.println("-------------------------------------------");
		System.out.println();
	}

	private void inputData() {
		System.out.print("Name : ");
		customerName = sc.nextLine();

		System.out.print("Pass : ");
		customerPassword = sc.nextLine();

		System.out.print("Phone : ");
		phoneNumber = sc.nextLine();
		System.out.println("New data is added\n");

		customerNames.add(customerName);
		customerPasswords.add(customerPassword);
		phoneNumbers.add(phoneNumber);
	}

	private void sortData() {
		if (customerNames.isEmpty())
			System.out.println("No data exists !\n");
		else {
			sortbyName();
			displayTable();
		}
	}

	private void sortbyName() {
		for (int i = 0; i < customerNames.size(); i++) {
			for (int j = 0; j < customerNames.size() - 1 - i; j++) {
				if (customerNames.get(j).compareTo(customerNames.get(j + 1)) > 0) {
					String temp = customerNames.get(j);
					customerNames.set(j, customerNames.get(j + 1));
					customerNames.set(j + 1, temp);

					temp = customerPasswords.get(j);
					customerPasswords.set(j, customerPasswords.get(j + 1));
					customerPasswords.set(j + 1, temp);

					temp = phoneNumbers.get(j);
					phoneNumbers.set(j, phoneNumbers.get(j + 1));
					phoneNumbers.set(j + 1, temp);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Registration();
	}

}
