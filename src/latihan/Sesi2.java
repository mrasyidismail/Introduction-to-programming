/**
 * @author github.com/mrasyidismail
 */
package latihan;

import java.util.Random;
import java.util.Scanner;

public class Sesi2 {

	public Sesi2() {

		Scanner scan = new Scanner(System.in);

		String nim, name, dep, email, attendee;

		int random;
		Random rand = new Random();

		random = rand.nextInt(999) + 1;

		attendee = String.format("AI%d", random);

		System.out.println("Student Information".toUpperCase());
		System.out.println("========================================================");
		System.out.print("Input NIM [ e.g. 2702377480 ]                       : ");
		nim = scan.nextLine();
		System.out.print("Input Full Name [ e.g. Muhammad Rasyid Ismail ]     : ");
		name = scan.nextLine();
		System.out.print("Input Department [ SOCS | SOIS ] ( Case Sensitive ) : ");
		dep = scan.nextLine();
		System.out.print("Input Email [ ends with @sunib.ac.id ]              : ");
		email = scan.nextLine();

		System.out.println("========================================================");
		System.out.println("|                   Welcome Sunibian " + nim.substring(0, 2) + "                |");
		System.out.println("========================================================");
		System.out.println("| Attandee ID        : " + attendee + "                           |");
		System.out.println("| Student Full Name  : " + name + "          |");
		String[] FullName = name.split(" ");
		if (FullName.length >= 2) {
			System.out.println("| Student First Name : " + FullName[0] + "                        |");
			System.out
					.println("| Student Last Name  : " + FullName[FullName.length - 1] + "                          |");
		}
		System.out.println("| NIM                : " + nim + "                      |");
		if (dep.equals("SOIS")) {
			System.out.println("| Department         : School of Information Systems   |");
		} else if (dep.equals("SOCS")) {
			System.out.println("| Department         : School of Computer Sciences     |");
		}
		System.out.println("| Email              : " + email + "  |");
		System.out.println("========================================================");

		System.out.println("\n========================================================");
		System.out.println("|                         Notes" + "                        |");
		System.out.println("========================================================");
		if (nim.length() < 10) {
			System.out.println("| - Your NIM must consists of 10 Characters            |");
		}
		if (name.length() < 5) {
			System.out.println("| - Your Full Name must be more than 5 characters      |");
		}
		if (!email.endsWith("@sunib.ac.id")) {
			System.out.println("| - Your email does not ends with @sunib.ac.id         |");
		}
		if (!dep.equals("SOCS") && !dep.equals("SOIS")) {
			System.out.println("| - You are not from the SOCS or SOIS Department       |");
		}
		if (nim.length() == 10 && name.length() > 5 && email.endsWith("@sunib.ac.id") && dep.equals("SOCS")
				|| dep.equals("SOIS")) {
			System.out.println("|                           -                          |");
		}
		System.out.println("========================================================");
		scan.close();
	}

	public static void main(String[] args) {
		new Sesi2();
	}

}
