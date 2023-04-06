
public class Game {

	static String[] board = new String[9];

	static int[][] winConditions = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 4, 8 }, { 2, 4, 6 }, { 0, 3, 6 },
			{ 1, 4, 7 }, { 2, 5, 8 } };

	static int xCount = 0;
	static int oCount = 0;
	static int turn = 0;
	static boolean lastTurn = false;
	static boolean preventWin = false;
	static boolean over = false;

	static void countmoves() {
		Game.xCount = 0;
		Game.oCount = 0;
		Game.lastTurn = false;
		Game.preventWin = false;
		for (int i = 0; i < 8; i++) {
			int x = 0;
			int o = 0;
			for (int j = 0; j < 3; j++) {
				if (Game.board[winConditions[i][j]] == "X") {
					x++;
				}
				if (Game.board[winConditions[i][j]] == "O") {
					o++;
				}
			}
			if (Game.turn > 4 && !Game.over) {
				Game.over = true;
				System.out.println("DRAW");
			}
			if (x > 2) {
				Game.over = true;
				System.out.println("YOU WIN");
			}
			if (o > 2) {
				Game.over = true;
				System.out.println("YOU LOST");
			}
			if (x > Game.xCount) {
				Game.xCount = x;
			}
			if (o > Game.oCount) {
				Game.oCount = o;
			}
			if (x > 1 && o == 0) {
				Game.preventWin = true;
			}
			if (o > 1 && x == 0) {
				Game.lastTurn = true;
			}
		}
	}
}
