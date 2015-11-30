// Given a string containing just the characters '(' and ')', 
// find the length of the longest valid (well-formed) parentheses substring.
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int[] f = new int[n];
		int max = 0;
		f[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				int j = i + f[i + 1] + 1;
				if (j < n && s.charAt(j) == ')') {
					f[i] = f[i + 1] + 2;
					if (j + 1 < n) {
						f[i] += f[j + 1];
					}
				}
			}
			max = Math.max(max, f[i]);
		}
		return max;
    }
}