// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int[] output = new int[nums.length];
		output[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}

		int temp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			output[i] *= temp;
			temp *= nums[i];
		}
		return output;
    }
}