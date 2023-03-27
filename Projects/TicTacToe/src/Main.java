
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tik Tac Toe");

		Keypad keypad = new Keypad();

		// FRAME
		// ################################################################
		frame.add(keypad);

		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
