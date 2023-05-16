import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JFrame implements KeyListener {
	
	static JPanel grid[] = new JPanel[101];
	
	Snake() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Snake");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10,1,1)); // layout manager (rows,columns,horizontal margin,vertical margin)
		panel.setPreferredSize(new Dimension(260, 260));
		panel.setBackground(Color.white);
		this.addKeyListener(this);

		for (int i = 1; i < 101; i++) {
			grid[i] = new JPanel();
			grid[i].setBackground(Color.black);
			panel.add(grid[i]);
		}
		this.add(panel);

		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("You released key char: " + e.getKeyChar());
//		System.out.println("You released key code: " + e.getKeyCode());		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("You released key code: " + e.getKeyCode());		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
