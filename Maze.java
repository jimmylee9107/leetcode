class Maze {
	class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private final int[] dx = {0, 1, 0, -1};
	private final int[] dy = {1, 0, -1, 0};
	public boolean cangetthrough(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		if (matrix[0][0] == 9) {
			return true;
		}

		if (matrix[0][0] == 1) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));
		matrix[0][0] = 1;
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] != 1) {
					if (matrix[nx][ny] == 9) {
						return true;
					}

					queue.offer(new Point(nx, ny));
					matrix[nx][ny] = 1;
				}
			}
		}
		return false;
	}
}