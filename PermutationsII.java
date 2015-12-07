// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

class PermutationsII {
	private void helper(List<List<Integer>> res, List<Integer> container, boolean[] visited, int[] nums) {
		if (container.size() == nums.length) {
			res.add(new LinkedList<>(container));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}

			if (i != 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
				continue;
			}

			container.add(nums[i]);
			visited[i] = true;
			helper(res, container, visited, nums);
			container.remove(container.size() - 1);
			visited[i] = false;
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);
		helper(res, new LinkedList<>(), new boolean[nums.length], nums);
		return res;
    }
}