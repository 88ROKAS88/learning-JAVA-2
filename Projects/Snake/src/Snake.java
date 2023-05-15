import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JFrame {
	
	static JPanel grid[] = new JPanel[101];
	
	Snake() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Snake");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10,1,1)); // layout manager (rows,columns,horizontal margin,vertical margin)
		panel.setPreferredSize(new Dimension(260, 260));
		panel.setBackground(Color.white);

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
}
