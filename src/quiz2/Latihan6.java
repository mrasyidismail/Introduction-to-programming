package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Latihan6 {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String teamName, email, gitHub, website, teamId, confirmation;
	double registrationPrice, totalDiscount, money, change;
	int menu;

	Vector<String> teamIds = new Vector<String>();
	Vector<String> teamNames = new Vector<String>();
	Vector<String> emails = new Vector<String>();
	Vector<String> gitHubs = new Vector<String>();
	Vector<String> websites = new Vector<String>();

	public Latihan6() {
		do {
			System.out.println("Sunib Hackaton");
			System.out.println("==============");
			System.out.println("1. Register Sunib Hackaton");
			System.out.println("2. View All Registrant");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				registerHackaton();
				break;
			}
			case 2: {
				viewRegistrant();
				break;
			}
			case 3: {
				System.out.println("Embrace the code, conquer the challenge, let algorithms define exellence");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void registerHackaton() {
		do {
			System.out.print("Input Team Name [ Must be alphanumeric and Unique ] : ");
			teamName = sc.nextLine();
		} while (!isAlphanumeric(teamName) || teamNames.contains(teamName));

		do {
			System.out.print("Input Email [ Must ends with @gmail.com or @sunib.ac.id ] : ");
			email = sc.nextLine();
		} while (!(email.endsWith("@gmail.com") || email.endsWith("@sunib.ac.id")));

		do {
			System.out.print("Input GitHub Link [ Must starts with github.com/ ] : ");
			gitHub = sc.nextLine();
		} while (!gitHub.startsWith("github.com/"));

		do {
			System.out.print("Input Website [ Must starts with www. and ends with .com ] : ");
			website = sc.nextLine();
		} while (!(website.startsWith("www.") && website.endsWith(".com")));

		totalDiscount = rand.nextInt(21) + 10;
		registrationPrice = 150000 - (150000 * (totalDiscount / 100));

		do {
			System.out.print("Are u sure you want to register ? [ Y | N ] (Case Sensitive) : ");
			confirmation = sc.nextLine();
		} while (!(confirmation.equals("Y") || confirmation.equals("N")));

		if (confirmation.equals("N"))
			return;

		teamId = generateTeamID(teamName);
		int barrier = 15;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Registration Information",
				" ".repeat(barrier));

		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf("| %-" + "Registration Price".length() + "s : %-"
				+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n", "Team ID", teamId);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n",
				"Team Name", teamName);
		System.out.printf("| %-" + "Registration Price".length() + "s : %-"
				+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n", "Email", email);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n",
				"GitHub Link", gitHub);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n",
				"Website Link", website);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "f |\n",
				"Total Discount", totalDiscount);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "f |\n",
				"Registration Price", registrationPrice);

		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Input Money [ >= " + registrationPrice + " ] : ");
			money = sc.nextDouble();
		} while (!(money >= registrationPrice));

		change = money - registrationPrice;

		System.out.println("Change : " + change);
		System.out.println("\nGood Luck For Your Competition :)\n");

		teamIds.add(teamId);
		teamNames.add(teamName);
		emails.add(email);
		gitHubs.add(gitHub);
		websites.add(website);

	}

	private void viewRegistrant() {
		if (teamIds.isEmpty()) {
			System.out.println("No one has registered yet !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-12s | %-20s | %-20s | %-25s | %-25s |", "Team ID", "Team Name",
					"Email", "Github Link", "Website Link");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < teamIds.size(); i++) {
				String createList = String.format("| %-12s | %-20s | %-20s | %-25s | %-25s |", teamIds.get(i),
						teamNames.get(i), emails.get(i), gitHubs.get(i), websites.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private boolean isAlphanumeric(String var) {
		boolean isString = false;
		boolean isNum = false;

		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if (c >= '0' && c <= '9')
				isNum = true;
			else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
				isString = true;

			if (isNum && isString)
				return true;
		}
		return false;
	}

	private String generateTeamID(String var) {
		return String
				.format("T%s%03d",
						(String.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	public static void main(String[] args) {
		new Latihan6();
	}

}
