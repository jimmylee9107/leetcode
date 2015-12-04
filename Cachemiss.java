class Cachemiss {
	public int countmiss(int[] array, int size) {
		if (array == null) {
			return 0;
		}

		List<Integer> cache = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (cache.contains(array[i])) {
				cache.remove(new Integer(array[i]));
			} else {
				count++;
				if (cache.size() == size) {
					cache.remove(0);
				}
			}
			cache.add(array[i]);
		}
		return count;
	}
}