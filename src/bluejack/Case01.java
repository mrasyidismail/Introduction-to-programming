/**
 * @author github.com/mrasyidismail
 */
package bluejack;

import java.util.Scanner;

public class Case01 {

	public Case01() {
		Scanner scan = new Scanner(System.in);
		String name, company;
		int age;
		double income;
		Boolean confirmation;

		System.out.println("Welcome to ES Companies Portal");
		System.out.println("================================");
		System.out.print("Input your name                   : ");
		name = scan.nextLine();
		System.out.print("Input your company's name         : ");
		company = scan.nextLine();
		System.out.print("Input your company's age          : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("Input your company's daily income : ");
		income = scan.nextDouble();
		scan.nextLine();
		System.out.println("\nThank you for filling the form " + name);

		System.out.println("Information about your company");
		System.out.println("===============================");
		System.out.println("Company Name     : " + company);
		System.out.println("Company Age      : " + age);
		System.out.println("Company Income   : " + income);
		System.out.print("\nIs this information correct ? [ true | false ] : ");
		confirmation = scan.nextBoolean();
		scan.nextLine();

		if (confirmation) {
			System.out.println("Thank you for using this application :)");
		} else {
			System.out.println("Please enter the correct data");
		}
		scan.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Case01();
	}

}
