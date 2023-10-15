/**
 * @author github.com/mrasyidismail
 */
package latihan;

import java.util.Scanner;

public class Sesi1 {

	public static void main(String[] args) {

		// Declare Variables
		String id, name, date, gender, phone, email, address, city, province;
		boolean fact;

		int age;
		float height, weight;

		// Initiate Input
		Scanner scan = new Scanner(System.in);

		// Student Information
		System.out.println("Student Information");
		System.out.println("===================");
		System.out.print("Input Student ID [ e.g. 2720419523 ] : ");
		id = scan.nextLine();
		System.out.print("Input Student Name : ");
		name = scan.nextLine();
		System.out.print("Input Date of Birth [ e.g. 9/24/2004 ] : ");
		date = scan.nextLine();
		System.out.print("Input Age : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("Input Height [ e.g. 180, 175.5, etc ] : ");
		height = scan.nextFloat();
		scan.nextLine();
		System.out.print("Input Weight [ e.g. 50, 67.5, etc ] : ");
		weight = scan.nextFloat();
		scan.nextLine();
		System.out.print("Input Gender [ e.g. Male, Female ] : ");
		gender = scan.nextLine();
		System.out.print("Input Contact Number [ e.g. +628521920345 ] : ");
		phone = scan.nextLine();
		System.out.print("Input Email Address : ");
		email = scan.nextLine();

		// Address Detail
		System.out.println("==============");
		System.out.println("Address Detail");
		System.out.println("==============");
		System.out.print("Input Home Address : ");
		address = scan.nextLine();
		System.out.print("Input City : ");
		city = scan.nextLine();
		System.out.print("Input Province : ");
		province = scan.nextLine();

		// Confirm the validity
		System.out.println("=====================================");
		System.out.println("|         Student Information       |");
		System.out.println("=====================================");
		System.out.println("| Student ID     : " + id);
		System.out.println("| Student Name   : " + name);
		System.out.println("| Date of Birth  : " + date);
		System.out.println("| Age            : " + age);
		System.out.println("| Height         : " + height);
		System.out.println("| Weight         : " + weight);
		System.out.println("| Gender         : " + gender);
		System.out.println("| Contact Number : " + phone);
		System.out.println("| Email Address  : " + email);
		System.out.println("| Address Detail : " + address + ", " + city + ", " + province);
		System.out.println("=====================================");
		System.out.print("\nIs this information correct ? [ true / false ] : ");
		fact = scan.nextBoolean();
		scan.nextLine();
		scan.close();

		if (fact) {
			System.out.println("Thank you for using this application !");
		} else {
			System.out.println("Data not submitted.");
		}

	}

}
