// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

// You may assume each number in the sequence is unique.

// Follow up:
// Could you do it using only constant space complexity?

class VerifyPreorderSequenceinBinarySearchTree {
	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length <= 1) {
			return true;
		}

		int index = -1;
		int low = Integer.MIN_VALUE;
		for (int p : preorder) {
			if (low > p) {
				return false;
			}

			while(index >= 0 && preorder[index] < p) {
				low = preorder[index--];
			}
			preorder[++index] = p;
		}
		return true;
    }
}