class SubTree {
	private boolean isSameTreeHelper(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}

		return isSameTreeHelper(p.left, q.left) && isSameTreeHelper(p.right, q.right);
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (q == null) {
			return true;
		}

		if (p == null) {
			return false;
		}

		return isSameTree(p.left, q) || isSameTree(p.right, q) || isSameTreeHelper(p, q);
	}
}