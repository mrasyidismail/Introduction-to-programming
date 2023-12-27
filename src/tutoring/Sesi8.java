package tutoring;

import java.util.Vector;

public class Sesi8 {
	int num[] = { 100, 200, 300, 400 }, total;

	Vector<Integer> nums = new Vector<Integer>();

	public Sesi8() {
		nums.add(100);
		nums.add(200);
		nums.add(300);
		nums.add(400);
		for (int i = 0; i < nums.size(); i++) {
			total += nums.get(i);
		}

		System.out.println("Total   : " + total);
		System.out.println("Average : " + (total / nums.size()));

	}

	public static void main(String[] args) {
		new Sesi8();
	}

}
