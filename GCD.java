class GCD {
	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}

	public int getGCD(int[] array) {
		if (array == null || array.length < 1) {
			return 0;
		}

		int gcd = array[0];
		for (int i = 1; i < array.length; i++) {
			gcd = gcd(gcd, array[i]);
		}
		return gcd;
	}
}