// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

// For example, given the following matrix:

// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Return 4.

class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] f = new int[m][n];

		//init
		int max = 0;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				f[i][0] = 1;
				max = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == '1') {
				f[0][i] = 1;
				max = 1;
			}
		}


		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					f[i][j] = Math.min(f[i - 1][j], Math.min(f[i - 1][j - 1], f[i][j - 1])) + 1;
					max = Math.max(max, f[i][j] * f[i][j]);
				}
			}
		}

		return max;
    }
}