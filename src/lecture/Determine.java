/**
 * @author github.com/mrasyidismail
 */
package lecture;

import java.util.Scanner;

public class Determine {
	Scanner sc = new Scanner(System.in);
	int var;

	public Determine() {
		System.out.print("Masukan sebuah angka (bulat) : ");
		var = sc.nextInt();
		sc.nextLine();

		if (var % 2 != 0) {
			System.out.println("Angka itu adalah bilangan ganjil, karena sisanya bukan sama dengan 0");
		} else {
			System.out.println("Angka itu adalah bilangan genap, karena sisanya sama dengan 0");
		}
	}

	public static void main(String[] args) {
		new Determine();
	}
}
