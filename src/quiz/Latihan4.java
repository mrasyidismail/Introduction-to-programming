/**
 * @author github.com/mrasyidismail
 */
package quiz;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Latihan4 {

	public Latihan4() {
		Scanner sc = new Scanner(System.in);

		String studentID, fullName, gender, department, email, paymentMethod, confirmation, registrationPrice;
		int menu, age, genderPoint, departmentPoint, paymentPoint;
		double totalDiscount, money, change;
		do {
			System.out.println("Sunib Coding Challenge");
			System.out.println("======================");
			System.out.print("1. Register Sunib Coding Challenge\n2. Exit\n>> ");
			menu = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (menu) {
			case 1: {
				do {
					System.out.print("Input Student ID [ Must starts with 26 or 27 ] : ");
					studentID = sc.nextLine();
				} while (!(studentID.startsWith("26") || studentID.startsWith("27")));

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
					System.out.print("Input Gender [ Female | Male ] ( Case Sensitive ) : ");
					gender = sc.nextLine();
				} while (!(gender.equals("Female") || gender.equals("Male")));

				do {
					System.out.print("Input Email [ Must ends with @gmail.com ] : ");
					email = sc.nextLine();
				} while (!(email.endsWith("@gmail.com")));

				do {
					System.out.print("Enter Department [ SOCS | SOIS| SOD ] ( Case Insensitive ) : ");
					department = sc.nextLine();
				} while (!(department.equalsIgnoreCase("SOCS") || department.equalsIgnoreCase("SOIS")
						|| department.equalsIgnoreCase("SOD")));

				do {
					System.out.print("Input Payment Method [ Cash | Transfer | QRIS ] ( Case Sensitive ) : ");
					paymentMethod = sc.nextLine();
				} while (!(paymentMethod.equals("Cash") || paymentMethod.equals("Transfer")
						|| paymentMethod.equals("QRIS")));

				if (gender.equals("Female")) {
					genderPoint = 10;
				} else {
					genderPoint = 20;
				}

				if (department.equalsIgnoreCase("SOCS")) {
					departmentPoint = 20;
				} else if (department.equalsIgnoreCase("SOIS")) {
					departmentPoint = 30;
				} else {
					departmentPoint = 25;
				}

				if (paymentMethod.equals("Cash")) {
					paymentPoint = 0;
				} else if (paymentMethod.equals("Transfer")) {
					paymentPoint = 5;
				} else {
					paymentPoint = 10;
				}

				totalDiscount = departmentPoint + paymentPoint + genderPoint;
				DecimalFormat dc = new DecimalFormat("0.00");
				registrationPrice = dc.format(100000 - (100000 * (totalDiscount / 100)));

				do {
					System.out.print("Are u sure you want to register [ Y | N ] ( Case Sensitive ) : ");
					confirmation = sc.nextLine();
				} while (!(confirmation.equals("Y") || confirmation.equals("N")));

				if (confirmation.equals("Y")) {
					System.out.println("\n================================================");
					System.out.println("|             Registration Information         |");
					System.out.println("================================================");
					System.out.println("| Student ID         : " + studentID);
					System.out.println("| Full Name          : " + fullName);
					System.out.println("| Age                : " + age);
					System.out.println("| Gender             : " + gender);
					System.out.println("| Email              : " + email);
					System.out.println("| Department         : " + department);
					System.out.println("| Total Discount     : " + totalDiscount + "%");
					System.out.println("| Registration Price : " + registrationPrice);
					System.out.println("| Payment Method     : " + paymentMethod);
					System.out.println("================================================");

					do {
						System.out.print("Input Money [ >= Registration Price ] : ");
						money = sc.nextDouble();
						sc.nextLine();
					} while (!(money >= Double.parseDouble(registrationPrice)));

					change = money - Double.parseDouble(registrationPrice);
					System.out.println("Change : " + change + "\n\nGood Luck For Your Competition :)\n");
					break;
				} else {
					break;
				}

			}
			case 2: {
				System.out.println("Embrace the code, compete with precision, and let algorithm define victory");
				break;
			}
			default: {
				break;
			}
			}
		} while (menu != 2);
		sc.close();
	}

	public static void main(String[] args) {
		new Latihan4();
	}

}
