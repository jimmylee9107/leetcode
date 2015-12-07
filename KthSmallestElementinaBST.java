// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class KthSmallestElementinaBST {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		int count = 0;
		while(!stack.isEmpty() || cur != null) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			count++;
			TreeNode temp = stack.pop();
			if (count == k) {
				return temp.val;
			}
			if (temp.right != null) {
				cur = temp.right;
			}
		}
		return Integer.MAX_VALUE;
    }
}