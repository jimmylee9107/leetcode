// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

// Note that 1 is typically treated as an ugly number.

class UglyNumberII {
	public int nthUglyNumber(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] ugly = new int[n];
		ugly[0] = 1;
		int two = 0;
		int three = 0;
		int five = 0;
		for (int i = 1; i < n; i++) {
			int temp = Math.min(ugly[two] * 2, Math.min(ugly[three] * 3, ugly[five] * 5));
			ugly[i] = temp;
			if (temp % 2 == 0) {
				two++;
			}
			if (temp % 3 == 0) {
				three++;
			}
			if (temp % 5 == 0) {
				five++;
			}
		}
		return ugly[n - 1];
    }
}