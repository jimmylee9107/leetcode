class RegularExpressionMatching {
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		int len_s = s.length();
		int len_p = p.length();
		boolean[][] f = new boolean[len_s + 1][len_p + 1];
		f[0][0] = true;
		for (int i = 0; i <= len_s; i++) {
			for (int j = 1; j <= len_p; j++) {
				if (i >= 1 (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
					f[i][j] = f[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*' && j > 1) {
					if (f[i][j - 2] || f[i][j - 1]) {
					    //match 0 and 1
						f[i][j] = true;
					} else if (i > 1 && f[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) {
						//match 2 or more
						f[i][j] = true;
					}
				}
			}
		}
		return f[len_s][len_p];
    }
}