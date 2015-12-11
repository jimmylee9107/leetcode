// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 

class CombinationSumII {
	private void helper(List<List<Integer>> res, List<Integer> container, int[] candidates, boolean[] visited, int target, int offset) {
		if (target == 0) {
			res.add(new LinkedList<>(container));
			return;
		} else if (target < 0) {
			return;
		}

		for (int i = offset; i < candidates.length; i++) {
			if (visited[i]) {
				continue;
			}

			if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
				continue;
			}
			container.add(candidates[i]);
			visited[i] = true;
			helper(res, container, candidates, visited, target - candidates[i], i + 1);
			container.remove(container.size() - 1);
			visited[i] = false;
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		helper(res, new LinkedList<>(), candidates, target, 0);
		return res;
    }
}