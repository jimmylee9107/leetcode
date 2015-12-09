// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?

// confused what "{1,#,2,3}" means?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		if (root == null) {
			return res;
		}

		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || cur != null) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			TreeNode temp = stack.pop();
			if (temp.right != null) {
				cur = temp.right;
			}
			res.add(temp.val);
		}
		return res;
    }
}