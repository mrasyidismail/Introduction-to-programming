package tutoring;

import java.util.Scanner;
import java.util.Vector;

public class Sesi7 {
	Scanner sc = new Scanner(System.in);

	String updateName, input;
	int index;
	Vector<String> listName = new Vector<String>();
	String names[] = { "Mail", "Zick", "Thomas", "Lydia", "Ranin", "Fathi", "Maylo", "Adit" };

	public Sesi7() {
		listName.add("Mail");
		listName.add("Zick");
		listName.add("Thomas");
		listName.add("Lydia");
		listName.add("Ranin");
		listName.add("Fathi");
		listName.add("Maylo");
		listName.add("Adit");
		sortbyNameAsc();
		displayName();

		do {
			System.out.print("Input Name : ");
			input = sc.nextLine();
		} while (!listName.contains(input));

		do {
			System.out.print("Enter new name [ Must be Unique and alphabetic ] : ");
			updateName = sc.nextLine();
		} while (!(isAlphabetic(updateName) && !listName.contains(updateName)));

		index = listName.indexOf(input);

		listName.set(index, updateName);

		displayName();
	}

	private void displayName() {
		for (int i = 0; i < listName.size(); i++) {
			System.out.println("No   : " + (i + 1));
			System.out.println("Name : " + listName.get(i) + " ");
		}

//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i] + " ");
//		}
	}

	private void sortbyNameAsc() {
		for (int i = 0; i < listName.size(); i++) {
			for (int j = 0; j < listName.size() - i - 1; j++) {
				if (listName.get(j).compareTo(listName.get(j + 1)) > 0) {
					String temp = listName.get(j);
					listName.set(j, listName.get(j + 1));
					listName.set(j + 1, temp);
				}
			}
		}
	}

	private void sortbyNameDesc() {
		for (int i = 0; i < listName.size(); i++) {
			for (int j = 0; j < listName.size() - i - 1; j++) {
				if (listName.get(j).compareTo(listName.get(j + 1)) < 0) {
					String temp = listName.get(j);
					listName.set(j, listName.get(j + 1));
					listName.set(j + 1, temp);
				}
			}
		}
	}

	private boolean isAlphabetic(String var) {
		boolean isChar = false;
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
				isChar = true;
			else
				return false;
		}
		return isChar;
	}

	public static void main(String[] args) {
		new Sesi7();
	}

}
