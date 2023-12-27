package tutoring;

public class Sesi5 {
	int numbers[] = { 9, 1, 4, 5, 11, 8, 87, 25 };

	public Sesi5() {
		System.out.println("Before Sort : ");
		printMap(numbers);
		sortNumber(numbers);
		System.out.println("\nAfter Sort  : ");
		printMap(numbers);
	}

	public void printMap(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public void sortNumber(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int sorted = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = sorted;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Sesi5();
	}

}
