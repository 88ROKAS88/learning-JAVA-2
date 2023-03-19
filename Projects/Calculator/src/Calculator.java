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

public class Calculator extends JFrame implements ActionListener {

	int num1 = 0;
	int num2 = 0;;
	String current = "";
	char action;

	JLabel screen;

	JButton btnEquals;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn0;
	JButton btnPlus;
	JButton btnMinus;
	JButton btnDivide;
	JButton btnMultiply;
	JButton btnC;

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

		// BUTTONS
		// ################################################################
		JPanel buttons = new JPanel();
		buttons.setBackground(Color.green);
		buttons.setLayout(new GridLayout(4, 4)); // layout manager (rows,columns,horizontal margin,vertical margin)
		buttons.setBounds(0, 100, 500, 500);

//		for (int i = 0; i < 15; i++) {
//			buttons.add(new JButton("nr. " + i));
//		}
		btn7 = new JButton("7");
		btn7.addActionListener(this);
		buttons.add(btn7);

		btn8 = new JButton("8");
		btn8.addActionListener(this);
		buttons.add(btn8);

		btn9 = new JButton("9");
		btn9.addActionListener(this);
		buttons.add(btn9);

		btnPlus = new JButton("+");
		btnPlus.addActionListener(this);
		buttons.add(btnPlus);

		btn4 = new JButton("4");
		btn4.addActionListener(this);
		buttons.add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(this);
		buttons.add(btn5);

		btn6 = new JButton("6");
		btn6.addActionListener(this);
		buttons.add(btn6);

		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		buttons.add(btnMinus);

		btn1 = new JButton("1");
		btn1.addActionListener(this);
		buttons.add(btn1);

		btn2 = new JButton("2");
		btn2.addActionListener(this);
		buttons.add(btn2);

		btn3 = new JButton("3");
		btn3.addActionListener(this);
		buttons.add(btn3);

		btnMultiply = new JButton("X");
		btnMultiply.addActionListener(this);
		buttons.add(btnMultiply);

		btnC = new JButton("C");
		btnC.addActionListener(this);
		buttons.add(btnC);

		btn0 = new JButton("0");
		btn0.addActionListener(this);
		buttons.add(btn0);

		btnEquals = new JButton("=");
		btnEquals.addActionListener(this);
		buttons.add(btnEquals);

		btnDivide = new JButton("/");
		btnDivide.addActionListener(this);
		buttons.add(btnDivide);

		// FRAME
		// ################################################################
		this.add(buttons);
		this.add(panel);

		this.setSize(500, 600);
//		this.pack();
//		this.setResizable(false);
		this.setVisible(true);
	}

	public void display() {
		screen.setText(current);
		if (num1 != 0 && current.length() > 0) {
			screen.setText("" + num1 + action + current);
		} else if (num1 != 0) {
			screen.setText("" + num1 + action);
		} else {
			screen.setText(current);
		}
	}

	public void calculate() {
		switch (action) {
		case '+':
			num1 = num1 + num2;
			num2 = 0;
			display();
			break;
		case '-':
			num1 = num1 - num2;
			num2 = 0;
			current = "";
			display();
			break;
		case 'X':
			num1 = num1 * num2;
			num2 = 0;
			current = "";
			display();
			break;
		case '/':
			num1 = num1 / num2;
			num2 = 0;
			current = "";
			display();
			break;
		}
	}

	public void addNumber(String num) {
		current += num;
		display();
	}

	public void chooseAction(char newAction) {
		if (num1 == 0) {
			num1 = Integer.valueOf(current);
			action = newAction;
		} else if (num1 != 0 && current.length() > 0) {
			num2 = Integer.valueOf(current);
			calculate();
			action = newAction;
		} else {
			action = newAction;
		}
		current = "";
		display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getSource());

//		if (e.getSource() == button) {
//			System.out.println("BTN");
//			text += "Btn ";
//			screen.setText(text);
//			System.out.println(text);
//		}
		if (e.getSource() == btnDivide) {
//			text += "/";
			chooseAction('/');
		} else if (e.getSource() == btn0) {
//			text += "0";
			addNumber("0");
		} else if (e.getSource() == btn1) {
//			text += "1";
			addNumber("1");
		} else if (e.getSource() == btn2) {
//			text += "2";
			addNumber("2");
		} else if (e.getSource() == btn3) {
//			text += "3";
			addNumber("3");
		} else if (e.getSource() == btn4) {
			addNumber("4");
		} else if (e.getSource() == btn5) {
			addNumber("5");
		} else if (e.getSource() == btn6) {
			addNumber("6");
		} else if (e.getSource() == btn7) {
			addNumber("7");
		} else if (e.getSource() == btn0) {
			addNumber("0");
		} else if (e.getSource() == btn8) {
			addNumber("8");
		} else if (e.getSource() == btn9) {
			addNumber("9");
		} else if (e.getSource() == btnPlus) {
			chooseAction('+');
		} else if (e.getSource() == btnMinus) {
			chooseAction('-');
		} else if (e.getSource() == btnMultiply) {
			chooseAction('X');
		} else if (e.getSource() == btnC) {
			current = "";
			display();
		} else if (e.getSource() == btnEquals) {
			if (num1 != 0 && current.length() > 0) {
				num2 = Integer.valueOf(current);
				calculate();
				action = ' ';
				display();
			}
		}

//		screen.setText(text);
	}

}
