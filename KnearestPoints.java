class KnearestPoints {
	class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private double getdistance(Point a, Point origin) {
		return Math.sqrt((a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y));
	}
	public Point[] findKnearestPoints(Point[] points, Point origin, int k) {
		if (origin == null || points == null || points.length < k) {
			return new Point[0];
		}
		Point[] res = new Point[k];
		PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
			public int compare(Point a, Point b) {
				double d_a = Math.sqrt((a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y));
				double d_b = Math.sqrt((b.x - origin.x) * (b.x - origin.x) + (b.y - origin.y) * (b.y - origin.y));
				return (int) (d_b - d_a);
			}
		});

		for (Point point : points) {
			if (pq.size() < k) {
				pq.offer(point);
			} else {
				if (getdistance(point, origin) < getdistance(pq.peek(), origin)) {
					pq.poll();
					pq.offer(point);
				}
			}
		}

		int index = 0;
		while(!pq.isEmpty()) {
			res[index++] = pq.poll();
		}
		return res;
	}
}