
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tik Tac Toe");


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
					System.out.println("New Game");
					Game.newGame();
				}
			}
		});
		filemenu.setMnemonic(KeyEvent.VK_F); // set shortcut to Alt + F
		newGame.setMnemonic(KeyEvent.VK_N); // set shortcut to N
		filemenu.add(newGame);
		menubar.add(filemenu);
		frame.setJMenuBar(menubar);

		Keypad keypad = new Keypad();

		// FRAME
		// ################################################################
		frame.add(keypad);

		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
