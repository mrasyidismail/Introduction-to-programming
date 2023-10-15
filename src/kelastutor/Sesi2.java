/**
 * @author github.com/mrasyidismail
 */
package kelastutor;

import java.util.Random;
import java.util.Scanner;

public class Sesi2 {

	public Sesi2() {
		Scanner scan = new Scanner(System.in);

		String flowerName, FlowerID;
		int qty, random;
		Random rand = new Random();
		random = rand.nextInt(999) + 1;
		// Range 1 - 999

		FlowerID = String.format("FL%d", random);
		// %d for Integer
		// %s for String

		System.out.println("Welcome to Flower Shop");
		System.out.println("======================");
		System.out.print("Input Flower Name     : ");
		flowerName = scan.nextLine();
		System.out.print("Input Quantity        : ");
		qty = scan.nextInt();
		scan.nextLine();

		System.out.println("\n======================");
		System.out.println("Welcome to Flower Shop!!");
		System.out.println("======================");
		System.out.println("FlowerID            : " + FlowerID);
		System.out.println("Flower Name         : " + flowerName);
		System.out.println("Flower Initial      : " + flowerName.substring(0, 2).toUpperCase());

		String[] Flower = flowerName.split(" ");

		if (Flower.length >= 2) {
			System.out.println("Flower First Name   : " + Flower[0]);
			System.out.println("Flower Last Name    : " + Flower[Flower.length - 1]);
		}
		System.out.println("Flower Quantity     : " + qty);

		System.out.println("\nNotes");
		System.out.println("=====================================");
		if (flowerName.length() <= 3) {
			System.out.println("Your Flower Name must be more than 3 characters");
		}
		if (qty < 1) {
			System.out.println("Your Quantity must be at least 1");
		}

		if (!(flowerName.length() <= 3 || qty < 1)) {
			System.out.println("-");
		}
		scan.close();
	}

	public static void main(String[] args) {
		new Sesi2();
	}

}
