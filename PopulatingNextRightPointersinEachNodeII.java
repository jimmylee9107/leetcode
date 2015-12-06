// Follow up for problem "Populating Next Right Pointers in Each Node".

// What if the given tree could be any binary tree? Would your previous solution still work?

// Note:

// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
class PopulatingNextRightPointersinEachNodeII {
	private TreeLinkNode findnextroot(TreeLinkNode root) {
		while(root != null && root.left == null && root.right == null) {
			root = root.next;
		}
		return root;
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			} else {
				TreeLinkNode next = findnextroot(root.next);
				root.left.next = next == null ? null : next.left == null ? next.right : next.left;
			}
		}

		if (root.right != null) {
			TreeLinkNode next = findnextroot(root.next);
			root.right.next = next == null ? null : next.left == null ? next.right : next.left;
		}
		connect(root.right);
		connect(root.left);
    }
}