// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int ml = 0;
		int mr = matrix.length;
		int nl = 0;
		int nr = matrix[0].length;
		int r = 0;
		int c = 0;
		res.add(matrix[0][0]);

		while(res.size() < m * n) {
			//up
			while(res.size() < m * n && r > ml) {
				res.add(matrix[--r][c]);
			}
			ml++;
			//right
			while(res.size() < m * n && c < nr - 1) {
				res.add(matrix[r][++c]);
			}
			nr--;
			//down
			while(res.size() < m * n && r < mr - 1) {
				res.add(matrix[++r][c]);
			}
			mr--;
			//left
			while(res.size() < m * n && c > nl) {
				res.add(matrix[r][--c]);
			}
			nl++;

		}

		return res;
    }
}