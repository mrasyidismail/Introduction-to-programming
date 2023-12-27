package lecture;

import java.util.Scanner;
import java.util.Vector;

public class Sorting {
	Scanner sc = new Scanner(System.in);

	String name, pass, phone;
	int id, menu, delete;

	Vector<String> username = new Vector<String>();
	Vector<String> password = new Vector<String>();
	Vector<String> phonenumber = new Vector<String>();
	Vector<Integer> ids = new Vector<Integer>();

	public Sorting() {
		do {
			System.out.println("Registration Form");
			System.out.println("=================");
			System.out.println("1. Input Data");
			System.out.println("2. Show Data");
			System.out.println("3. Delete Data");
			System.out.println("4. Sorting Data");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				inputData();
				break;
			}
			case 2: {
				sortingData("id");
				break;
			}
			case 3: {
				deleteData();
				break;
			}
			case 4: {
				sortingData("username");
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

	private void inputData() {
		System.out.print("Name  : ");
		name = sc.nextLine();
		System.out.print("Pass  : ");
		pass = sc.nextLine();
		System.out.print("Phone : ");
		phone = sc.nextLine();

		username.add(name);
		password.add(pass);
		phonenumber.add(phone);
		ids.add(ids.size() + 1);

		System.out.println("New data is added !\n");
	}

	private void showData() {
		if (ids.isEmpty()) {
			System.out.println("No data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-5s | %-15s | %-15s | %-15s |", "ID", "Name", "Pass", "Phone");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < ids.size(); i++) {
				String createList = String.format("| %-5d | %-15s | %-15s | %-15s |", ids.get(i), username.get(i),
						password.get(i), phonenumber.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println();
		}

	}

	private void deleteData() {
		showData();
		if (ids.isEmpty())
			return;
		do {
			System.out.print("Input ID number to be deleted : ");
			delete = sc.nextInt();
			sc.nextLine();
		} while (!ids.contains(delete));

		int index = ids.indexOf(delete);

		ids.remove(index);
		username.remove(index);
		password.remove(index);
		phonenumber.remove(index);
		System.out.println("Data has been removed!\nPress Enter to Continue...");
		sc.nextLine();
	}

	private void sortingData(String type) {
		for (int i = 0; i < ids.size(); i++) {
			for (int j = 0; j < ids.size() - 1 - i; j++) {
				if (type.equalsIgnoreCase("username") ? username.get(j).compareTo(username.get(j + 1)) < 0
						: ids.get(j).compareTo(ids.get(j + 1)) > 0) {
					int temp = ids.get(j);
					ids.set(j, ids.get(j + 1));
					ids.set(j + 1, temp);

					String temp1 = username.get(j);
					username.set(j, username.get(j + 1));
					username.set(j + 1, temp1);

					temp1 = password.get(j);
					password.set(j, password.get(j + 1));
					password.set(j + 1, temp1);

					temp1 = phonenumber.get(j);
					phonenumber.set(j, phonenumber.get(j + 1));
					phonenumber.set(j + 1, temp1);
				}
			}
		}
		showData();
	}

	public static void main(String[] args) {
		new Sorting();
	}

}
