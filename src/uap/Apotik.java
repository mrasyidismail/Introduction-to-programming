package uap;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Apotik {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	String customerName, phoneNumber, orderAddress, medicine, transactionId, confirmation;
	int quantity, totalPrice, menu, index, medicinePrice, money, change;

	Vector<String> transactionIds = new Vector<String>();
	Vector<String> customerNames = new Vector<String>();
	Vector<String> phoneNumbers = new Vector<String>();
	Vector<String> medicines = new Vector<String>();
	Vector<String> orderAddresses = new Vector<String>();
	Vector<Integer> quantities = new Vector<Integer>();
	Vector<Integer> totalPrices = new Vector<Integer>();

	public Apotik() {
		do {
			System.out.println("Apotik Transaction Recorder");
			System.out.println("===========================");
			System.out.println("1. Order Medicine");
			System.out.println("2. View Order History");
			System.out.println("3. Update Order History");
			System.out.println("4. Delete Order History");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: {
				orderMedicine();
				break;
			}
			case 2: {
				viewHistory();
				break;
			}
			case 3: {
				updateHistory();
				break;
			}
			case 4: {
				deleteHistory();
				break;
			}
			case 5: {
				System.out.println("Thank You :)");
				break;
			}

			default: {
				break;
			}
			}
		} while (menu != 5);
	}

	private void orderMedicine() {
		do {
			System.out.print("Input Customer Name [ Must be alphanumeric and more than 5 characters ] : ");
			customerName = sc.nextLine();
		} while (!(isAlphanumberic(customerName) && !(customerName.length() <= 5)));

		do {
			System.out.print("Input Phone Number [ Must be numberic and starts with 0 ] : ");
			phoneNumber = sc.nextLine();
		} while (!(isNumberic(phoneNumber) && phoneNumber.startsWith("0")));

		do {
			System.out.print("Input Order Address [ Must contain 'Street', 'RT', or 'RW' ] (Case Sensitive) :  ");
			orderAddress = sc.nextLine();
		} while (!(orderAddress.contains("Street") || orderAddress.contains("RT") || orderAddress.contains("RW")));

		do {
			System.out.print("Input Medicione [ Panadole | Vitaciman | Combin ] (Case Sensitive) : ");
			medicine = sc.nextLine();
		} while (!(medicine.equals("Panadole") || medicine.equals("Vitaciman") || medicine.equals("Combin")));

		do {
			System.out.print("Input Quantity [ Must be more than 0 ] : ");
			quantity = sc.nextInt();
			sc.nextLine();
		} while (quantity <= 0);

		do {
			System.out.print("Are u sure want to order this medicine [ Y | N ] (Case Sensitive) : ");
			confirmation = sc.nextLine();
		} while (!(confirmation.equals("Y") || confirmation.equals("N")));

		if (confirmation.equals("N")) {
			System.out.println("Order Cancelled !");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
			return;
		}

		transactionId = generateID(customerName);

		if (medicine.equals("Panadole"))
			medicinePrice = 10000;
		else if (medicine.equals("Viraciman"))
			medicinePrice = 15000;
		else
			medicinePrice = 20000;

		totalPrice = medicinePrice * quantity;

		do {
			System.out.print("Input Money [ >= " + totalPrice + " ] : ");
			money = sc.nextInt();
			sc.nextLine();
		} while (money < totalPrice);

		change = money - totalPrice;
		System.out.println("Change : " + change);

		transactionIds.add(transactionId);
		customerNames.add(customerName);
		phoneNumbers.add(phoneNumber);
		medicines.add(medicine);
		orderAddresses.add(orderAddress);
		quantities.add(quantity);
		totalPrices.add(totalPrice);

		System.out.println("Order added !");
		System.out.println("Press Enter to Continue...");
		sc.nextLine();
	}

	private void viewHistory() {
		if (transactionIds.isEmpty()) {
			System.out.println("There is no order medicine history!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyId();
			displayTable();
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void updateHistory() {
		if (transactionIds.isEmpty()) {
			System.out.println("There is no order medicine history!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyId();
			displayTable();

			do {
				System.out.print("Input Order History Number [ 1 - " + transactionIds.size() + " ] : ");
				index = sc.nextInt();
				sc.nextLine();
			} while (index < 1 || index > transactionIds.size());

			index = index - 1;

			do {
				System.out.print("Input Order Address [ Must contain 'Street', 'RT', or 'RW' ] (Case Sensitive) :  ");
				orderAddress = sc.nextLine();
			} while (!(orderAddress.contains("Street") || orderAddress.contains("RT") || orderAddress.contains("RW")));

			orderAddresses.set(index, orderAddress);

			System.out.println("Successfully Updated Order History!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private void deleteHistory() {
		if (transactionIds.isEmpty()) {
			System.out.println("There is no order medicine history!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		} else {
			sortbyId();
			displayTable();

			do {
				System.out.print("Input Order History Number [ 1 - " + transactionIds.size() + " ] : ");
				index = sc.nextInt();
				sc.nextLine();
			} while (index < 1 || index > transactionIds.size());

			index = index - 1;

			transactionIds.remove(index);
			customerNames.remove(index);
			phoneNumbers.remove(index);
			medicines.remove(index);
			orderAddresses.remove(index);
			quantities.remove(index);
			totalPrices.remove(index);

			System.out.println("Successfully Deleted Order History!");
			System.out.println("Press Enter to Continue...");
			sc.nextLine();
		}
	}

	private boolean isAlphanumberic(String var) {
		boolean isChar = false, isNum = false;

		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
				isChar = true;
			else if (c >= '0' && c <= '9')
				isNum = true;
			else
				return false;
		}
		return isChar && isNum;
	}

	private boolean isNumberic(String var) {
		boolean isNum = false;
		for (int i = 0; i < var.length(); i++) {
			char c = var.charAt(i);

			if (c >= '0' && c <= '9')
				isNum = true;
			else
				return false;
		}
		return isNum;
	}

	private String generateID(String var) {
		return String
				.format("PI%s%03d",
						(String.valueOf(var.charAt(rand.nextInt(var.length())))
								+ String.valueOf(var.charAt(rand.nextInt(var.length())))),
						(rand.nextInt(999) + 1))
				.toUpperCase();
	}

	private void sortbyId() {
		for (int i = 0; i < transactionIds.size(); i++) {
			for (int j = 0; j < transactionIds.size() - i - 1; j++) {
				if (transactionIds.get(j).compareTo(transactionIds.get(j + 1)) > 0) {
					String temp = transactionIds.get(j);
					transactionIds.set(j, transactionIds.get(j + 1));
					transactionIds.set(j + 1, temp);

					temp = customerNames.get(j);
					customerNames.set(j, customerNames.get(j + 1));
					customerNames.set(j + 1, temp);

					temp = phoneNumbers.get(j);
					phoneNumbers.set(j, phoneNumbers.get(j + 1));
					phoneNumbers.set(j + 1, temp);

					temp = medicines.get(j);
					medicines.set(j, medicines.get(j + 1));
					medicines.set(j + 1, temp);

					temp = orderAddresses.get(j);
					orderAddresses.set(j, orderAddresses.get(j + 1));
					orderAddresses.set(j + 1, temp);

					int temp1 = quantities.get(j);
					quantities.set(j, quantities.get(j + 1));
					quantities.set(j + 1, temp1);

					temp1 = totalPrices.get(j);
					totalPrices.set(j, totalPrices.get(j + 1));
					totalPrices.set(j + 1, temp1);
				}
			}
		}
	}

	private void displayTable() {
		String createTable = String.format("| %-4s | %-18s | %-25s | %-25s | %-12s | %-25s | %-9s | %-13s |", "No",
				"Transaction ID", "Customer Name", "Phone Number", "Medicine", "Order Address", "Quantity",
				"Total Price");
		System.out.println("=".repeat(createTable.length()));
		System.out.println(createTable);
		System.out.println("=".repeat(createTable.length()));
		for (int i = 0; i < transactionIds.size(); i++) {
			createTable = String.format("| %-4s | %-18s | %-25s | %-25s | %-12s | %-25s | %-9d | %-13d |", (i + 1),
					transactionIds.get(i), customerNames.get(i), phoneNumbers.get(i), medicines.get(i),
					orderAddresses.get(i), quantities.get(i), totalPrices.get(i));
			System.out.println(createTable);
		}
		System.out.println("=".repeat(createTable.length()));
	}

	public static void main(String[] args) {
		new Apotik();
	}

}
