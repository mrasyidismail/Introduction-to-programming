package oop;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Practice {
	String name, topic, difficult, id;
	int views, session;

	public Practice(String name, String topic, String difficult, String id, int views, int session) {
		this.name = name;
		this.topic = topic;
		this.difficult = difficult;
		this.id = id;
		this.views = views;
		this.session = session;
	}
}

public class FiTs {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String practiceName, practiceTopic, splitTopic[], practiceDifficult, practiceId, confirmation, input;
	int practiceViews, menu, practiceSession, difficultPoint, index;

	Vector<Practice> practices = new Vector<Practice>();

	public FiTs() {
		do {
			System.out.println("FiTs Practice List");
			System.out.println("==================");
			System.out.println("1. Add new practice");
			System.out.println("2. View all practices");
			System.out.println("3. Update a practice");
			System.out.println("4. Delete a practice");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				createPractice();
				break;
			}
			case 2: {
				viewPractice();
				break;
			}
			case 3: {
				updatePractice();
				break;
			}
			case 4: {
				deletePractice();
				break;
			}
			case 5: {
				System.out.println(
						"Congratulations, you succeeded in doing all the practice questions that I made\nI really appreaciate your hard work and good luck to all of you for the next semester\nGood Byeeee :) - XX22-1");
				break;
			}

			default:
				break;
			}
		} while (menu != 5);
	}

	private void createPractice() {
		do {
			System.out.print("Input Practice Name [ Must be more than 5 characters and Unique ] : ");
			practiceName = sc.nextLine();
		} while (!(isUnique(practiceName) && !(practiceName.length() < 5)));

		do {
			System.out.print("Input Session Number [ Must be between 1 - 12 ] (Inclusive) : ");
			practiceSession = sc.nextInt();
			sc.nextLine();
		} while (practiceSession < 1 || practiceSession > 12);

		do {
			System.out.print("Input Topic [ Must be at least contains 2 words ] : ");
			practiceTopic = sc.nextLine();
		} while (!contains2Word(practiceTopic));

		do {
			System.out.print("Input Difficult Level [ Easy | Medium | Hard ] (Case Sensitive) : ");
			practiceDifficult = sc.nextLine();
		} while (!(practiceDifficult.equals("Easy") || practiceDifficult.equals("Medium")
				|| practiceDifficult.equals("Hard")));

		practiceId = generateID(practiceSession);

		if (practiceDifficult.equals("Easy"))
			difficultPoint = 1000;
		else if (practiceDifficult.equals("Medium"))
			difficultPoint = 1500;
		else
			difficultPoint = 2000;

		practiceViews = (practiceName.length() * difficultPoint) + (rand.nextInt(9001) + 1000);

		int barrier = 10;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Practice Information",
				" ".repeat(barrier));
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf(
				"| %-" + "Difficulty Point".length() + "s : %-"
						+ (createTable.length() - "Difficulty Point :".length() - 5) + "s |\n",
				"Practice ID", practiceId);
		System.out.printf(
				"| %-" + "Difficulty Point".length() + "s : %-"
						+ (createTable.length() - "Difficulty Point :".length() - 5) + "s |\n",
				"Practice Name", practiceName);
		System.out.printf(
				"| %-" + "Difficulty Point".length() + "s : %-"
						+ (createTable.length() - "Difficulty Point :".length() - 5) + "d |\n",
				"Session", practiceSession);
		System.out.printf("| %-" + "Difficulty Point".length() + "s : %-"
				+ (createTable.length() - "Difficulty Point :".length() - 5) + "s |\n", "Topic", practiceTopic);
		System.out.printf(
				"| %-" + "Difficulty Point".length() + "s : %-"
						+ (createTable.length() - "Difficulty Point :".length() - 5) + "s |\n",
				"Difficult Level", practiceDifficult);
		System.out.printf(
				"| %-" + "Difficulty Point".length() + "s : %-"
						+ (createTable.length() - "Difficulty Point :".length() - 5) + "d |\n",
				"Difficult Point", difficultPoint);
		System.out.printf("| %-" + "Difficulty Point".length() + "s : %-"
				+ (createTable.length() - "Difficulty Point :".length() - 5) + "d |\n", "Views", practiceViews);
		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Input Confirmation [ Y | N ] (Case Sensitive) : ");
			confirmation = sc.nextLine();
		} while (!(confirmation.equals("Y") || confirmation.equals("N")));

		if (confirmation.equals("N")) {
			System.out.println("Canceled!\n");
			return;
		}

		practices.add(new Practice(practiceName, practiceTopic, practiceDifficult, practiceId, practiceViews,
				practiceSession));
		System.out.println("Successfully added practice data!");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private void viewPractice() {
		if (practices.isEmpty()) {
			noData();
		} else {
			if (!checkSession())
				sortBySession();
			else
				sortByViews();
			displayTable();
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void updatePractice() {
		if (practices.isEmpty()) {
			noData();
		} else {
			if (!checkSession())
				sortBySession();
			else
				sortByViews();
			displayTable();

			do {
				System.out.print("Input Practice ID [ e.g. " + practices.get(0).id + " ] : ");
				input = sc.nextLine();
			} while (!isMatch(input));

			for (int i = 0; i < practices.size(); i++) {
				if (practices.get(i).id.equals(input))
					index = i;
			}

			do {
				System.out.print("Input Session Number [ Must be between 1 - 12 ] (Inclusive) : ");
				practiceSession = sc.nextInt();
				sc.nextLine();
			} while (practiceSession < 1 || practiceSession > 12);

			do {
				System.out.print("Input Difficult Level [ Easy | Medium | Hard ] (Case Sensitive) : ");
				practiceDifficult = sc.nextLine();
			} while (!(practiceDifficult.equals("Easy") || practiceDifficult.equals("Medium")
					|| practiceDifficult.equals("Hard")));

			if (practiceDifficult.equals("Easy"))
				difficultPoint = 1000;
			else if (practiceDifficult.equals("Medium"))
				difficultPoint = 1500;
			else
				difficultPoint = 2000;

			practiceViews = (practiceName.length() * difficultPoint) + (rand.nextInt(9001) + 1000);
			practices.set(index, new Practice(practices.get(index).name, practices.get(index).topic, practiceDifficult,
					practices.get(index).id, practiceViews, practiceSession));

			System.out.println("Successfully Updated Practice!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deletePractice() {
		if (practices.isEmpty()) {
			noData();
		} else {
			if (!checkSession())
				sortBySession();
			else
				sortByViews();
			displayTable();

			do {
				System.out.print("Input Practice ID [ e.g. " + practices.get(0).id + " ] : ");
				input = sc.nextLine();
			} while (!isMatch(input));

			for (int i = 0; i < practices.size(); i++) {
				if (practices.get(i).id.equals(input))
					index = i;
			}

			practices.remove(index);
			System.out.println("Successfully deleted practice!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private boolean isUnique(String var) {
		boolean isUnique = true;

		for (int i = 0; i < practices.size(); i++) {
			if (practices.get(i).name.equals(var))
				isUnique = false;
		}
		return isUnique;
	}

	private boolean contains2Word(String var) {
		splitTopic = var.split(" ");
		return splitTopic.length >= 2;
	}

	private String generateID(int var) {
		return String.format("%03d-FT-%d", (rand.nextInt(999) + 1), var).toUpperCase();
	}

	private void noData() {
		System.out.println("There is no practice data!");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private boolean checkSession() {
		boolean isSame = false;
		for (int i = 0; i < practices.size(); i++) {
			for (int j = 0; j < practices.size() - i - 1; j++) {
				if (practices.get(j).session == practices.get(j + 1).session)
					isSame = true;
			}
		}
		return isSame;
	}

	private void sortBySession() {
		for (int i = 0; i < practices.size(); i++) {
			for (int j = 0; j < practices.size() - i - 1; j++) {
				if (practices.get(j).session > practices.get(j + 1).session) {
					Practice temp = practices.get(j);
					practices.set(j, practices.get(j + 1));
					practices.set(j + 1, temp);
				}
			}
		}
	}

	private void sortByViews() {
		for (int i = 0; i < practices.size(); i++) {
			for (int j = 0; j < practices.size() - i - 1; j++) {
				if (practices.get(j).views < practices.get(j + 1).views) {
					Practice temp = practices.get(j);
					practices.set(j, practices.get(j + 1));
					practices.set(j + 1, temp);
				}
			}
		}
	}

	private void displayTable() {
		String createTable = String.format("| %-15s | %-25s | %-7s | %-25s | %-17s | %-10s |", "Practice ID",
				"Practice Name", "Session", "Topic", "Difficulty Level", "Views");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < practices.size(); i++) {
			String createList = String.format("| %-15s | %-25s | %-7d | %-25s | %-17s | %-10d |", practices.get(i).id,
					practices.get(i).name, practices.get(i).session, practices.get(i).topic, practices.get(i).difficult,
					practices.get(i).views);
			System.out.println(createList);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	private boolean isMatch(String var) {
		boolean isMatch = false;

		for (int i = 0; i < practices.size(); i++) {
			if (practices.get(i).id.equals(var))
				isMatch = true;
		}
		return isMatch;
	}

	public static void main(String[] args) {
		new FiTs();
	}

}
