// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null || s3.length() != s1.length() + s2.length()) {
			return false;
		}

		int m = s1.length();
		int n = s2.length();
		boolean[][] f = new boolean[m + 1][n + 1];

		f[0][0] = true;
		for (int i = 1; i <= m; i++) {
			f[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && f[i - 1][0];
		}

		for (int i = 1; i <= n; i++) {
			f[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) && f[0][i - 1];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					f[i][j] |= f[i - 1][j];
				}

				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					f[i][j] |= f[i][j - 1];
				}
			}
		}

		return f[m][n];
    }
}