package tutoring;

import java.util.Scanner;

public class Sesi3 {
	Scanner sc = new Scanner(System.in);
	int input, number, total;

	public Sesi3() {
		System.out.print("How many numbers will be input: ");
		input = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < input; i++) {
			System.out.print("Number " + (i + 1) + ": ");
			number = sc.nextInt();
			sc.nextLine();

			total += number;
			System.out.println("Total in Number " + (i + 1) + ": " + total);
		}

		System.out.println("Total   : " + total);
		System.out.println("Average : " + (double) total / input);
	}

	public static void main(String[] args) {
		new Sesi3();
	}

}
