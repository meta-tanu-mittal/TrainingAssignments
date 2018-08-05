package com.metacube.training.task2;

import com.metacube.training.stack.*;

/**
 * convert infix expression to postfix expression
 * 
 * @author Tanu Mittal
 *
 */
public class InfixToPostfix {
	/**
	 * convert infix to postfix
	 * 
	 * @param infixExpression
	 * @return postfix expression
	 */
	public String convertInfixToPostfix(String infixExpression) {
		StackUsingLinkList<String> stack = new StackUsingLinkList<String>();
		String[] infix = infixExpression.split("\\s+");

		StringBuilder postfix = new StringBuilder("");
		for (int i = 0; i < infix.length; i++) {

			if (infix[i].matches("[a-z]*[A-Z]*[0-9]*")) {
				postfix.append(infix[i]);
			}
			if ("(".equals(infix[i])) {
				stack.push(infix[i]);
			} else {
				if (")".equals(infix[i]) && !(stack.isEmpty())) {
					while (!(stack.isEmpty()) && !("(".equals(stack.topElement()))) {
						postfix.append(stack.pop());
					}
					if (!(stack.isEmpty()) && !("(".equals(stack.topElement()))) {
						throw new AssertionError("invalid expression");
					}
					if (!(stack.isEmpty()) && "(".equals(stack.topElement())) {
						stack.pop();
					}

				} else {
					if (isOperator(infix[i])) {
						if (stack.isEmpty()) {
							stack.push(infix[i]);
						} else {
							if (((getPrecedence(infix[i])) > (getPrecedence(stack.topElement())))) {
								stack.push(infix[i]);
							} else {
								while (!(stack.isEmpty())
										&& (getPrecedence(infix[i]) <= getPrecedence(stack.topElement()))
										&& !("(".equals(stack.topElement()))) {
									postfix.append(stack.pop());
								}
								stack.push(infix[i]);
							}
						}

					}

				}
			}
		}
		while (!(stack.isEmpty())) {
			postfix.append(stack.pop());
		}
		return postfix.toString();

	}

	/**
	 * find precedence of an operator
	 * 
	 * @param operator
	 * @return precedence
	 */

	int getPrecedence(String operator) {

		switch (operator) {
		case "!":
			return 7;
		case "*":
		case "/":
			return 6;
		case "+":
		case "-":
			return 5;
		case "<":
		case "<=":
		case ">":
		case ">=":
			return 4;
		case "==":
		case "!=":
			return 3;
		case "&&":
			return 2;
		case "||":
			return 1;
		case "(":
			return 0;

		}
		return -1;
	}

	/**
	 * check whether given token is operator or not
	 * 
	 * @param token
	 * @return true if token is operator
	 */
	public boolean isOperator(String token) {
		switch (token) {
		case "!":
		case "*":
		case "/":
		case "+":
		case "-":
		case "<":
		case "<=":
		case ">":
		case ">=":
		case "==":
		case "!=":
		case "&&":
		case "||":
			return true;
		default:
			return false;
		}

	}

}
