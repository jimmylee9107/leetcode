// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new LinkedList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		Comparator<Interval> cmp = new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		};

		Collections.sort(intervals, cmp);
		Interval prev = null;
		for (Interval interval : intervals) {
			if (prev == null) {
				prev = interval;
			} else {
				if (interval.start > prev.end) {
					res.add(prev);
					prev = interval;
				} else {
					prev.end = Math.max(prev.end, interval.end);
					prev.start = Math.min(prev.start, interval.start);
				}
			}
		}
		res.add(prev);

		return res;
    }
}