package lecture;

import java.util.Scanner;

public class Grade {
	double assignmentPoint, midExamPoint, finalExamPoint, finalPoint;
	Scanner sc = new Scanner(System.in);

	public Grade() {
		do {
			System.out.print("Assignment Point [0..100] : ");
			assignmentPoint = sc.nextInt();
			sc.nextLine();
		} while (assignmentPoint < 0 || assignmentPoint > 100);

		do {
			System.out.print("Mid-Exam Point [0..100] : ");
			midExamPoint = sc.nextInt();
			sc.nextLine();
		} while (midExamPoint < 0 || midExamPoint > 100);

		do {
			System.out.print("Final-Exam Point [0..100] : ");
			finalExamPoint = sc.nextInt();
			sc.nextLine();
		} while (finalExamPoint < 0 || finalExamPoint > 100);
		
		assignmentPoint = assignmentPoint * (double) 20/100;
		midExamPoint = midExamPoint * (double) 30/100;
		finalExamPoint = finalExamPoint * (double) 50/100;
		
		finalPoint = assignmentPoint + midExamPoint + finalExamPoint;
		
		System.out.println("Your Score: " + (assignmentPoint + midExamPoint + finalExamPoint));
		if (finalPoint >= 85 && finalPoint <= 100) {
			System.out.println("Your Grade: A");
		}
		else if (finalPoint >= 75 && finalPoint <= 84) {
			System.out.println("Your Grade: B");
		}
		else if (finalPoint >= 65 && finalPoint <= 74) {
			System.out.println("Your Grade: C");
		}
		else if (finalPoint >= 55 && finalPoint <= 64) {
			System.out.println("Your Grade: D");
		}
		else {
			System.out.println("Your Grade: E");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Grade();
	}

}
