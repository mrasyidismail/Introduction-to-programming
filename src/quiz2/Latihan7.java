package quiz2;

import java.util.Scanner;
import java.util.Vector;

public class Latihan7 {
	Scanner sc = new Scanner(System.in);
	String studentID, email, fullName, gender, paymentMethod, department, confirmation;
	int age, genderPoint, departmentPoint, paymentPoint, menu;

	double totalDiscount, registrationPrice, money, change;

	Vector<String> studentIDs = new Vector<String>();
	Vector<String> fullNames = new Vector<String>();
	Vector<Integer> ages = new Vector<Integer>();
	Vector<String> emails = new Vector<String>();
	Vector<String> genders = new Vector<String>();
	Vector<String> departments = new Vector<String>();

	public Latihan7() {
		do {
			System.out.println("Sunib Coding Challenge");
			System.out.println("======================");
			System.out.println("1. Register Sunib Coding Challenge");
			System.out.println("2. View All Registrant");
			System.out.println("3. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				registerCoding();
				break;
			}
			case 2: {
				viewRegistrant();
				break;
			}
			case 3: {
				System.out.println("Embrace the code, compete with precision, and let algorithms define victory");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 3);
	}

	private void registerCoding() {
		do {
			System.out.print("Input Student ID [ Must starts with 26 or 27 and must be unique ] : ");
			studentID = sc.nextLine();
		} while (!(studentID.startsWith("26") || studentID.startsWith("27")) || studentIDs.contains(studentID));

		do {
			System.out.print("Input Full Name [ Must be between 5 - 25 characters ] : ");
			fullName = sc.nextLine();
		} while (fullName.length() < 5 || fullName.length() > 25);

		do {
			System.out.print("Input Age [ Must be between 17 - 21 ] : ");
			age = sc.nextInt();
			sc.nextLine();
		} while (age < 17 || age > 21);

		do {
			System.out.print("Input Gender [ Female | Male ] (Case Sensitive) : ");
			gender = sc.nextLine();
		} while (!(gender.equals("Female") || gender.equals("Male")));

		do {
			System.out.print("Input Email [ Must ends with @gmail.com ] : ");
			email = sc.nextLine();
		} while (!email.endsWith("@gmail.com"));

		do {
			System.out.print("Input Department [ SOCS | SOIS | SOD ] (Case Sensitive) : ");
			department = sc.nextLine();
		} while (!(department.equalsIgnoreCase("SOCS") || department.equalsIgnoreCase("SOIS")
				|| department.equalsIgnoreCase("SOD")));

		do {
			System.out.print("Input Payment Method [ Cash | Transfer | QRIS ] (Case Sensitive) : ");
			paymentMethod = sc.nextLine();
		} while (!(paymentMethod.equals("Cash") || paymentMethod.equals("Transfer") || paymentMethod.equals("QRIS")));

		do {
			System.out.print("Are u sure want to register [ Y | N ] (Case Sensitive) : ");
			confirmation = sc.nextLine();
		} while (!(confirmation.equals("Y") || confirmation.equals("N")));

		if (gender.equals("Male"))
			genderPoint = 10;
		else
			genderPoint = 20;

		if (department.equalsIgnoreCase("SOCS"))
			departmentPoint = 20;
		else if (department.equalsIgnoreCase("SOIS"))
			departmentPoint = 30;
		else
			departmentPoint = 25;

		if (paymentMethod.equals("Cash"))
			paymentPoint = 0;
		else if (paymentMethod.equals("Transfer"))
			paymentPoint = 5;
		else
			paymentPoint = 10;

		totalDiscount = departmentPoint + paymentPoint + genderPoint;
		registrationPrice = 100000 - (100000 * (totalDiscount / 100));

		int barrier = 15;
		String createTable = String.format("| %s %s %s |", " ".repeat(barrier), "Registration Information",
				" ".repeat(barrier));
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n",
				"Student ID", studentID);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n",
				"Full Name", fullName);
		System.out.printf("| %-" + "Registration Price".length() + "s : %-"
				+ (createTable.length() - "Registration Price :".length() - 5) + "d |\n", "Age", age);
		System.out.printf("| %-" + "Registration Price".length() + "s : %-"
				+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n", "Gender", gender);
		System.out.printf("| %-" + "Registration Price".length() + "s : %-"
				+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n", "Email", email);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n",
				"Department", department);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "f |\n",
				"Total Discount", totalDiscount);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "f |\n",
				"Registration Price", registrationPrice);
		System.out.printf(
				"| %-" + "Registration Price".length() + "s : %-"
						+ (createTable.length() - "Registration Price :".length() - 5) + "s |\n",
				"Payment Method", paymentMethod);
		System.out.println("=".repeat(createTable.length()));

		do {
			System.out.print("Input Money [ >= " + registrationPrice + " ] : ");
			money = sc.nextDouble();
			sc.nextLine();
		} while (!(money >= registrationPrice));

		change = money - registrationPrice;

		System.out.println("Change : " + change);

		System.out.println("\nGood Luck For Your Competition :)\n");

		studentIDs.add(studentID);
		fullNames.add(fullName);
		emails.add(email);
		ages.add(age);
		genders.add(gender);
		departments.add(department);
	}

	private void viewRegistrant() {
		if (studentIDs.isEmpty()) {
			System.out.println("No one has registered yet !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			String createTable = String.format("| %-15s | %-25s | %-30s | %-5s | %-8s | %-15s |", "Student ID",
					"Full Name", "Email", "Age", "Gender", "Department");
			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < studentIDs.size(); i++) {
				String createList = String.format("| %-15s | %-25s | %-30s | %-5d | %-8s | %-15s |", studentIDs.get(i),
						fullNames.get(i), emails.get(i), ages.get(i), genders.get(i), departments.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	public static void main(String[] args) {
		new Latihan7();
	}

}
