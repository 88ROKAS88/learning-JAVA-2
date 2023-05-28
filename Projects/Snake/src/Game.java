import java.awt.Color;
import java.util.Random;
import java.util.Timer;

public class Game {

	static void newGame() {
		System.out.println("New Game");
		// paint map in black
		for (int i = 1; i < 101; i++) {
			SnakeMap.grid[i].setBackground(Color.black);
		}
		// set and draw snake
		SnakeBody.location[0] = 45;
		SnakeMap.grid[SnakeBody.location[0]].setBackground(Color.red);
		// set moving direction and length
		SnakeBody.direction = 0;
		SnakeBody.currentLength = 1;
		// create new fruit
		SnakeMap.fruit = createFruit();
		// restart timer task
		Snake.task.cancel();
		Snake.timer = new Timer();
		Snake.task = new MyTask();
		Snake.timer.scheduleAtFixedRate(Snake.task, 0, 1000); // (task , time or delay of first instance, how often repeat)
	}

	static int createFruit() {
		Random rand = new Random();
		// Obtain a number between [1 - 100].
		int newFruit = rand.nextInt(100) + 1;
		// Draw fruit
		SnakeMap.grid[newFruit].setBackground(Color.green);
		return newFruit;
	}

}
