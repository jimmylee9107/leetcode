//Count the number of prime numbers less than a non-negative number, n.


class CountPrimes {
	public int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}

		boolean isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if (isPrime[i]) {
				for (int k = (n - 1) / i, j = i * k; k >= i; k--, j -= i) {
					if (isPrime[j]) {
						isPrime[j] = false;
					}
				}
			}
		}

		int res = 1;
		for (int i = 3; i < n; i++) {
			if (isPrime[i]) {
				res++;
			}
		}
		return res;
    }
}