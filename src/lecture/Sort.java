package lecture;

import java.util.Vector;

public class Sort {
	int data[] = { 10, 3, 8, 1, 4, 2, 5 };
	Vector<Integer> numbers = new Vector<Integer>();

	public Sort() {
		numbers.add(10);
		numbers.add(3);
		numbers.add(8);
		numbers.add(1);
		numbers.add(4);
		numbers.add(2);
		numbers.add(5);
		// ( < ) Descending
		// ( > ) Ascending
		bubbleSort();

		for (int i = 0; i < data.length; i++) {
//			System.out.println(data[i] + " "); // Array biasa
			System.out.println(numbers.get(i) + " ");
		}
	}

	public void bubbleSort() {
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data.length - i - 1; j++) {
//				if (data[j] < data[j + 1]) {
//					int temp = data[j];
//					data[j] = data[j + 1];
//					data[j + 1] = temp;
//				}
//			}
//		}
		
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.size() - i - 1; j++) {
				if (numbers.get(j).compareTo(numbers.get(j + 1)) < 0) {
					int temp = numbers.get(j);
					numbers.set(j, numbers.get(j + 1));
					numbers.set(j + 1, temp);
				}
			}
		}
	}

	public void selectionSort() {
		for (int i = 0; i < data.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[min])
					min = j;
			}

			if (min != i) {
				int temp = data[i];
				data[i] = data[min];
				data[min] = temp;
			}
		}
	}

	public static void main(String[] args) {
		new Sort();
	}

}
