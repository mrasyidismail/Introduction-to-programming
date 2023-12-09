/*
 * @author github.com/mrasyidismail
 */
package lecture;

import java.util.Scanner;

public class Method {
	Scanner sc = new Scanner(System.in);
	double number, numbers, total, multi = 1;

	public Method() {
		System.out.print("How many numbers will be input : ");
		number = sc.nextDouble();
		sc.nextLine();
		totalNumber();
		System.out.println("Total Summation  : " + total);
		System.out.println("Total Multi      : " + multi);
		System.out.println("Total Average    : " + avg(total, number));
	}

	public void totalNumber() {
		for (int i = 0; i < number; i++) {
			System.out.print("Enter number " + (i + 1) + " : ");
			numbers = sc.nextDouble();
			sc.nextLine();
			sum(numbers);
			multi(numbers);
		}
	}

	public void sum(double a) {
		total += a;
	}

	public void multi(double a) {
		multi *= a;
	}

	public double avg(double a, double b) {
		return a / b;
	}

	public static void main(String[] args) {
		new Method();
	}

}
