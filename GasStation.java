class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
			return -1;
		}

		int sum = 0;
		int temp = 0;
		int res = 0;
		int len = gas.length;
		for (int i = 0; i < len; i++) {
			sum += gas[i] - cost[i];
			temp += gas[i] - cost[i];
			if (temp < 0) {
				res = i + 1;
				temp = 0;
			}
		}

		return sum >= 0 ? res : -1;
    }
}