class RotateMatrix {
	private int[][] tranpose(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] res = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = matrix[j][i];
			}
		}
		return res;
	}

	private void rotate(int[][] matrix, boolean flag) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (flag) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n / 2; j++) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[i][n - j - 1];
					matrix[i][n - j - 1] = temp;
				}
			}
		} else {
			for (int i = 0; i < m / 2; i++) {
				for (int j = 0; j < n; j++) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[m - i - 1][j];
					matrix[m - i - 1][j] = temp;
				}
			}
		}
	}

	public int[][] rotateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1) {
			return matrix;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] res;
		res = tranpose(matrix);
		rotate(res);
		return res;
	}
}