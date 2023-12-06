package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan2 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String groupName, location, idea, splitIdea[], feedback, tableID;
	int menu;

	Vector<String> tableIDs = new Vector<String>();
	Vector<String> groupNames = new Vector<String>();
	Vector<String> locations = new Vector<String>();
	Vector<String> ideas = new Vector<String>();
	Vector<String> feedbacks = new Vector<String>();

	public Latihan2() {
		do {
			System.out.println("Sunib Festival");
			System.out.println("==============");
			System.out.println("1. Register for the exhibition");
			System.out.println("2. View all exhibits");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				registerExhibit();
				break;
			}
			case 2: {
				viewData();
				break;
			}
			case 3: {
				System.out.println("See you at sunib festival !");
				break;
			}
			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void registerExhibit() {
		do {
			System.out.print("Input Group Name [ Must be alphabetic and Unique ] : ");
			groupName = sc.nextLine();
		} while (!(isAlphabetic(groupName) && !groupNames.contains(groupName)));

		do {
			System.out.print("Input Idea [ Must be atleast contain 3 words ] : ");
			idea = sc.nextLine();
		} while (!contain3words(idea));

		do {
			System.out.print("Input Location [ Must be ends with 'lt.1', 'lt.2', or 'lt.3' ]: ");
			location = sc.nextLine();
		} while (!(location.endsWith("lt.1") || location.endsWith("lt.2") || location.endsWith("lt.3")));

		do {
			System.out.print("Input feedback link [ Must starts with 'forms.com/' ] : ");
			feedback = sc.nextLine();
		} while (!feedback.startsWith("forms.com/"));

		tableID = String.format("TB%03d", (rand.nextInt(999) + 1));
		int barrier = 15;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Exhibit Information",
				" ".repeat(barrier));
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf(
				"| %-" + "Feedback Link".length() + "s : %-"
						+ (createTable.length() - "Feedback Link :".length() - tableID.length()) + "s |\n",
				"Table ID", tableID);
		System.out.printf(
				"| %-" + "Feedback Link".length() + "s : %-"
						+ (createTable.length() - "Feedback Link :".length() - tableID.length()) + "s |\n",
				"Group Name", groupName);
		System.out.printf(
				"| %-" + "Feedback Link".length() + "s : %-"
						+ (createTable.length() - "Feedback Link :".length() - tableID.length()) + "s |\n",
				"Idea", idea);
		System.out.printf(
				"| %-" + "Feedback Link".length() + "s : %-"
						+ (createTable.length() - "Feedback Link :".length() - tableID.length()) + "s |\n",
				"Location", location);
		System.out.printf(
				"| %-" + "Feedback Link".length() + "s : %-"
						+ (createTable.length() - "Feedback Link :".length() - tableID.length()) + "s |\n",
				"Feedback Link", feedback);
		System.out.println("=".repeat(createTable.length()));

		tableIDs.add(tableID);
		groupNames.add(groupName);
		ideas.add(idea);
		locations.add(location);
		feedbacks.add(feedback);
		System.out.println("Data has been added !\n");
	}

	private void viewData() {
		if (tableIDs.isEmpty()) {
			System.out.println("There is no exhibition yet!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-13s | %-25s | %-25s | %-15s | %-25s |", "Table ID", "Group Name",
					"Idea", "Location", "Feedback Link");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));

			for (int i = 0; i < tableIDs.size(); i++) {
				String createList = String.format("| %-13s | %-25s | %-25s | %-15s | %-25s |", tableIDs.get(i),
						groupNames.get(i), ideas.get(i), locations.get(i), feedbacks.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continute...");
			sc.nextLine();
		}

	}

	private boolean isAlphabetic(String var) {
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
				return true;
		}
		return false;
	}

	private boolean contain3words(String var) {
		splitIdea = var.split(" ");
		return splitIdea.length >= 3;
	}

	public static void main(String[] args) {
		new Latihan2();
	}

}
