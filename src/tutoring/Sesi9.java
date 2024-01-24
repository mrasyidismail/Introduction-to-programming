package tutoring;

import java.util.Scanner;
import java.util.Vector;

public class Sesi9 {
	Scanner sc = new Scanner(System.in);

	int menu, index;
	String name, password, phone;

	Vector<String> names = new Vector<String>();
	Vector<String> passwords = new Vector<String>();
	Vector<String> phones = new Vector<String>();

	public Sesi9() {
		do {
			System.out.println("1. Input Data");
			System.out.println("2. Show Data");
			System.out.println("3. Delete Data");
			System.out.println("4. Sort Data");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				inputData();
				break;
			case 2:
				showData();
				break;
			case 3:
				deleteData();
				break;
			case 4:
				sortData();
				break;
			case 5:
				System.out.println("Closed");
				break;
			default:
				break;
			}
		} while (menu != 5);
	}

	private void inputData() {
		do {
			System.out.print("Input Name [ Must be alphabetic ] : ");
			name = sc.nextLine();
		} while (!isAlphabetic(name));

		System.out.print("Input Phone : ");
		phone = sc.nextLine();

		System.out.print("Input Password : ");
		password = sc.nextLine();

		System.out.println("New Data is added !");

		names.add(name);
		phones.add(phone);
		passwords.add(password);
	}

	private void showData() {
		if (names.isEmpty())
			System.out.println("No data !");
		else {
			for (int i = 0; i < names.size(); i++) {
				System.out.println("No       : " + (i + 1));
				System.out.println("Name     : " + names.get(i));
				System.out.println("Phone    : " + phones.get(i));
				System.out.println("Password : " + passwords.get(i));
			}
		}
	}

	private void deleteData() {
		if (names.isEmpty())
			System.out.println("No data !");
		else {
			for (int i = 0; i < names.size(); i++) {
				System.out.println("No       : " + (i + 1));
				System.out.println("Name     : " + names.get(i));
				System.out.println("Phone    : " + phones.get(i));
				System.out.println("Password : " + passwords.get(i));
			}
			System.out.println("======================");

			do {
				System.out.print("Input data number to be deleted : ");
				index = sc.nextInt();
				sc.nextLine();
			} while (index <= 0 || index > names.size());

			index = index - 1;

			names.remove(index);
			phones.remove(index);
			passwords.remove(index);

			System.out.println("Data is removed !");
		}

	}

	private void sortData() {
		if (names.isEmpty())
			System.out.println("No data !");
		else {
			for (int i = 0; i < names.size(); i++) {
				for (int j = 0; j < names.size() - i - 1; j++) {
					if (names.get(j).compareTo(names.get(j + 1)) > 0) {
						String temp = names.get(i);
						names.set(i, names.get(j + 1));
						names.set(j + 1, temp);

						temp = phones.get(i);
						phones.set(i, phones.get(j + 1));
						phones.set(j + 1, temp);

						temp = passwords.get(i);
						passwords.set(i, passwords.get(j + 1));
						passwords.set(j + 1, temp);
					}
				}
			}
			showData();
		}
	}

	public boolean isAlphabetic(String var) {
		boolean isChar = false;
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
				isChar = true;
			else
				return false;
		}
		return isChar;
	}

	public static void main(String[] args) {
		new Sesi9();
	}

}
