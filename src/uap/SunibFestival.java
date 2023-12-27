package uap;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class SunibFestival {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String groupName, idea, splitIdea[], location, feedbackLink, tableId, input;
	int menu, index;

	Vector<String> groupNames = new Vector<String>();
	Vector<String> ideas = new Vector<String>();
	Vector<String> locations = new Vector<String>();
	Vector<String> feedbackLinks = new Vector<String>();
	Vector<String> tableIds = new Vector<String>();

	public SunibFestival() {
		do {
			System.out.println("Sunib Festival");
			System.out.println("==============");
			System.out.println("1. Register for the exhibition");
			System.out.println("2. View all exhibits");
			System.out.println("3. Update exhibits");
			System.out.println("4. Delete exhibits");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				registerExhibit();
				break;
			}
			case 2: {
				viewExhibits();
				break;
			}
			case 3: {
				updateExhibit();
				break;
			}
			case 4: {
				deleteExhibit();
				break;
			}
			case 5: {
				System.out.println("See you at Sunib Festival !");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 5);
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
			System.out.print("Input Location [ Must be ends with 'lt.1', 'lt.2', 'lt.3' ] : ");
			location = sc.nextLine();
		} while (!(location.endsWith("lt.1") || location.endsWith("lt.2") || location.endsWith("lt.3")));

		do {
			System.out.print("Input Feedback Link [ Must starts with 'forms.com/' ] : ");
			feedbackLink = sc.nextLine();
		} while (!feedbackLink.startsWith("forms.com/"));

		tableId = String.format("TB%03d", (rand.nextInt(999) + 1));

		int barrier = 10;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Exhibition Information",
				" ".repeat(barrier));
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf("| %-" + "Feedback Link".length() + "s : %-"
				+ (createTable.length() - "Feedback Link :".length() - 5) + "s |\n", "Table ID", tableId);
		System.out.printf("| %-" + "Feedback Link".length() + "s : %-"
				+ (createTable.length() - "Feedback Link :".length() - 5) + "s |\n", "Group Name", groupName);
		System.out.printf("| %-" + "Feedback Link".length() + "s : %-"
				+ (createTable.length() - "Feedback Link :".length() - 5) + "s |\n", "Idea", idea);
		System.out.printf("| %-" + "Feedback Link".length() + "s : %-"
				+ (createTable.length() - "Feedback Link :".length() - 5) + "s |\n", "Location", location);
		System.out.printf("| %-" + "Feedback Link".length() + "s : %-"
				+ (createTable.length() - "Feedback Link :".length() - 5) + "s |\n", "Feedback Link", feedbackLink);
		System.out.println("=".repeat(createTable.length()));
		System.out.println("Press Enter to Continue...");
		sc.nextLine();

		tableIds.add(tableId);
		groupNames.add(groupName);
		ideas.add(idea);
		locations.add(location);
		feedbackLinks.add(feedbackLink);
	}

	private void viewExhibits() {
		if (tableIds.isEmpty()) {
			System.out.println("There is no exhibition yet!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyID();
			displayTable();
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void updateExhibit() {
		if (tableIds.isEmpty()) {
			System.out.println("There is no exhibition yet!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyID();
			displayTable();

			do {
				System.out.print("Input Table ID [ e.g. " + tableIds.get(0) + " ] : ");
				input = sc.nextLine();
			} while (!tableIds.contains(input));

			do {
				System.out.print("Input Location [ Must be ends with 'lt.1', 'lt.2', 'lt.3' ] : ");
				location = sc.nextLine();
			} while (!(location.endsWith("lt.1") || location.endsWith("lt.2") || location.endsWith("lt.3")));

			index = tableIds.indexOf(input);
			locations.set(index, location);

			System.out.println("Successfully Updated Exhibit !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deleteExhibit() {
		if (tableIds.isEmpty()) {
			System.out.println("There is no exhibition yet!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyID();
			displayTable();

			do {
				System.out.print("Input Table ID [ e.g. " + tableIds.get(0) + " ] : ");
				input = sc.nextLine();
			} while (!tableIds.contains(input));

			index = tableIds.indexOf(input);

			tableIds.remove(index);
			groupNames.remove(index);
			ideas.remove(index);
			locations.remove(index);
			feedbackLinks.remove(index);

			System.out.println("Successfully Deleted Exhibition Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private boolean isAlphabetic(String var) {
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

	private boolean contain3words(String var) {
		splitIdea = var.split(" ");

		return splitIdea.length >= 3;
	}

	private void sortbyID() {
		for (int i = 0; i < tableIds.size(); i++) {
			for (int j = 0; j < tableIds.size() - i - 1; j++) {
				if (tableIds.get(j).compareTo(tableIds.get(j + 1)) < 0) {
					String temp = tableIds.get(j);
					tableIds.set(j, tableIds.get(j + 1));
					tableIds.set(j + 1, temp);

					temp = groupNames.get(j);
					groupNames.set(j, groupNames.get(j + 1));
					groupNames.set(j + 1, temp);

					temp = groupNames.get(j);
					groupNames.set(j, groupNames.get(j + 1));
					groupNames.set(j + 1, temp);

					temp = locations.get(j);
					locations.set(j, locations.get(j + 1));
					locations.set(j + 1, temp);

					temp = ideas.get(j);
					ideas.set(j, ideas.get(j + 1));
					ideas.set(j + 1, temp);

					temp = feedbackLinks.get(j);
					feedbackLinks.set(j, feedbackLinks.get(j + 1));
					feedbackLinks.set(j + 1, temp);
				}
			}
		}
	}

	private void displayTable() {
		String createTable = String.format("| %-10s | %-20s | %-30s | %-15s | %-25s |", "Table ID", "Group Name",
				"Idea", "Location", "Feedback Link");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < tableIds.size(); i++) {
			String createList = String.format("| %-10s | %-20s | %-30s | %-15s | %-25s |", tableIds.get(i),
					groupNames.get(i), ideas.get(i), locations.get(i), feedbackLinks.get(i));
			System.out.println(createList);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	public static void main(String[] args) {
		new SunibFestival();
	}

}
