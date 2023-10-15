/**
 * @author github.com/mrasyidismail
 */
package latihan;

import java.util.Random;
import java.util.Scanner;

public class Sesi3 {

	public Sesi3() {
		String customerName, foodName, paymentMethod, formula;
		int random, foodPrice, qty, totalPrice, paymentPoint, totalDiscount, money, change;

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		random = rand.nextInt(999) + 1;
		formula = "BI" + random;

		System.out.println("Bakmi eFeTe");
		System.out.println("===========");
		System.out.print("Input Customer Name [ e.g Mail ] : ");
		customerName = scan.nextLine();
		System.out.print("Input Food Name [ Bakmi Keriting | Bakmi Lebar | Kwetiau Ayam ] : ");
		foodName = scan.nextLine();
		System.out.print("Input Food Price [ e.g. 35000 ] : ");
		foodPrice = scan.nextInt();
		System.out.print("Quantity [ e.g. 5 ] : ");
		qty = scan.nextInt();
		scan.nextLine();
		System.out.print("Payment Method [ Cash | Transfer | QRIS ] : ");
		paymentMethod = scan.nextLine();

		if (paymentMethod.equals("Cash")) {
			paymentPoint = 0;
		} else if (paymentMethod.equals("Transfer")) {
			paymentPoint = 5;
		} else if (paymentMethod.equals("QRIS")) {
			paymentPoint = 10;
		} else {
			System.out.println("Please input a valid payment method !");
			scan.close();
			return;
		}

		totalDiscount = customerName.trim().length() + paymentPoint;
		totalPrice = (int) ((foodPrice * qty) - ((foodPrice * qty) * ((double) totalDiscount / 100)));

		System.out.println("\n======================================");
		System.out.println("|                 Bill               |");
		System.out.println("======================================");
		System.out.println("| Bill ID        : " + formula);
		System.out.println("| Customer Name  : " + customerName);
		System.out.println("| Food Name      : " + foodName);
		System.out.println("| Food Price     : " + foodPrice);
		System.out.println("| Quantity       : " + qty);
		System.out.println("| Total Discount : " + totalDiscount + "%");
		System.out.println("| Original Price : " + (foodPrice * qty));
		System.out.println("| Total Price    : " + totalPrice);
		System.out.println("| Payment Method : " + paymentMethod);
		System.out.println("======================================");

		System.out.print("Input Money [ >= Total Price ] : ");
		money = scan.nextInt();
		change = money - totalPrice;
		System.out.println("Change : " + change);
		System.out.println("\nThank you for your purchase !");
		scan.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sesi3();
	}

}
