class ArithmeticSlice {
	public int countArithmeticSlices(int[] array) {
		if (array == null || array.length <= 2) {
			return 0;
		}

		int gap = array[1] - array[0];
		int len = 2;
		int res = 0;
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] == gap) {
				len++;
			} else {
				res += (len - 1) * (len - 2) / 2;
				if (res > 1000000000) {
					return -1;
				}
				gap = array[i + 1] - array[i];
				len = 2;
			}
		}

		if (len >= 3) {
			res += (len - 1) * (len - 2) / 2;
		}
		return res > 1000000000 ? -1 : res;
	}
}