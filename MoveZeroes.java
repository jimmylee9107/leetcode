class MoveZeroes {
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int left = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, ++left, i);
			}
		}

		for (left = left + 1; left < nums.length; left++) {
			nums[left] = 0;
		}
    }
}