/**
 * @author github.com/mrasyidismail
 */
package quiz;

import java.util.Scanner;
import java.util.Vector;

public class Latihan6 {
	Scanner sc = new Scanner(System.in);
	String name, position, query;
	int menu, age, id = 0;
	Vector<String> staffName = new Vector<String>();
	Vector<String> staffPosition = new Vector<String>();
	Vector<Integer> staffAge = new Vector<Integer>();

	public Latihan6() {
		do {
			System.out.print("Job Vacancy\n1. Insert new staff\n2. List of staff\n3. Search staff\n4. Exit\nChoose: ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1: {
				insertStaff();
				break;
			}
			case 2: {
				showStaff();
				break;
			}
			case 3: {
				searchStaff();
				break;
			}
			case 4: {
				System.out.println("Program has been closed !");
				break;
			}
			default:
				break;
			}
		} while (menu != 4);
	}

	public void insertStaff() {
		do {
			System.out.print("Enter staff's name [3..20] : ");
			name = sc.nextLine();
		} while (name.length() < 3 || name.length() > 20);

		do {
			System.out.print("Enter staff's position [ Manager | Analyst | Programmer ] : ");
			position = sc.nextLine();
		} while (!(position.equalsIgnoreCase("Manager") || position.equalsIgnoreCase("Analyst")
				|| position.equalsIgnoreCase("Programmer")));

		do {
			System.out.print("Enter staff's age [ Must be older than 17 ] : ");
			age = sc.nextInt();
			sc.nextLine();
		} while (age < 17);
		System.out.println();

		staffName.add(name);
		staffPosition.add(position);
		staffAge.add(age);
	}

	public void showStaff() {
		if (staffAge.size() == 0)
			System.out.println("No Data!\n");
		else {
			for (int i = 0; i < staffAge.size(); i++) {
				System.out.println("Staff ID    : " + (i + 1));
				System.out.println("================");
				System.out.println("1. Name     : " + staffName.get(i));
				System.out.println("2. Position : " + staffPosition.get(i));
				System.out.println("4. Age      : " + staffAge.get(i));
				System.out.println();
			}
		}
	}

	public void searchStaff() {
		if (staffAge.size() == 0)
			System.out.println("No Data! Please input a data first !\n");
		else {
			do {
				System.out.print("Enter staff's name [3..20] : ");
				query = sc.nextLine();
			} while (query.length() < 3 || query.length() > 20);
			System.out.println();

			for (int i = 0; i < staffAge.size(); i++) {
				if (staffName.get(i).equalsIgnoreCase(query)) {
					System.out.println("Staff ID    : " + (i + 1));
					System.out.println("================");
					System.out.println("1. Name     : " + staffName.get(i));
					System.out.println("2. Position : " + staffPosition.get(i));
					System.out.println("4. Age      : " + staffAge.get(i));
					break;
				} else {
					System.out.println("No staff found with name : " + query);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Latihan6();
	}
}