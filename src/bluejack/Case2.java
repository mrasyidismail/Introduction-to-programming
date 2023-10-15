/**
 * @author github.com/mrasyidismail
 */
package bluejack;

import java.util.Random;
import java.util.Scanner;

public class Case2 {

	public Case2() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String companyName;
		int luckyNumber, userluckyNumber;

		System.out.println("ES Companies Portal - Simple Application");
		System.out.println("========================================");
		System.out.print("Input your company's name                  : ");
		companyName = scan.nextLine();
		System.out.print("Input your company's lucky number [0..255] : ");
		luckyNumber = scan.nextInt();
		scan.nextLine();

		System.out.println("\nInformation");
		System.out.println("===============");
		System.out.println("Company Name   : " + companyName);
		System.out.println("\nRandoming some numbers...");
		luckyNumber = rand.nextInt(companyName.length()) + 1;
		System.out.println("Press Enter to Continue...");
		scan.nextLine();

		System.out.println("\nFirst character in your company name : " + companyName.charAt(0));
		System.out.println("The character in index number 1 in your company name : " + companyName.charAt(1));
		System.out.println("Last character in the your company name : " + companyName.charAt(companyName.length() - 1));
		System.out.println("\nThis is the symbol of your company's lucky number : " + (char) luckyNumber);

		System.out.print("\nInput your another lucky number [1..50] : ");
		userluckyNumber = scan.nextInt();
		scan.nextLine();

		System.out.println("\nWhich is bigger, your company lucky number (" + luckyNumber + ") or the second one ("
				+ userluckyNumber + ")");
		System.out.println("Answer : " + Math.max(luckyNumber, userluckyNumber));

		System.out.println("\nWhich is smaller, your company lucky number (" + luckyNumber + ") or the second one ("
				+ userluckyNumber + ")");
		System.out.println("Answer : " + Math.min(luckyNumber, userluckyNumber));
		System.out.println("\n------------------------------------------------------");
		System.out.println("\nThank you for using this application :)");
		scan.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Case2();
	}

}
