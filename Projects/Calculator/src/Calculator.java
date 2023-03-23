import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6858853048017749183L;

	static JLabel screen;

	Calculator() {
		System.out.println("Hello World");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Calculator");

		// SCREEN
		// ################################################################
		screen = new JLabel();
		screen.setOpaque(true);
		screen.setPreferredSize(new Dimension(500, 100));
		screen.setFont(new Font("MV Boli", Font.PLAIN, 45));

		// SCREEN PANEL
		// ################################################################
		JPanel screenPanel = new JPanel();
		screenPanel.setPreferredSize(new Dimension(500, 100));
		screenPanel.add(screen);

		// KEYPAD
		// ################################################################
		Keypad keypad = new Keypad();

		// PANEL
		// ################################################################
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 700));
		panel.add(screenPanel);
		panel.add(keypad);

		// FRAME
		// ################################################################
		this.add(panel);

		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

}
