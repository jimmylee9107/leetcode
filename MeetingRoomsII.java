class MeetingRoomsII {
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
	class Point {
		int time;
		boolean type;
		Point(int time, boolean type) {
			this.time = time;
			this.type = type;
		}
	}
	
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		
		int res = 0;
		List<Point> points = new LinkedList<>();
		for (Interval interval : intervals) {
			points.add(new Point(interval.start, true);
			points.add(new Point(interval.end, false);
		}

		Comparator<Point> cmp = new Comparator<Point>() {
			public int compare(Point a, Point b) {
				if (a.time == b.time) {
					if (a.type && b.type || !a.type && !b.type) {
						return 0;
					} else if (!a.type && b.type) {
						return -1;
					} else {
						return 1;
					}
				}
				return a.time - b.time;
			}
		};

		Collections.sort(points, cmp);
		int count = 0;
		for (Point p : points) {
			if (p.type == true) {
				count++;
			} else {
				count--;
			}
			res = Math.max(res, count);
		}
		return res;
	}	
}