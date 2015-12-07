// A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

// For example, given three people living at (0,0), (0,4), and (2,2):

// 1 - 0 - 0 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
// The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int[] x = new int[m];
		int[] y = new int[n];
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					x[i]++;
					y[j]++;
					count++;
				}
			}
		}

		int dis_x = 0;
		int count_x = x[0];
		for (int i = 0; i < m; i++) {
			dis_x += i * x[i];
		}
		int min_x = dis_x;
		for (int i = 1; i < m; i++) {
			dis_x += 2 * count_x - count;
			count_x += x[i];
			min_x = Math.min(min_x, dis_x);
		}

		int dis_y = 0;
		int count_y = y[0];
		for (int i = 0; i < n; i++) {
			dis_y += i * y[i];
		}
		int min_y = dis_y;
		for (int i = 1; i < n; i++) {
			dis_y += 2 * count_y - count;
			count_y += y[i];
			min_y = Math.min(min_y, dis_y);
		}

		return min_x + min_y;
    }
}