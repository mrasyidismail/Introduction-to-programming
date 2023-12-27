package lecture;

import java.util.Scanner;
import java.util.Vector;

public class Screenshots {
	Scanner sc = new Scanner(System.in);

	String name, nim, phoneNumber, input;
	int menu, index;

	Vector<Student> students = new Vector<Screenshots.Student>();

	class Student {
		String name, phoneNumber, nim;

		public Student(String name, String phone, String nim) {
			this.name = name;
			this.nim = nim;
			this.phoneNumber = phone;
		}
	}

	public Screenshots() {
		do {
			System.out.println("Student Management System");
			System.out.println("=========================");
			System.out.println("1. Add Student");
			System.out.println("2. Delete Student");
			System.out.println("3. View Student");
			System.out.println("4. Exit");
			System.out.print("Input : ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				addStudent();
				break;
			}
			case 2: {
				deleteStudent();
				break;
			}
			case 3: {
				viewStudent();
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

	private void addStudent() {
		do {
			System.out.print("Input Nim (10 Digits) : ");
			nim = sc.nextLine();
		} while (nim.length() < 10 || nim.length() > 10);

		System.out.print("Input Name : ");
		name = sc.nextLine();

		System.out.print("Input Phone Number : ");
		phoneNumber = sc.nextLine();

		students.add(new Student(name, phoneNumber, nim));
	}

	private void deleteStudent() {
		if (students.isEmpty()) {
			System.out.println("No Student Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			displayTable();
			System.out.print("Input Nim to be deleted : ");
			input = sc.nextLine();

			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).nim.equals(input)) {
					System.out.println("Successfully deleted student data !");
					students.remove(i);
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					return;
				} else
					continue;
			}
			System.out.println(input + " you inputted is not found !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void viewStudent() {
		if (students.isEmpty()) {
			System.out.println("No Student Data !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			displayTable();
		}
	}

	private void displayTable() {
		String createTable = String.format("| %-15s | %-25s | %-20s |", "NIM", "Name", "Phone Number");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < students.size(); i++) {
			createTable = String.format("| %-15s | %-25s | %-20s |", students.get(i).nim, students.get(i).name,
					students.get(i).phoneNumber);
			System.out.println(createTable);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	public static void main(String[] args) {
		new Screenshots();
	}

}
