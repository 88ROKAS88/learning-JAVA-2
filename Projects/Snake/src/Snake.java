import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class Snake extends JFrame implements KeyListener {

	// Timer Task
	static Timer timer = new Timer();
	static TimerTask task = new MyTask();

	Snake() {
		// FRAME / WINDOW
		// ################################################################
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Snake");
		this.addKeyListener(this);

		// MENU
		// ################################################################
		SnakeMenu snakeMenu = new SnakeMenu();
		this.setJMenuBar(snakeMenu);

		// SNAKE MAP / WORLD
		// ################################################################
		SnakeMap snakeMap = new SnakeMap();
		this.add(snakeMap);

		// FRAME / WINDOW
		// ################################################################
		this.pack();
		this.setResizable(false);
		this.setVisible(true);

		// create fruit
		SnakeMap.fruit = Game.createFruit();

		timer.scheduleAtFixedRate(task, 0, 1000); // (task , time or delay of first instance, how often repeat)
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("You released key char: " + e.getKeyChar());
//		System.out.println("You released key code: " + e.getKeyCode());		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37 || e.getKeyCode() == 39 || e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			SnakeBody.direction = e.getKeyCode();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
