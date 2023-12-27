/**
 * @author github.com/mrasyidismail
 */
package lecture;

import java.util.Scanner;

public class Jump {
	Scanner sc = new Scanner(System.in);
	// Initilisasi variable constant database username dan password menggunakan 2
	// Dimensi Array
	final String[] database[] = { { "budi", "hello123" }, { "william", "helloworld" } };
	// Initialisasi varibale string untuk input username dan password
	String inputName, password;
	// Initialisasi variable boolean untuk kondisi while looping
	Boolean isFound = false;

	public Jump() {
		while (!isFound) { // Membuat while looping untuk input username
			System.out.print("Username : ");
			inputName = sc.nextLine(); // Input username
			for (String[] userData : database) { // For looping untuk iterasi database
				if (userData[0].equals(inputName)) { // Jika index 0 dari 2D array yaitu username,
														// sama dengan input username. Maka:
					while (true) { // Membuat while looping untuk iterasi database password
						System.out.print("Password : ");
						password = sc.nextLine(); // Input Password

						if (password.equals(userData[1])) { // Jika input password sama dengan index 1 dari 2D array
															// yaitu password. Maka:
							System.out.println("Access is granted");
							isFound = true; // Mengubah variable isFound menjadi false agar bisa keluar dari while
											// looping yang digunakan untuk input username
							break; // break statement untuk keluar dari while looping iterasi database password
						} else
							System.out.println("Password is wrong !");
					}
					break; // Keluar dari for looping iterasi database jika username tidak ada
				}
			}
			if (!isFound) { // Print "Username is not found !" jika input username tidak ada di database
				System.out.println("Username is not found !");
			} else
				break; // break statement untuk keluar dari while looping untuk input username
		}
	}

	public static void main(String[] args) {
		new Jump();
	}
}
