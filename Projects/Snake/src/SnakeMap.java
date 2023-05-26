import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class SnakeMap extends JPanel {
	

	static JPanel grid[] = new JPanel[101];

	static int fruit;

	SnakeMap() {
		this.setLayout(new GridLayout(10, 10, 1, 1)); // layout manager (rows,columns,horizontal margin,vertical
		// margin)
		this.setPreferredSize(new Dimension(260, 260));
		this.setBackground(Color.white);
		

		for (int i = 1; i < 101; i++) {
			grid[i] = new JPanel();
			grid[i].setBackground(Color.black);
			this.add(grid[i]);
		}
		SnakeBody.location[0] = 45;
		grid[SnakeBody.location[0]].setBackground(Color.red);
	}
}
