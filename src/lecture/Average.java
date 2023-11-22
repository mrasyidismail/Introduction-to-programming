package lecture;

import java.util.Scanner;

public class Average {
	Scanner sc = new Scanner(System.in);
	int number, numbers, total, i = 0;

	public Average() {
		System.out.print("How many numbers will be input : ");
		number = sc.nextInt();
		
		// Uncomment to run (Only one method at a time)
//		forLoop();
//		doWhile();
//		whileLoop();

		System.out.println("Total   : " + total);
		System.out.println("Average : " + (double) total / number);
	}

	public void forLoop() {
		for (int i = 0; i < number; i++) {
			System.out.print("Enter number " + (i + 1) + " : ");
			numbers = sc.nextInt();
			sc.nextLine();
			total += numbers;
		}
	}

	public void doWhile() {
		do {
			System.out.print("Enter number " + (i + 1) + ": ");
			numbers = sc.nextInt();
			sc.nextLine();
			total += numbers;
			i++;
		} while (i < number);
	}

	public void whileLoop() {
		while (i < number) {
			System.out.print("Enter number " + (i + 1) + ": ");
			numbers = sc.nextInt();
			sc.nextLine();
			total += numbers;
			i++;
		}
	}

	public static void main(String[] args) {
		new Average();
	}
}