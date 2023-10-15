/**
 * @author github.com/mrasyidismail
 */
package kelastutor;

import java.util.Random;
import java.util.Scanner;

public class Sesi3 {

	public Sesi3() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		String customerName, ramenType, paymentMethod, Bill;
		int menu, quantity, price, totalPrice, paymentPoint, change, money;
		Bill = String.format("PB%d", (rand.nextInt(999) + 1));
		do {
			System.out.print("Restaurant Ramen\n1. Order Ramen\n2. Exit\n>> ");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu) {
			case 1: {
				System.out.print("Nama Customer : ");
				customerName = scan.nextLine();
				do {
					System.out.print("Jenis Ramen  [ Shoyu Ramen | Miso Ramen ] : ");
					ramenType = scan.nextLine();
				} while (!(ramenType.equals("Shoyu Ramen") || ramenType.equals("Miso Ramen")));

				if (ramenType.equals("Shoyu Ramen")) {
					price = 40000;
				} else if (ramenType.equals("Miso Ramen")) {
					price = 45000;
				} else {
					System.out.println("Please enter a valid ramen type !");
					scan.close();
					return;
				}

				System.out.print("Quantity : ");
				quantity = scan.nextInt();
				scan.nextLine();
				do {
					System.out.print("Enter a payment method [ Transfer | QRIS ] : ");
					paymentMethod = scan.nextLine();
				} while (!(paymentMethod.equals("Transfer") || paymentMethod.equals("QRIS")));

				if (paymentMethod.equals("Transfer")) {
					paymentPoint = 1;
				} else {
					paymentPoint = 2;
				}
				totalPrice = (price * quantity) - (paymentPoint * 1000);

				System.out.println("\nWelcome to Restoran Ramen !!");
				System.out.println("================================");
				System.out.println("Pembayaran ID    : " + Bill);
				System.out.println("Nama Customer    : " + customerName);
				System.out.println("Jenis Ramen      : " + ramenType);
				System.out.println("Harga Ramen      : " + price);
				System.out.println("Quantity         : " + quantity);
				System.out.println("Payment Method   : " + paymentMethod);
				System.out.println("Payment Point    : " + paymentPoint);
				System.out.println("Total Price      : " + totalPrice);
				System.out.println("================================");
				do {
					System.out.print("Masukkan Uang    : ");
					money = scan.nextInt();
					scan.nextLine();
				} while (money < totalPrice);

				change = money - totalPrice;
				System.out.println("Change           : " + change);
				System.out.println("Pembayaran Berhasil!!!");
				break;
			}
			case 2:
				System.out.println("Program Closed");
				break;
			default:
				break;
			}
		} while (menu != 2);
		scan.close();
	}

	public static void main(String[] args) {
		new Sesi3();
	}
}