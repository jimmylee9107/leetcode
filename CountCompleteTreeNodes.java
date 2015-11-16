class CountCompleteTreeNodes {
	/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.left == null && root.right == null ? 1 : height(root.left) + 1;
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int left = height(root.left);
		int right = height(root.right);
		if (left == right) {
			return (1 << left) + countNodes(root.right);
		} else {
			return (1 << right) + countNodes(root.left);
		}
	}
}