package tutoring;

import java.util.Scanner;

public class Sesi10 {
	Scanner sc = new Scanner(System.in);
	int i;

	public Sesi10() {
		// Lu mau jalanin kode, dan ada error
		while (true) {
			try {
				System.out.print("Input Angka : ");
				i = sc.nextInt(); // klo error (misalkan gua input huruf)
				break;
			} catch (Exception e) {
				System.out.println("Tolong Input Angka !");
			} finally {
				sc.nextLine();
			}
		}
	}

	public static void main(String[] args) {
		new Sesi10();
	}

}
