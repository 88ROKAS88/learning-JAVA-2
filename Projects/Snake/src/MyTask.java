import java.util.TimerTask;

public class MyTask extends TimerTask {

	@Override
	public void run() {
		
		int movement = 0;
		if (SnakeBody.direction == 37) {
			movement = -1;
			if (SnakeBody.location[0] % 10 == 1) {
				movement += 10;
			}
		}
		if (SnakeBody.direction == 39) {
			movement = 1;
			if (SnakeBody.location[0] % 10 == 0) {
				movement += -10;
			}
		}
		if (SnakeBody.direction == 38) {
			movement = -10;
			if (SnakeBody.location[0] <= 10) {
				movement += 100;
			}
		}
		if (SnakeBody.direction == 40) {
			movement = 10;
			if (SnakeBody.location[0] > 90) {
				movement += -100;
			}
		}
		SnakeBody.drawSnakeBody(movement);
		if(Collision.check()) {
			System.out.println("COLLISION");
			Snake.task.cancel();
		}
	}

}
