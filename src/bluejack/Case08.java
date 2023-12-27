package bluejack;

import java.util.Scanner;
import java.util.Vector;

public class Case08 {
	Scanner sc = new Scanner(System.in);

	String foodType, foodName, search;
	double calories;
	int foodPrice, menu, delete;

	Vector<Integer> foodID = new Vector<Integer>();
	Vector<String> foodTypes = new Vector<String>();
	Vector<String> foodNames = new Vector<String>();
	Vector<Double> foodCalories = new Vector<Double>();
	Vector<Integer> foodPrices = new Vector<Integer>();

	public Case08() {
		do {
			System.out.println("Food Order");
			System.out.println("=".repeat("Food Order".length()));
			System.out.println("1. Insert new food");
			System.out.println("2. List of food");
			System.out.println("3. Search food");
			System.out.println("4. Delete food");
			System.out.println("5. Exit");
			System.out.print("Choose : ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1: {
				insertFood();
				break;
			}
			case 2: {
				listFood();
				break;
			}
			case 3: {
				searchFood();
				break;
			}
			case 4: {
				deleteFood();
				break;
			}
			case 5: {
				System.out.println("Program has been closed !");
				break;
			}

			default:
				break;
			}
		} while (menu != 5);
	}

	private void insertFood() {
		do {
			System.out.print("Input Food Type [ Appetizer | Main Course | Dessert ] (Case Insensitive) : ");
			foodType = sc.nextLine();
		} while (!(foodType.equalsIgnoreCase("Appetizer") || foodType.equalsIgnoreCase("Main Course")
				|| foodType.equalsIgnoreCase("Dessert")));

		do {
			System.out.print("Input Food Name [3-20] : ");
			foodName = sc.nextLine();
		} while (foodName.length() < 3 || foodName.length() > 20);

		do {
			System.out.print("Input Food Calories [1.0..4.0] : ");
			calories = sc.nextDouble();
			sc.nextLine();
		} while (calories < 1.0 || calories > 4.0);

		do {
			System.out.print("Input Food Price [10000..50000] : ");
			foodPrice = sc.nextInt();
			sc.nextLine();
		} while (foodPrice < 10000 || foodPrice > 50000);
		System.out.println("Data has been successfully inserted!\n");

		foodID.add(foodID.size() + 1);
		foodTypes.add(foodType);
		foodNames.add(foodName);
		foodCalories.add(calories);
		foodPrices.add(foodPrice);
	}

	private void listFood() {
		if (foodID.isEmpty()) {
			System.out.println("No data !\n");
		} else {
			String createTable = String.format("| %-5s | %-15s | %-25s | %-9s | %-20s |", "No", "Type", "Name",
					"Calories", "Price");

			System.out.println("=".repeat(createTable.length()));
			System.out.println(createTable);
			System.out.println("=".repeat(createTable.length()));
			for (int i = 0; i < foodID.size(); i++) {
				String createList = String.format("| %-5d | %-15s | %-25s | %-9f | %-20d |", foodID.get(i),
						foodTypes.get(i), foodNames.get(i), foodCalories.get(i), foodPrices.get(i));
				System.out.println(createList);
			}
			System.out.println("=".repeat(createTable.length()));
			System.out.println();
		}
	}

	private void searchFood() {
		do {
			System.out.print("Input Food Name [3-20] : ");
			search = sc.nextLine();
		} while (search.length() < 3 || search.length() > 20);

		if (foodNames.contains(search)) {
			System.out.println();
			System.out.println("No       : " + foodID.get(foodNames.indexOf(foodName)));
			System.out.println("=========");
			System.out.println("Type     : " + foodTypes.get(foodNames.indexOf(foodName)));
			System.out.println("Name     : " + foodNames.get(foodNames.indexOf(foodName)));
			System.out.println("Calories : " + foodCalories.get(foodNames.indexOf(foodName)));
			System.out.println("Price    : " + foodPrices.get(foodNames.indexOf(foodName)));
			System.out.println();
		} else {
			System.out.println("No data found !\n");
		}
	}

	private void deleteFood() {
		listFood();
		if (foodID.isEmpty())
			return;

		do {
			System.out.print("Input number (No) to be deleted [1.." + foodID.size() + "] (Type 0 to cancel) : ");
			delete = sc.nextInt();
			sc.nextLine();
		} while (delete > foodID.size() || delete < 0);

		if (delete == 0)
			System.out.println("Operation has been canceled !\n");
		else {
			System.out.println("Data has been successfully deleted!\n");
			foodNames.remove(foodID.indexOf(delete));
			foodTypes.remove(foodID.indexOf(delete));
			foodCalories.remove(foodID.indexOf(delete));
			foodPrices.remove(foodID.indexOf(delete));
			foodID.remove(foodID.indexOf(delete));

			if (foodID.isEmpty())
				return;
//			for (int i = 0; i < foodID.size(); i++) {
//				int a = i;
//				foodID.set(i, ++a);
//			}
		}
	}

	public static void main(String[] args) {
		new Case08();
	}

}
