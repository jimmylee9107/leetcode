// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

// Range Sum Query 2D
// The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

// Given matrix = [
// [3, 0, 1, 4, 2],
// [5, 6, 3, 2, 1],
// [1, 2, 0, 1, 5],
// [4, 1, 0, 1, 7],
// [1, 0, 3, 0, 5]
// ]

// sumRegion(2, 1, 4, 3) -> 8
// sumRegion(1, 1, 2, 2) -> 11
// sumRegion(1, 2, 2, 4) -> 12

// Note:
// You may assume that the matrix does not change.
// There are many calls to sumRegion function.
// You may assume that row1 ≤ row2 and col1 ≤ col2.
class RangeSumQuery2DImmutable {
	private int[][] sumMatrix = null;
	public NumMatrix(int[][] matrix) {
		if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			sumMatrix = new int[m][n];
			sumMatrix[0][0] = matrix[0][0];
			for (int i = 1; i < m; i++) {
				sumMatrix[i][0] = matrix[i][0] + sumMatrix[i - 1][0];
			}
			
			for (int i = 1; i < n; i++) {
				sumMatrix[0][i] = matrix[0][i] + sumMatrix[0][i - 1];
			}
			
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					sumMatrix[i][j] = matrix[i][j] + sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1];
				}
			}
		}
	}

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (sumMatrix == null || row2 > sumMatrix.length || col2 > sumMatrix[0].length) {
    		return 0;
    	}
        int res = sumMatrix[row2][col2];
        if (col1 > 0) {
        	res -= sumMatrix[row2][col1 - 1];
        } 
        if (row1 > 0) {
        	res -= sumMatrix[row1 - 1][col2];
        }
        if (row1 > 0 && col1 > 0) {
        	res += sumMatrix[row1 - 1][col1 - 1];
        }
        return res;
    }
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);