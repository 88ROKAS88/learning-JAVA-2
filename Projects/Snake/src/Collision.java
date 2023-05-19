
public class Collision {

	public static boolean check() {
		for (int i = 1; i < SnakeBody.currentLength; i++) {
			if (SnakeBody.location[0] == SnakeBody.location[i]) {
				return true;				
			}
		}
		return false;
	}
}
