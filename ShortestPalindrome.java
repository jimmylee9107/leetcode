// Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

// For example:

// Given "aacecaaa", return "aaacecaaa".

// Given "abcd", return "dcbabcd".

class ShortestPalindrome {
	private String preproccessing(String s) {
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

	public String shortestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		String t = preproccessing(s);
		int len = t.length();
		int c = 0;
		int r = 0;
		int[] f = new int[t];
		for (int i = 1; i < len - 1; i++) {
			int mirror_index = c - (i - c);
			f[i] = r > i ? Math.min(f[mirror_index], r - c) : 0;
			while(t.charAt(i + 1 + f[i]) == t.charAt(i - 1 - f[i])) {
				f[i]++;
			}
			if (i + f[i] > r) {
				c = i;
				r = i + f[i];
			}
		}

		int maxlen = 0;
		c = 0;
		for (int i = 1; i < len - 1; i++) {
			if (f[i] > maxlen && i - f[i] == 1) {
				maxlen = f[i];
				c = i;
			}
		}

		return new StringBuilder(s).reverse() + s.substring((c - 1 + maxlen) / 2, s.length());
    }
}