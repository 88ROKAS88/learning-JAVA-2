
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
		System.out.println("Turn: " + Game.turn);
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

			// 1) FINISH THE GAME
			if (o > 1 && Game.oCount > 1 && x == 0) {
				System.out.println("Oponent is making a last move");
				return Oponent.findSquare("O", i);
				// 2) PREVENT HUMAN FROM WINNING
			} else if (x > 1 && Game.xCount > 1 && !Game.lastTurn) {
				if (notMarkedInRow("O", i)) {
					System.out.println("Oponent is preventing your win");
					return Oponent.findSquare("X", i);
				}
				// 3) GET MIDDLE SQUARE
			} else if (Game.board[4] != "X" && Game.board[4] != "O") {
				Oponent.mark(4);
				return true;
				// 4) MAKE FIRST MOVE
			} else if (Game.oCount == 0) {
				System.out.println("Oponent is making a first move");
				return Oponent.findSquare("X", i);
				// 5) MAKE MOVE
			} else if (x == 0 && !Game.lastTurn && !Game.preventWin) {
				System.out.println("Oponent is making a move");
				if (notMarkedInRow("X", i)) {
					return Oponent.findSquare("O", i);
				}
			} else {
//				System.out.println(i + " Loop -> skip to next");
			}
		}
		System.out.println("Oponent is making any move");
		// make any move
		for(int i=0 ; i<8;i++) {
			if(Oponent.check(i)) {
				return true;
			}
		}
		
		System.out.println("oponent error -> cant find move");
		return false;
	}
}
