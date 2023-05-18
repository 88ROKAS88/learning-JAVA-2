import java.awt.Color;

public class SnakeBody {

	static int location[] = new int[100];
	static int direction = 0;

	static void drawSnakeBody(int movement) {
		// remove old location
		Snake.grid[SnakeBody.location[0]].setBackground(Color.black);
		// calculate new location
		SnakeBody.location[0] += movement;
		// add new location
		Snake.grid[SnakeBody.location[0]].setBackground(Color.red);
		// fruit
		if (SnakeBody.location[0] == Snake.fruit) {
			Snake.fruit = Snake.createFruit();
		}
	}

}
