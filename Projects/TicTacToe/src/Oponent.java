
public class Oponent {

	static void display(int index) {
		Keypad.buttons[index].setText("O");
		Game.board[index] = "O";
	}

	static boolean check(int index) {
		if (Game.board[index] == "O" || Game.board[index] == "X") {
			System.out.println("CHECK ERR");
			return false;
		}
		return true;
	}

	static boolean takeTurn() {

		System.out.println("Oponent is making a move");
		for (int i = 0; i < 8; i++) {
			int x = 0;
			int o = 0;
			for (int j = 0; j < 3; j++) {

				if (Game.board[Game.winConditions[i][j]] == "X") {
					x++;
				}
				if (Game.board[Game.winConditions[i][j]] == "O") {
					o++;
				}
			}
//			System.out.println(i + ") X:" + x + " O:" + o);
//			if (x > 2) {
//				System.out.println("YOU WIN");
//			}
//			if (o > 2) {
//				System.out.println("YOU LOST");
//			}
			if (o > 1 && Game.oCount > 1) {
				System.out.println("Oponent is making a last move");
				return true;
			} else if (x > 1 && Game.xCount > 1) {
				System.out.println("Oponent is preventing your win");
				if (Game.board[Game.winConditions[i][0]] != "O" && Game.board[Game.winConditions[i][1]] != "O"
						&& Game.board[Game.winConditions[i][2]] != "O") {
					System.out.println("O");
					if (Game.board[Game.winConditions[i][0]] != "X") {
						int number1 = Game.winConditions[i][0];
						if (Oponent.check(number1)) {
							Oponent.display(number1);
							return true;
						}
					}else if (Game.board[Game.winConditions[i][1]] != "X") {
						int number1 = Game.winConditions[i][1];
						if (Oponent.check(number1)) {
							Oponent.display(number1);
							return true;
						}
					}else {
						int number1 = Game.winConditions[i][2];
						if (Oponent.check(number1)) {
							Oponent.display(number1);
							return true;
						}
					}
				}
//				return true;
			} else if (Game.board[4] != "X" && Game.board[4] != "O") {
				Oponent.display(4);
				return true;
			} else if (Game.oCount == 1 && Game.xCount < 2) {
				System.out.println("Oponent is making a second move");
				if (Game.board[Game.winConditions[i][0]] != "X" && Game.board[Game.winConditions[i][1]] != "X"
						&& Game.board[Game.winConditions[i][2]] != "X") {
					if (Game.board[Game.winConditions[i][0]] != "O") {
						int number1 = Game.winConditions[i][0];
						System.out.println(number1);
						if (Oponent.check(number1)) {
							Oponent.display(number1);
							return true;
						}
					} else {
						int number1 = Game.winConditions[i][2];
						if (Oponent.check(number1)) {
							Oponent.display(number1);
							return true;
						}
					}
				}
//				return false;
			} else if (Game.oCount == 0) {
				System.out.println("Oponent is making a first move");
				if (Oponent.check(0)) {
					Oponent.display(0);
					return true;
				}
			} else {
				System.out.println(i+" Loop -> ERR ERR ERR err err");
//				return false;
			}
		}
		return false;
	}
}
