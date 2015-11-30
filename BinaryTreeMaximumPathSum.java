// Given a binary tree, find the maximum path sum.

// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

// For example:
// Given the below binary tree,

//        1
//       / \
//      2   3
// Return 6.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeMaximumPathSum {
	class ReturnType {
		int maxsum;
		int pathsum;
		ReturnType(int maxsum, int pathsum) {
			this.maxsum = maxsum;
			this.pathsum = pathsum;
		}
	}

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root).maxsum;
	}

	public ReturnType helper(TreeNode root) {
		if (root == null) {
			return new ReturnType(Integer.MIN_VALUE, 0);
		}

		ReturnType left = helper(root.left);
		ReturnType right = helper(root.right);
		int pathsum = Math.max(0, Math.max(left.pathsum, right.pathsum) + root.val);
		int maxsum = Math.max(left.maxsum, Math.max(right.maxsum, left.pathsum + right.pathsum + root.val));
		return new ReturnType(maxsum, pathsum);
    }
}