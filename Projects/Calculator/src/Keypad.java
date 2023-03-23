import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Keypad extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3208473325890464485L;

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
	JButton btn00;
	JButton btnPlus;
	JButton btnMinus;
	JButton btnDivide;
	JButton btnMultiply;
	JButton btnC;
	JButton btnClear;
	JButton btnComma;

	Keypad() {

		this.setBackground(Color.green);
		this.setLayout(new GridLayout(5, 4)); // layout manager (rows,columns,horizontal margin,vertical margin)
		this.setPreferredSize(new Dimension(500, 600));

		btn7 = new JButton("7");
		btn7.addActionListener(this);
		this.add(btn7);

		btn8 = new JButton("8");
		btn8.addActionListener(this);
		this.add(btn8);

		btn9 = new JButton("9");
		btn9.addActionListener(this);
		this.add(btn9);

		btnPlus = new JButton("+");
		btnPlus.addActionListener(this);
		this.add(btnPlus);

		btn4 = new JButton("4");
		btn4.addActionListener(this);
		this.add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(this);
		this.add(btn5);

		btn6 = new JButton("6");
		btn6.addActionListener(this);
		this.add(btn6);

		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		this.add(btnMinus);

		btn1 = new JButton("1");
		btn1.addActionListener(this);
		this.add(btn1);

		btn2 = new JButton("2");
		btn2.addActionListener(this);
		this.add(btn2);

		btn3 = new JButton("3");
		btn3.addActionListener(this);
		this.add(btn3);

		btnMultiply = new JButton("X");
		btnMultiply.addActionListener(this);
		this.add(btnMultiply);

		btn00 = new JButton("00");
		btn00.addActionListener(this);
		this.add(btn00);

		btn0 = new JButton("0");
		btn0.addActionListener(this);
		this.add(btn0);

		btnComma = new JButton(".");
		btnComma.addActionListener(this);
		this.add(btnComma);

		btnDivide = new JButton("/");
		btnDivide.addActionListener(this);
		this.add(btnDivide);

		btnClear = new JButton("C");
		btnClear.addActionListener(this);
		this.add(btnClear);

		this.add(new JButton(" "));

		this.add(new JButton(" "));

		btnEquals = new JButton("=");
		btnEquals.addActionListener(this);
		this.add(btnEquals);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnDivide) {
			Compute.chooseAction('/');
		} else if (e.getSource() == btn0) {
			Compute.addNumber("0");
		} else if (e.getSource() == btn00) {
			Compute.addNumber("00");
		} else if (e.getSource() == btn1) {
			Compute.addNumber("1");
		} else if (e.getSource() == btn2) {
			Compute.addNumber("2");
		} else if (e.getSource() == btn3) {
			Compute.addNumber("3");
		} else if (e.getSource() == btn4) {
			Compute.addNumber("4");
		} else if (e.getSource() == btn5) {
			Compute.addNumber("5");
		} else if (e.getSource() == btn6) {
			Compute.addNumber("6");
		} else if (e.getSource() == btn7) {
			Compute.addNumber("7");
		} else if (e.getSource() == btn0) {
			Compute.addNumber("0");
		} else if (e.getSource() == btn8) {
			Compute.addNumber("8");
		} else if (e.getSource() == btn9) {
			Compute.addNumber("9");
		} else if (e.getSource() == btnPlus) {
			Compute.chooseAction('+');
		} else if (e.getSource() == btnMinus) {
			Compute.chooseAction('-');
		} else if (e.getSource() == btnMultiply) {
			Compute.chooseAction('X');
		} else if (e.getSource() == btnClear) {
			Compute.clear();
		} else if (e.getSource() == btnEquals) {
			Compute.equals();
		}
	}

}
