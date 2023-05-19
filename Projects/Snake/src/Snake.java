import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JFrame implements KeyListener {

	static JPanel grid[] = new JPanel[101];

	static int fruit;

	// Timer Task
	static Timer timer = new Timer();

	static TimerTask task = new MyTask();

	Snake() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Snake");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10, 1, 1)); // layout manager (rows,columns,horizontal margin,vertical
														// margin)
		panel.setPreferredSize(new Dimension(260, 260));
		panel.setBackground(Color.white);
		this.addKeyListener(this);

		for (int i = 1; i < 101; i++) {
			grid[i] = new JPanel();
			grid[i].setBackground(Color.black);
			panel.add(grid[i]);
		}
		SnakeBody.location[0] = 45;
		grid[SnakeBody.location[0]].setBackground(Color.red);
		this.add(panel);

		this.pack();
		this.setResizable(false);
		this.setVisible(true);

		// create fruit
		fruit = createFruit();

		timer.scheduleAtFixedRate(task, 0, 1000); // (task , time or delay of first instance, how often repeat)
	}

	static int createFruit() {
		Random rand = new Random();
		// Obtain a number between [1 - 100].
		int newFruit = rand.nextInt(100) + 1;
		// Draw fruit
		grid[newFruit].setBackground(Color.green);
		return newFruit;
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
