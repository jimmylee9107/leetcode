// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.

// Return the sum = 12 + 13 = 25.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SumRoottoLeafNumbers {
	private int helper(TreeNode root, StringBuilder path) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return Integer.parseInt(path.toString() + root.val);
		}
		path.append(root.val);
		int left = helper(root.left, path);
		int right = helper(root.right, path);
		path.deleteCharAt(path.length() - 1);
		return left + right;
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return helper(root, new StringBuilder());
	}
}