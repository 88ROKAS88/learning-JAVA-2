
public class Compute {

	static int num1 = 0;
	static int num2 = 0;;
	static String current = "";
	static char action;

	public static void display() {
		Calculator.screen.setText(current);
		if (num1 != 0 && current.length() > 0) {
			Calculator.screen.setText("" + num1 + action + current);
		} else if (num1 != 0) {
			Calculator.screen.setText("" + num1 + action);
		} else {
			Calculator.screen.setText(current);
		}
	}

	public static void calculate() {
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

	public static void addNumber(String num) {
		current += num;
		display();
	}

	public static void chooseAction(char newAction) {
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

}
