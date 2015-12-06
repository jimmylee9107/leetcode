// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

class CountandSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}

		if (n == 1) {
			return "1";
		}

		String prev = "1";
		for (int i = 2; i <= n; i++) {
			StringBuilder temp = new StringBuilder();
			int count = 1;
			char c = prev.charAt(0);
			for (int j = 1; j < prev.length(); j++) {
				if (prev.charAt(j) == c) {
					count++;
				} else {
					temp.append(count);
					temp.append(c);
					c = prev.charAt(j);
					count = 1;
				}
			}
			temp.append(count);
			temp.append(c);
			prev = temp.toString();
		}
		return prev;
    }
}