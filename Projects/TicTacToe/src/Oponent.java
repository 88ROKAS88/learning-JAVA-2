
public class Oponent {

	// adds markers on board and on button
	static void mark(int index) {
		Keypad.buttons[index].setText("O");
		Game.board[index] = "O";
	}

	// check if possible to mark
	static boolean check(int index) {
		if (Game.board[index] == "O" || Game.board[index] == "X") {
			System.out.println("CHECK ERR");
			return false;
		}
		Oponent.mark(index);
		return true;
	}

	// check if row have marks
	static boolean notMarkedInRow(String mark, int row) {
		if (Game.board[Game.winConditions[row][0]] != mark && Game.board[Game.winConditions[row][1]] != mark
				&& Game.board[Game.winConditions[row][2]] != mark) {
			return true;
		} else {
			return false;
		}
	}

	// find not marked square in a row
	static boolean findSquare(String mark, int row) {

		if (Game.board[Game.winConditions[row][0]] != mark) {
			return Oponent.check(Game.winConditions[row][0]);

		} else if (Game.board[Game.winConditions[row][2]] != mark) {
			return Oponent.check(Game.winConditions[row][2]);

		} else {
			return Oponent.check(Game.winConditions[row][1]);

		}
	}

	static boolean takeTurn() {
		Game.countmoves();
		System.out.println("Turn: "+Game.turn);
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

			if (o > 1 && Game.oCount > 1 && x == 0) {
				System.out.println("Oponent is making a last move");
				if (Game.board[Game.winConditions[i][0]] != "O") {

					return Oponent.check(Game.winConditions[i][0]);

				} else if (Game.board[Game.winConditions[i][1]] != "O") {
					return Oponent.check(Game.winConditions[i][1]);

				} else {
					return Oponent.check(Game.winConditions[i][2]);

				}
			} else if (x > 1 && Game.xCount > 1 && Game.lastTurn == false) {
				if (notMarkedInRow("O", i)) {
					System.out.println("Oponent is preventing your win");
					return Oponent.findSquare("X", i);
				}
			} else if (Game.board[4] != "X" && Game.board[4] != "O") {
				Oponent.mark(4);
				return true;
			} else if (Game.oCount == 1 && Game.xCount < 2) {
				if (notMarkedInRow("X", i)) {
					System.out.println("Oponent is making a second move");
					return Oponent.findSquare("O", i);					
				}
			} else if (Game.oCount == 0) {
				System.out.println("Oponent is making a first move");
				return Oponent.check(0);
			} else {
//				System.out.println(i + " Loop -> skip to next");
			}
		}

		return false;
	}
}
