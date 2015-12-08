// There is a fence with n posts, each post can be painted with one of the k colors.

// You have to paint all the posts such that no more than two adjacent fence posts have the same color.

// Return the total number of ways you can paint the fence.

// Note:
// n and k are non-negative integers.

class PaintFence {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}

		int[] f1 = new int[n];
		int[] f2 = new int[n];
		f1[0] = k;
		f2[0] = 0;
		for (int i = 1; i < n; i++) {
			f1[i] = f2[i - 1] * (k - 1) + f1[i - 1] * (k - 1);
			f2[i] = f1[i - 1];
		}
		return f1[n - 1] + f2[n - 1];
    }
}