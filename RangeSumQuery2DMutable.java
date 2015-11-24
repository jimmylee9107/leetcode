// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

// Range Sum Query 2D
// The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

// Given matrix = [
//   [3, 0, 1, 4, 2],
//   [5, 6, 3, 2, 1],
//   [1, 2, 0, 1, 5],
//   [4, 1, 0, 1, 7],
//   [1, 0, 3, 0, 5]
// ]

// sumRegion(2, 1, 4, 3) -> 8
// update(3, 2, 2)
// sumRegion(2, 1, 4, 3) -> 10

class RangeSumQuery2DMutable {
	private int[][] numMatrix = null;
	
	public NumMatrix(int[][] matrix) {
		if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			numMatrix = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					numMatrix[i][j] = matrix[i][j];
				}
			}
		}
    }

    public void update(int row, int col, int val) {
    	if (numMatrix != null) {
    		numMatrix[row][col] = val;
    	}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int res = 0;
    	for (int i = row1; i <= row2; i++) {
    		for (int j = col1; j <= col2; j++) {
    			res += numMatrix[i][j];
    		}
    	}
    	return res;
    }
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);