// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

// Ensure that numbers within the set are sorted in ascending order.


// Example 1:

// Input: k = 3, n = 7

// Output:

// [[1,2,4]]

// Example 2:

// Input: k = 3, n = 9

// Output:

// [[1,2,6], [1,3,5], [2,3,4]]
class CombinationSumIII {
	private void helper(List<List<Integer>> res, List<Integer> container, int k, int target, int index) {
		if (container.size() == k) {
			if (target == 0) {
				res.add(new LinkedList<>(container));
			}
			return;
		} 

		for (int i = index; i <= n; i++) {
			container.add(i);
			helper(res, container, k, target - i, i + 1);
			container.remove(container.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new LinkedList<>();
		if (k == 0 || n == 0) {
			return res;
		}

		helper(res, new LinkedList<Integer>(), k, n, 1);
		return res;
    }
}