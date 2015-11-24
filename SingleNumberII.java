// Given an array of integers, every element appears three times except for one. Find that single one.


class SingleNumberII {
	public int singleNumber(int[] nums) {
		int[] bits = new int[32];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < 32; j++) {
				if (((nums[i] >> j) & 1) == 1) {
					bits[j]++;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < 32; i++) {
			if (bits[i] % 3 == 1) {
				res += (1 << i);
			}
		}
		return res;
    }
}