import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SnakeMenu extends JMenuBar {
	SnakeMenu() {
		JMenuItem filemenu = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");

		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == newGame) {
					Game.newGame();
				}
			}
		});
		filemenu.setMnemonic(KeyEvent.VK_F); // set shortcut to Alt + F
		newGame.setMnemonic(KeyEvent.VK_N); // set shortcut to N
		filemenu.add(newGame);
		this.add(filemenu);
	}
}
