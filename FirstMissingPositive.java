class FirstMissingPositive {
// Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.

//Your algorithm should run in O(n) time and uses constant space.
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {
			while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
	    return nums.length + 1;
    }
}