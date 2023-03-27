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
//			buttons[i]
			this.add(buttons[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(((AbstractButton) e.getSource()).getText());
		if (((AbstractButton) e.getSource()).getText() != "X" && ((AbstractButton) e.getSource()).getText() != "O") {

			((AbstractButton) e.getSource()).setText("X");
			for (int i = 0; i < 9; i++) {
				if (e.getSource() == buttons[i]) {
					System.out.println(i);
				}
			}
		}
	}

}
