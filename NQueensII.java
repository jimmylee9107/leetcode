// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.

class NQueensII {
	private boolean isValid(List<Integer> column, int x, int y) {
		if (column == null || column.size() == 0) {
			return true;
		}

		for (int i = 0; i < column.size(); i++) {
			if (x == i) {
				return false;
			}

			if (y == column.get(i)) {
				return false;
			}

			if (x + y == i + column.get(i)) {
				return false;
			}

			if (x - y == i - column.get(i)) {
				return false;
			}
		}
		return true;
	}
	private int helper(List<Integer> column, int n, int row) {
		if (column.size() == n) {
			return 1;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!isValid(column, row, i)) {
				continue;
			}
			column.add(i);
			count += helper(column, n, row + 1);
			column.remove(column.size() - 1);
		}
		return count;
	}
	public int totalNQueens(int n) {
		if (n <= 1) {
			return n;
		}
		return helper(new LinkedList<Integer>(), n, 0); 
    }
}