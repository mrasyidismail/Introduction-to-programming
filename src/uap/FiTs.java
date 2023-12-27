package uap;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class FiTs {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String practiceName, topic, splitTopic[], difficult, practiceId, confirmation, input;
	int view, menu, session, difficultPoint, index;

	Vector<String> practiceNames = new Vector<String>();
	Vector<Integer> sessions = new Vector<Integer>();
	Vector<String> topics = new Vector<String>();
	Vector<String> difficults = new Vector<String>();
	Vector<Integer> views = new Vector<Integer>();
	Vector<String> practiceIds = new Vector<String>();

	public FiTs() {
		do {
			System.out.println("FiTs Practice List");
			System.out.println("==================");
			System.out.println("1. Add new practice");
			System.out.println("2. View all practice");
			System.out.println("3. Update practice");
			System.out.println("4. Delete Practice");
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
				viewPractices();
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

			default: {
				break;
			}
			}
		} while (menu != 5);
	}

	private void createPractice() {
		do {
			System.out.print("Input Practice Name [ Must be unique and more than 5 characters ] : ");
			practiceName = sc.nextLine();
		} while (practiceName.length() <= 5 || practiceNames.contains(practiceName));

		do {
			System.out.print("Input Session Number [ Must be between 1 - 12 ] (Inclusive) : ");
			session = sc.nextInt();
			sc.nextLine();
		} while (session < 1 || session > 12);

		do {
			System.out.print("Input Topic [ Must be atleast contain 2 words ] : ");
			topic = sc.nextLine();
		} while (!contains2Word(topic));

		do {
			System.out.print("Input Difficult Level [ Easy | Medium | Hard ] (Case Sensitive) : ");
			difficult = sc.nextLine();
		} while (!(difficult.equals("Easy") || difficult.equals("Medium") || difficult.equals("Hard")));

		practiceId = generateID(session);

		if (difficult.equals("Easy"))
			difficultPoint = 1000;
		else if (difficult.equals("Medium"))
			difficultPoint = 1500;
		else
			difficultPoint = 2000;

		view = (practiceName.length() * difficultPoint) + (rand.nextInt(9001) + 1000);

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
		System.out.printf("| %-" + "Difficulty Point".length() + "s : %-"
				+ (createTable.length() - "Difficulty Point :".length() - 5) + "d |\n", "Session", session);
		System.out.printf("| %-" + "Difficulty Point".length() + "s : %-"
				+ (createTable.length() - "Difficulty Point :".length() - 5) + "s |\n", "Topic", topic);
		System.out.printf(
				"| %-" + "Difficulty Point".length() + "s : %-"
						+ (createTable.length() - "Difficulty Point :".length() - 5) + "s |\n",
				"Difficult Level", difficult);
		System.out.printf(
				"| %-" + "Difficulty Point".length() + "s : %-"
						+ (createTable.length() - "Difficulty Point :".length() - 5) + "d |\n",
				"Difficult Point", difficultPoint);
		System.out.printf("| %-" + "Difficulty Point".length() + "s : %-"
				+ (createTable.length() - "Difficulty Point :".length() - 5) + "d |\n", "Views", view);
		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Input Confirmation [ Y | N ] (Case Sensitive) : ");
			confirmation = sc.nextLine();
		} while (!(confirmation.equals("Y") || confirmation.equals("N")));

		if (confirmation.equals("N")) {
			System.out.println("Canceled!\n");
			return;
		}

		practiceIds.add(practiceId);
		practiceNames.add(practiceName);
		sessions.add(session);
		topics.add(topic);
		views.add(view);
		difficults.add(difficult);
		System.out.println("Successfully added practice data!");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private void viewPractices() {
		if (practiceIds.isEmpty()) {
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
		if (practiceIds.isEmpty()) {
			noData();
		} else {
			if (!checkSession())
				sortBySession();
			else
				sortByViews();
			displayTable();

			do {
				System.out.print("Input Practice ID [ e.g. " + practiceIds.get(0) + " ] : ");
				input = sc.nextLine();
			} while (!practiceIds.contains(input));

			index = practiceIds.indexOf(input);

			do {
				System.out.print("Input Session Number [ Must be between 1 - 12 ] (Inclusive) : ");
				session = sc.nextInt();
				sc.nextLine();
			} while (session < 1 || session > 12);

			do {
				System.out.print("Input Difficult Level [ Easy | Medium | Hard ] (Case Sensitive) : ");
				difficult = sc.nextLine();
			} while (!(difficult.equals("Easy") || difficult.equals("Medium") || difficult.equals("Hard")));

			if (difficult.equals("Easy"))
				difficultPoint = 1000;
			else if (difficult.equals("Medium"))
				difficultPoint = 1500;
			else
				difficultPoint = 2000;

			view = (practiceName.length() * difficultPoint) + (rand.nextInt(9001) + 1000);

			sessions.set(index, session);
			difficults.set(index, difficult);

			System.out.println("Successfully Updated Practice!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deletePractice() {
		if (practiceIds.isEmpty()) {
			noData();
		} else {
			if (!checkSession())
				sortBySession();
			else
				sortByViews();
			displayTable();

			do {
				System.out.print("Input Practice ID [ e.g. " + practiceIds.get(0) + " ] : ");
				input = sc.nextLine();
			} while (!practiceIds.contains(input));

			index = practiceIds.indexOf(input);

			practiceIds.remove(index);
			practiceNames.remove(index);
			sessions.remove(index);
			topics.remove(index);
			difficults.remove(index);
			views.remove(index);

			System.out.println("Successfully deleted practice!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
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

	private void sortBySession() {
		for (int i = 0; i < practiceIds.size(); i++) {
			for (int j = 0; j < practiceIds.size() - i - 1; j++) {
				if (sessions.get(j).compareTo(sessions.get(j + 1)) > 0) {
					String temp = practiceIds.get(j);
					practiceIds.set(j, practiceIds.get(j + 1));
					practiceIds.set(j + 1, temp);

					temp = practiceNames.get(j);
					practiceNames.set(j, practiceNames.get(j + 1));
					practiceNames.set(j + 1, temp);

					temp = topics.get(j);
					topics.set(j, topics.get(j + 1));
					topics.set(j + 1, temp);

					temp = difficults.get(j);
					difficults.set(j, difficults.get(j + 1));
					difficults.set(j + 1, temp);

					int temp1 = sessions.get(j);
					sessions.set(j, sessions.get(j + 1));
					sessions.set(j + 1, temp1);

					temp1 = views.get(j);
					views.set(j, views.get(j + 1));
					views.set(j + 1, temp1);
				}
			}
		}
	}

	private void sortByViews() {
		for (int i = 0; i < practiceIds.size(); i++) {
			for (int j = 0; j < practiceIds.size() - i - 1; j++) {
				if (views.get(j).compareTo(views.get(j + 1)) < 0) {
					String temp = practiceIds.get(j);
					practiceIds.set(j, practiceIds.get(j + 1));
					practiceIds.set(j + 1, temp);

					temp = practiceNames.get(j);
					practiceNames.set(j, practiceNames.get(j + 1));
					practiceNames.set(j + 1, temp);

					temp = topics.get(j);
					topics.set(j, topics.get(j + 1));
					topics.set(j + 1, temp);

					temp = difficults.get(j);
					difficults.set(j, difficults.get(j + 1));
					difficults.set(j + 1, temp);

					int temp1 = sessions.get(j);
					sessions.set(j, sessions.get(j + 1));
					sessions.set(j + 1, temp1);

					temp1 = views.get(j);
					views.set(j, views.get(j + 1));
					views.set(j + 1, temp1);
				}
			}
		}
	}

	private boolean checkSession() {
		boolean isSame = false;
		for (int i = 0; i < sessions.size(); i++) {
			for (int j = 0; j < sessions.size() - i - 1; j++) {
				if (sessions.get(j) == sessions.get(j + 1))
					isSame = true;
			}
		}
		return isSame;
	}

	private void displayTable() {
		String createTable = String.format("| %-15s | %-25s | %-7s | %-25s | %-17s | %-10s |", "Practice ID",
				"Practice Name", "Session", "Topic", "Difficulty Level", "Views");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < practiceIds.size(); i++) {
			String createList = String.format("| %-15s | %-25s | %-7d | %-25s | %-17s | %-10d |", practiceIds.get(i),
					practiceNames.get(i), sessions.get(i), topics.get(i), difficults.get(i), views.get(i));
			System.out.println(createList);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	public static void main(String[] args) {
		new FiTs();
	}

}
