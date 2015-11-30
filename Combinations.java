// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class Combinations {
	private void helper(List<List<Integer>> res, List<Integer> container, int k, int n, int offset) {
		if (container.size() == k) {
			res.add(new LinkedList<>(container));
			return;
		}

		for (int i = offset; i <= n; i++) {
			container.add(i);
			helper(res, container, k, n, i + 1);
			container.remove(container.size() - 1);
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<>();
		if (n == 0 || k == 0 || k > n) {
			return res;
		}

		helper(res, new LinkedList<Integer>(), k, n, 1);
		return res;
    }
}