package oop;

import java.util.Scanner;
import java.util.Vector;

import oop.Types.UserData;

public class Main {
	Scanner sc = new Scanner(System.in);

	Vector<UserData> users = new Vector<Types.UserData>();

	int menu;

	public Main() {
		do {
			System.out.println("Account Manager");
			System.out.println("===============");
			System.out.println("1. Create a new Account");
			System.out.println("2. Manage Accounts");
			System.out.println("3. Exit");
			System.out.print(">> ");

		} while (menu != 3);
	}

	public static void main(String[] args) {
		new Main();
	}

}
