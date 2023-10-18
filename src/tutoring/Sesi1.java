package tutoring;

import java.util.Scanner;

public class Sesi1 {

	Scanner sc = new Scanner(System.in);
	String customerName;
	String[] splitName;
	public Sesi1() {
		int i = 2;
		do {
			System.out.print("Enter your name [more than 2 words] : ");
			customerName = sc.nextLine();
			splitName = customerName.split(" ");
		} while(!(splitName.length > 2));

		System.out.println(splitName[--i]);
		System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sesi1();
	}

}
