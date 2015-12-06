// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if (numRows <= 0) {
			return res;
		}

		res.add(Arrays.asList(1));
		if (numRows == 1) {
			return res;
		}

		res.add(Arrays.asList(1, 1));
		if (numRows == 2) {
			return res;
		}

		for (int i = 3; i <= numRows; i++) {
			List<Integer> level = new ArrayList<>();
			level.add(1);
			for (int j = 1; j < i - 1; j++) {
				int num1 = res.get(res.size() - 1).get(j - 1);
				int num2 = res.get(res.size() - 1).get(j);
				level.add(num1 + num2);
			}

			level.add(1);
			res.add(level);
		}
		return res;
    }
}