package tutoring;

import java.util.Scanner;

public class Sesi4 {
	Scanner sc = new Scanner(System.in);
	final String[] database[] = { { "budi", "hello123" }, { "william", "helloworld" } };
	String inputName, password;
	Boolean isFound = false;

	public Sesi4() {
		while (!isFound) {
			System.out.print("Username : ");
			inputName = sc.nextLine();

			for (String[] userData : database) {
				String name = userData[0], pwd = userData[1];

				if (userData[0].equals(inputName)) {
					while (true) {
						System.out.print("Password : ");
						password = sc.nextLine();
						if (password.equals(pwd)) {
							System.out.print("Access is granted");
							isFound = true;
							break;
						} else {
							System.out.println("Pass is wrong");
						}
					}
					break;
				}
			}
			if (!isFound) {
				System.out.println("Username is not found !");
			} else {
				break;
			}
		}

	}

	public static void main(String[] args) {
		new Sesi4();
	}

}
