// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]

class NQueens {
	private boolean isValid(List<Integer> column, int x, int y) {
		if (column == null || column.size() == 0) {
			return true;
		}
		for (int i = 0; i < column.size(); i++) {
			if (column.get(i) == y) {
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
	private List<String> printgraph(List<Integer> column) {
		List<String> res = new LinkedList<>();
		if (column == null || column.size() == 0) {
			return res;
		}
		for (int i = 0; i < column.size(); i++) {
			int index = column.get(i);
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < column.size(); j++) {
				if (j == index) {
					temp.append('Q');
				} else {
					temp.append('.');
				}
			}
			res.add(temp.toString());
		}
		return res;
	}
	private void helper(List<List<String>> res, List<Integer> column, int n, int row) {
		if (column.size() == n) {
			res.add(printgraph(column));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isValid(column, row, i)) {
				continue;
			}
			column.add(i);
			helper(res, column, n, row + 1);
			column.remove(column.size() - 1);
		}
	} 
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new LinkedList<>();
		if (n == 0) {
			return res;
		}

		helper(res, new LinkedList<>(), n, 0);
		return res;
    }
}