package lecture;

public class Sort {
	int data[] = { 10, 3, 8, 1, 4, 2, 5 };

	public Sort() {
		// ( < ) Descending
		// ( > ) Ascending
		bubbleSort();

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + " ");
		}
	}

	public void bubbleSort() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[j] < data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
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
