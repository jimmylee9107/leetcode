class DaysChange {
	public int[] daychange(int[] array, int days) {
		if (array == null || array.length == 0 || days == 0) {
			return array;
		}

		int[] res = new int[array.length + 2];
		int prev = res[0];
		for (int i = 1; i <= array.length; i++) {
			res[i] = array[i - 1];
		}

		for (int i = 0; i < days; i++) {
			for (int j = 1; j <= array.length; j++) {
				int temp = res[i];
				res[i] = prev ^ res[i + 1];
				prev = temp;
			}
		}
		return Arrays.copyOfRange(res, 1, array.length + 1);
	}
}