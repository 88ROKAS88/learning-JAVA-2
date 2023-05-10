import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JFrame {
	Snake() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Snake");

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 300));
		this.add(panel);

		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}
