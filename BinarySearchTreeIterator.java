// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinarySearchTreeIterator {
	private TreeNode cur;
	private Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		this.cur = root;
		this.stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }

        TreeNode temp = stack.pop();
        if (temp.right != null) {
        	cur = temp.right;
        }
        return temp.val;
    }
}