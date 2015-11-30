// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if ("+-*/".contains(tokens[i])) {
				if (tokens[i].equals("+")) {
					stack.push(stack.pop() + stack.pop());
				} else if (tokens[i].equals("-")) {
					stack.push(-stack.pop() + stack.pop());
				} else if (tokens[i].equals("*")) {
					stack.push(stack.pop() * stack.pop());
				} else {
					int divisor = stack.pop();
					stack.push(stack.pop() / divisor);
				}
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}

		return stack.pop();
    } 
}