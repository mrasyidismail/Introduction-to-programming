/**
 * @author github.com/mrasyidismail
 */
package kelastutor;

import java.util.Scanner;

public class Sesi1 {

	public Sesi1() {
		String cake;
		int price, qty;
		float weight;

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Cherry Cake");
		System.out.println("========================");
		System.out.print("Input Cake Name          : ");
		cake = scan.nextLine();
		System.out.print("Input Cake Price         : ");
		price = scan.nextInt();
		scan.nextLine();
		System.out.print("Input Cake Weight (gram) : ");
		weight = scan.nextFloat();
		scan.nextLine();
		System.out.print("Input Quantity           : ");
		qty = scan.nextInt();
		scan.nextLine();

		System.out.println("\nCake Information");
		System.out.println("========================");
		System.out.println("Cake Name       : " + cake);
		System.out.println("Cake Price      : Rp." + price);
		System.out.println("Cake Weight     : " + weight + "g");
		System.out.println("Quantity        : " + qty + "x");

		System.out.print("\nDo you want to save the data? (yes/no): ");
		String data = scan.nextLine();

		boolean confirm = data.equalsIgnoreCase("yes");
		if (confirm) {
			System.out.println("Data saved !");
		} else {
			System.out.println("Data not saved !");
		}
		scan.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sesi1();
	}

}
