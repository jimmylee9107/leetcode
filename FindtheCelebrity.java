/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
class FindtheCelebrity {
	public int findCelebrity(int n) {
		if (n == 0) {
			return -1;
		}

		int res = 0;
		for (int i = 1; i < n; i++) {
			if (knows(res, i)) {
				res = i;
			}
		}

		for (int i = 0; i < n; i++) {
			if (!knows(i, res)) {
				return -1;
			}
			if (knows(res, i) && res != i) {
				return -1;
			}
		}
		return res;
    }
}