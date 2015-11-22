// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
class PerfectSquares {
	public int numSquares(int n) {
		if (n == 0) {
			return 0;
		}

		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = Math.sqrt(i); j > 0; j--) {
				f[i] = Math.min(f[j] + f[i - j * j], f[i]);
			}
		} 
		return f[n];
    }
}