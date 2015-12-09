// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class ConstructBinaryTreefromInorderandPostorderTraversal {
	private int getIndex(int[] nums, int val) {
		for (int i = 0; i < nums.length; i++) {
			if (val == nums[i]) {
				return i;
			}
		}
		return -1;
	}

	private TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
		if (i_start > i_end) {
			return null;
		}

		int root_val = postorder[p_end];
		int index = getIndex(inorder, root_val);
		TreeNode root = new TreeNode(root_val); 
		root.left = helper(inorder, i_start, index - 1, postorder, p_start, p_start + index - i_start - 1);
		root.right = helper(inorder, index + 1, i_end, postorder, p_end - (i_end - index), p_end - 1);
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}

		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}