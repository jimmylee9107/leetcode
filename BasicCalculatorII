class BasicCalculatorII {
/*
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
+-* '/' and white space
*/
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		char sign = '+';
		int num = 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}

			if (!Character.isDigit(c) && !Character.isWhiteSpace(c) || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}

				sign = c;
				num = 0;
			}
		}

		while(!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
    }
}