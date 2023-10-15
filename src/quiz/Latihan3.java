/**
 * @author github.com/mrasyidismail
 */
package quiz;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Latihan3 {

	public Latihan3() {
		Scanner sc = new Scanner(System.in);

		String[] ideas;
		String fullName, teamName, email, department, gitHub, idea, confirmation;
		int menu, age, educationPoint;
		String registrationPrice;
		double totalDiscount, money, change;

		do {
			System.out.println("\nSunib Hackaton");
			System.out.println("================");
			System.out.print("1. Register Sunib Hackaton\n2. Exit\n>> ");
			menu = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (menu) {
			case 1: {
				do {
					System.out.print(
							"Input Full Name [ Must be more than 5 characters and start with capital letter ] : ");
					fullName = sc.nextLine();
				} while (!(fullName.length() > 5 && Character.isUpperCase(fullName.charAt(0))));

				do {
					System.out.print("Input Email [ Must ends with @gmail.com or @yahoo.com ] : ");
					email = sc.nextLine();
				} while (!(email.endsWith("@gmail.com") || email.endsWith("@yahoo.com")));

				do {
					System.out.print("Input Age [ Must be more than 17 ] : ");
					age = sc.nextInt();
					sc.nextLine();
				} while (!(age > 17));

				do {
					System.out.print("Input Department [ D3 | D4 | S1 ] ( Case Insensitive ) : ");
					department = sc.nextLine();
				} while (!(department.equalsIgnoreCase("D3") || department.equalsIgnoreCase("D4")
						|| department.equalsIgnoreCase("S1")));

				do {
					System.out.print("Input Team Name [ Must be between 4 - 20 Characters ] : ");
					teamName = sc.nextLine();
				} while ((teamName.length() < 4 || teamName.length() > 20));

				do {
					System.out.print("Input GitHub Link [ Must starts with github.com/ ] : ");
					gitHub = sc.nextLine();
				} while (!(gitHub.startsWith("github.com/")));

				do {
					System.out.print("Input Idea [ Must be between 3 - 7 words ] : ");
					idea = sc.nextLine();
					ideas = idea.split(" ");
				} while ((ideas.length < 3 || ideas.length > 7));

				if (department.equalsIgnoreCase("D3")) {
					educationPoint = 30;
				} else if (department.equalsIgnoreCase("D4")) {
					educationPoint = 40;
				} else {
					educationPoint = 50;
				}
				do {
					System.out.print("Are you sure want to register [ Y | N ] ( Case Sensitive ) : ");
					confirmation = sc.nextLine();
				} while (!(confirmation.equals("Y") || confirmation.equals("N")));

				if (confirmation.equals("Y")) {
					totalDiscount = educationPoint + teamName.length();
					DecimalFormat dc = new DecimalFormat("0.00");
					registrationPrice = dc.format(150000 - (150000 * (totalDiscount / 100)));

					System.out.println("\n================================================");
					System.out.println("|            Registration Information          |");
					System.out.println("================================================");
					System.out.println("| Full Name          : " + fullName);
					System.out.println("| Email              : " + email);
					System.out.println("| Age                : " + age);
					System.out.println("| Education          : " + department);
					System.out.println("| Team Name          : " + teamName);
					System.out.println("| GitHub Link        : " + gitHub);
					System.out.println("| Idea               : " + idea);
					System.out.println("| Total Discount     : " + totalDiscount + "%");
					System.out.println("| Registration Price : " + registrationPrice);
					System.out.println("===============================================");

					do {
						System.out.print("Input Money [ >= Registration Price ] : ");
						money = sc.nextInt();
						sc.nextLine();
					} while (!(money >= Double.parseDouble(registrationPrice)));

					change = money - Double.parseDouble(registrationPrice);
					System.out.println("Change : " + change + "\nGood luck for you competition :)");
					break;
				} else {
					break;
				}
			}
			case 2: {
				System.out.println("Embrace the code, conquer the challenge, let algorithms define excellence");
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
		new Latihan3();
	}

}
