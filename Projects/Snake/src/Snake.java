import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Snake extends JFrame implements KeyListener {

	// Timer Task
	static Timer timer = new Timer();
	static TimerTask task = new MyTask();

	Snake() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Snake");
		this.addKeyListener(this);

		// MENU
		// ################################################################
		JMenuBar menubar = new JMenuBar();
		JMenuItem filemenu = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");

		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == newGame) {
					Snake.newGame();
				}
			}
		});
		filemenu.setMnemonic(KeyEvent.VK_F); // set shortcut to Alt + F
		newGame.setMnemonic(KeyEvent.VK_N); // set shortcut to N
		filemenu.add(newGame);
		menubar.add(filemenu);
		this.setJMenuBar(menubar);

		// SNAKE MAP / WORLD
		// ################################################################
		SnakeMap snakeMap = new SnakeMap();
		this.add(snakeMap);

		this.pack();
		this.setResizable(false);
		this.setVisible(true);

		// create fruit
		SnakeMap.fruit = createFruit();

		timer.scheduleAtFixedRate(task, 0, 1000); // (task , time or delay of first instance, how often repeat)
	}

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
		timer = new Timer();
		task = new MyTask();
		timer.scheduleAtFixedRate(task, 0, 1000); // (task , time or delay of first instance, how often repeat)
	}

	static int createFruit() {
		Random rand = new Random();
		// Obtain a number between [1 - 100].
		int newFruit = rand.nextInt(100) + 1;
		// Draw fruit
		SnakeMap.grid[newFruit].setBackground(Color.green);
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
