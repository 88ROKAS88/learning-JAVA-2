import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Keypad extends JPanel implements ActionListener {

	static JButton buttons[] = new JButton[10];

	Keypad() {

		this.setLayout(new GridLayout(3, 3)); // layout manager (rows,columns,horizontal margin,vertical margin)

		this.setPreferredSize(new Dimension(300, 300));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton("");
			buttons[i].setFont(new Font("MV Boli", Font.PLAIN, 45));
			buttons[i].addActionListener(this);
			this.add(buttons[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// CHECK IF SQUARE IS EMPTY AND GAME IS NOT OVER
		if (((AbstractButton) e.getSource()).getText() != "X" && ((AbstractButton) e.getSource()).getText() != "O"
				&& !Game.over) {

			// MARK BUTTON
			((AbstractButton) e.getSource()).setText("X");

			// REGISTER MOVE
			for (int i = 0; i < 9; i++) {
				if (e.getSource() == buttons[i]) {
					Game.board[i] = "X";
					Game.turn++;
					if (Oponent.takeTurn()) {
						Game.countmoves();
					} else {
						System.out.println("take turn return false");
					}

				}
			}

		}
	}

}
