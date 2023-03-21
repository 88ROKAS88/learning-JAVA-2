import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame {

	static JLabel screen;

	String text = "";

	Calculator() {
		System.out.println("Hello World");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.setLayout(null);

		// SCREEN
		// ################################################################
		screen = new JLabel();
//		screen.setBackground(Color.yellow);
		screen.setForeground(Color.white);
		screen.setFont(new Font("MV Boli", Font.PLAIN, 35));

		// PANEL
		// ################################################################
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(0, 0, 500, 100);
		panel.setPreferredSize(new Dimension(500, 100));
		panel.add(screen);

		// KEYPAD
		// ################################################################
		Keypad keypad = new Keypad();

		// FRAME
		// ################################################################
		this.add(keypad);
		this.add(panel);

		this.setSize(500, 600);
//		this.pack();
//		this.setResizable(false);
		this.setVisible(true);
	}

}
