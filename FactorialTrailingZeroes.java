// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.

class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		if (n <= 0) {
			return 0;
		}

		long base = 5;
		int count = 0;
		while(n / base > 0) {
			count += n / base;
			base *= 5;
		}
		return count;
    }
}