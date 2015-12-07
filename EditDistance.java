// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// a) Insert a character
// b) Delete a character
// c) Replace a character

class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return Integer.MAX_VALUE;
		}

		if (word1.equals(word2)) {
			return 0;
		}

		int m = word1.length();
		int n = word2.length();
		int[][] f = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			f[i][0] = i;
		}

		for (int i = 1; i <= n; i++) {
			f[0][i] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1];
				} else {
					f[i][j] = Math.min(f[i - 1][j], Math.min(f[i - 1][j - 1], f[i][j - 1])) + 1;
				}
			}
		}

		return f[m][n];
    }
}