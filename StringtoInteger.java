// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
class StringtoInteger {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		str = str.trim();
		int i = 0;
		int sign = 1;
		if (str.charAt(i) == '+') {
			i++;
		} else if (str.charAt(i) == '-') {
			i++;
			sign = -1;
		}

		long res = 0;
		while(i < str.length()) {
			if (!Character.isDigit(str.charAt(i))) {
				break;
			}

			int value = str.charAt(i) - '0';
			res = 10 * res + value;
			if (res > Integer.MAX_VALUE) {
				break;
			}
			i++;
		}

		if (sign * res >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (sign * res <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return (int) res * sign;
    }
}