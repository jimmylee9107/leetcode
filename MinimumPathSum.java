//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[2][n];

		f[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			f[0][i] = f[0][i - 1] + grid[0][i];
		}

		for (int i = 1; i < m; i++) {
			f[i % 2][0] = grid[i][0] + f[(i - 1) % 2][0];
			for (int j = 1; j < n; j++) {
				f[i % 2][j] = Math.min(f[i % 2][j - 1], f[(i - 1) % 2][j]) + grid[i][j];
			}
		}
		return f[(m - 1) % 2][n - 1];
    }
}