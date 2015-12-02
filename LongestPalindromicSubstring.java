//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

class LongestPalindromicSubstring {
	private String preprocess(String s) {
		if (s == null || s.length() == 0) {
			return "^$";
		}

		StringBuilder res = new StringBuilder();
		res.append('^');
		for (int i = 0; i < s.length(); i++) {
			res.append('#');
			res.append(s.charAt(i));
		}
		res.append('#');
		res.append('$');
		return res.toString();
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		String t = preprocess(s);
		int len = t.length();
		int C = 0;
		int R = 0;
		int[] P = new int[len];
		for (int i = 1; i < len - 1; i++) {
			int i_mirror = C - (i - C);
			P[i] = R > i ? Math.min(R - i, P[i_mirror]) : 0;
			while(t.charAt(P[i] + i + 1) == t.charAt(i - P[i] - 1)) {
				P[i]++;
			}

			if (i + P[i] > R) {
				R = i + P[i];
				C = i;
			}
		}

		int max = Integer.MIN_VALUE;
		int center = -1;
		for (int i = 0; i < len; i++) {
			if (P[i] > max) {
				max = P[i];
				center = i;
			}
		}

		return s.substring((center - max - 1) / 2, (center + max - 1) / 2);
	}
}