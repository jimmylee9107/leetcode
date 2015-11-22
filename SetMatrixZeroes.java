// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		boolean row_zero = false;
		boolean col_zero = false;
		//check for the first row
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				row_zero = true;
				break;
			}
		}
		//check for the first column
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				col_zero = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		//set zero 
		for (int i = 1; i < n; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < m; j++) {
					matrix[j][i] = 0;
				}
			} 
		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			} 
		}

		//check first row and column
		if (row_zero) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (col_zero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
    }
}