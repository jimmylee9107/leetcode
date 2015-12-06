class MaximumminimumPath {
	public int maximumminimumpath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] f = new int[m][n];
		f[0][0] = matrix[0][0];
		for (int i = 1; i < n; i++) {
			f[0][i] = Math.min(f[0][i - 1], matrix[0][i]);
		}

		for (int i = 1; i < m; i++) {
			f[i][0] = Math.min(f[i - 1][0], matrix[i][0]);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				f[i][j] = Math.max(Math.min(matrix[i][j], f[i - 1][j]), Math.min(matrix[i][j], f[i][j - 1]));
			}
		}

		return f[m - 1][n - 1];
	}
}