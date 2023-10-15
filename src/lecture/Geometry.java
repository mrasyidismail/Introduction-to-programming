/**
 * 
 */
package lecture;

import java.util.Scanner;

/**
 * @author github.com/mrasyidismail
 */
public class Geometry {

	public Geometry() {
		Scanner input = new Scanner(System.in);
		int a;
		Boolean data = true;

		while (data) {
			System.out.println("\nGeometry Area Counter");
			System.out.println("=====================");
			System.out.println("1. Square");
			System.out.println("2. Rectangle");
			System.out.print("Option: ");
			a = input.nextInt();
			if (a == 1) {
				double b;
				System.out.print("Input Side : ");
				b = input.nextInt();
				System.out.println("Area : " + b * b);
				data = false;
			} else if (a == 2) {
				double b, c;
				System.out.print("Input Width  : ");
				b = input.nextDouble();
				System.out.print("Input height : ");
				c = input.nextDouble();

				System.out.println("Area : " + b * c);
				data = false;
			} else {
				System.out.println("Enter a valid input !");
			}
		}
		input.close();
	}

	public static void main(String[] args) {
		new Geometry();
	}
}
