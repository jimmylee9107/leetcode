// Given a collection of numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

class Permutations {
	private void helper(List<List<Integer>> res, List<Integer> container, boolean[] visited, int[] nums) {
		if (container.size() == nums.length) {
			res.add(new LinkedList<Integer>(container));
			return;
		}

		for(int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			container.add(nums[i]);
			helper(res, container, visited, nums);
			visited[i] = false;
			container.remove(container.size() - 1);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		helper(res, new LinkedList<>(), new boolean[nums.length], nums);
		return res;
    }
}