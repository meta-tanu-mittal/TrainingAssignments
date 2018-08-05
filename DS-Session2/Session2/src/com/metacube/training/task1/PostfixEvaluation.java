package com.metacube.training.task1;

import com.metacube.training.stack.StackUsingLinkList;

/**
 * evaluation of postfix expression
 * 
 * @author user
 *
 */
public class PostfixEvaluation {

	/**
	 * evaluate postfix expression
	 * 
	 * @param postfixExpression
	 *            is the expression to be evaluated
	 * @return value after evaluation
	 */
	public double evaluationOfPostfix(String postfixExpression) {
		StackUsingLinkList<Double> obj = new StackUsingLinkList<Double>();
		String[] postfix = postfixExpression.split("\\s+");

		for (int i = 0; i < postfix.length; i++) {
			if (!isOperator(postfix[i])) {
				obj.push((Double.parseDouble((postfix[i]))));
			} else {
				double a = (double) obj.pop();
				double b = (double) obj.pop();
				String operator = postfix[i];
				switch (operator) {
				case "+":
					obj.push(a + b);
					break;
				case "-":
					obj.push(b - a);
					break;
				case "*":
					obj.push(a * b);
					break;
				case "/":
					if (b == 0) {
						throw new RuntimeException("cannot divide by zero");
					}
					obj.push(a / b);
					break;

				}
			}
		}
		return obj.pop();

	}

	/**
	 * check if token is operator or not
	 * 
	 * @param token
	 * @return true if token is operator
	 */
	private boolean isOperator(String token) {
		switch (token) {
		case "+":
		case "-":
		case "*":
		case "/":
			return true;
		}
		return false;

	}

}
