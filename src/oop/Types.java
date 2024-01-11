package oop;

public interface Types {
	class User {
		public String username, password;
	}

	class UserData extends User {
		public int money, lives;

		public UserData(String username, String password, int money, int lives) {
			this.username = username;
			this.password = password;
			this.money = money;
			this.lives = lives;
		}
	}

}
