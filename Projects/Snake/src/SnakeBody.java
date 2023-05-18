import java.awt.Color;

public class SnakeBody {

	static int location[] = new int[100];
	static int direction = 0;
	static int currentLength = 1;

	static void drawSnakeBody(int movement) {
		// calculate tail
		for (int i = SnakeBody.currentLength; i > 0; i--) {
			SnakeBody.location[i ] = SnakeBody.location[i-1];
		}
		// fruit
		if (SnakeBody.location[0]+movement == Snake.fruit) {
			Snake.fruit = Snake.createFruit();
			SnakeBody.currentLength += 1;
		} else {			
			// remove old location
			Snake.grid[SnakeBody.location[SnakeBody.currentLength ]].setBackground(Color.black);
		}

		// calculate new location
		SnakeBody.location[0] += movement;
		// add new location
		Snake.grid[SnakeBody.location[0]].setBackground(Color.red);

	}

}
