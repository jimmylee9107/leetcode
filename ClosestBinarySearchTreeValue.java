// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		double min = Double.MAX_VALUE;
		int val = -1;
		while(!stack.isEmpty() || cur != null) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			TreeNode temp = stack.pop();
			if (temp.right != null) {
				cur = temp.right;
			}
			double diff = Math.abs(temp.val - target);
			if (diff < min) {
				min = diff;
				val = temp.val;
			} else {
				return val;
			}
		}
		return val;
    }

    private int helper(TreeNode root, double target, int prev, double min) {
    	if (root == null) {
    		return prev;
    	}

    	double diff = Math.abs(root.val - target);
    	if (root.val > target) {
    		if (diff < min) {
    			return helper(root.left, target, root.val, diff);
    		} else {
    			return helper(root.left, target, prev, min);
    		}
    	} else {
    		if (diff < min) {
    			return helper(root.right, target, root.val, diff);
    		} else {
    			return helper(root.right, target, prev, min);
    		}    		
    	}
    }

    public int closestValue(TreeNode root, double target) {
    	return helper(root, target, -1, Double.MAX_VALUE);
    }

}