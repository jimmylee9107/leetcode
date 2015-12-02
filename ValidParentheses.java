// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == stack.peek() + 1 || s.charAt(i) == stack.peek() + 2) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		return stack.isEmpty();
    }
}