// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PathSumII {
	private void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		if (root.left == null && root.right == null) {

			if (sum == root.val) {
				res.add(new LinkedList<>(path));
			}
			path.remove(path.size() - 1);
			return;

		}
		helper(res, path, root.left, sum - root.val);
		helper(res, path, root.right, sum - root.val);
		path.remove(path.size() - 1);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		helper(res, new LinkedList<>(), root, sum);
		return res;
    }
}