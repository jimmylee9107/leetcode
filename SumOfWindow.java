class SumOfWindow {
	public int[] getSumOfWindow(int[] array, int k) {
		if (array == null || array.length < k || k <= 0) {
			return null;
		}

		int[] res = new int[array.length - k + 1];
		int index = 0;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (i >= k - 1) {
				res[index++] = sum;
				sum -= array[i - k + 1];
			}
		}
		return res;
	}
}