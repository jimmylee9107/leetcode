// Given a binary tree where all the right nodes are either leaf nodes 
// with a sibling (a left node that shares the same parent node) or empty, 
// flip it upside down and turn it into a tree where the original right nodes 
// turned into left leaf nodes. Return the new root.

// For example:
// Given a binary tree {1,2,3,4,5},
//     1
//    / \
//   2   3
//  / \
// 4   5
// return the root of the binary tree [4,5,2,#,#,3,1].
//    4
//   / \
//  5   2
//     / \
//    3   1  
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
class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode prev = null;
		TreeNode right = null;
		TreeNode cur = root;
		while(cur != null) {
			TreeNode temp1 = cur.left;
			TreeNode temp2 = cur.right;
			cur.left = right;
			cur.right = prev;

			prev = cur;
			right = temp2;
			cur = temp1;
		}
		return prev;
    }
}