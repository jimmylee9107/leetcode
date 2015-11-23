// An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

// For example, given the following image:

// [
// "0010",
// "0110",
// "0100"
// ]
// and x = 0, y = 2,
// Return 6.
class SmallestRectangleEnclosingBlackPixels {
	class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private final int[] dx = {0, 1, 0, -1};
	private final int[] dy = {1, 0, -1, 0};
	public int minArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return 0;
		}

		int m = image.length;
		int n = image[0].length;
		if (x < 0 || x >= m || y < 0 || y >= n) {
			return 0;
		}

		int left = y;
		int right = y;
		int top = x;
		int down = x;

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		boolean[][] isvisited = new boolean[m][n];
		isvisited[x][y] = true;
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isvisited[nx][ny] && image[nx][ny] == '1') {
					left = Math.min(left, ny);
					right = Math.max(right, ny);
					top = Math.min(top, nx);
					down = Math.max(down, nx);
					isvisited[nx][ny] = true;
					queue.offer(new Point(nx, ny));
				}
			}
		}
		int width = right - left + 1;
		int height = down - top + 1;
		return width * height;
    }
}