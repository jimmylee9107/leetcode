// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.

class JumpGame {
	//O(n ^ 2) too slow
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}

		int n = nums.length;
		boolean[] f = new boolean[n];
		f[0] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && j + nums[j] >= i) {
					f[i] = true;
					break;
				}
			}
		}

		return f[n - 1];
    }

    //O(n) 
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}

		int r = nums[0];
		int i;
		for (i = 0; i < nums.length; i++) {
			if (i > r) {
				break;
			}

			if (i + nums[i] > r) {
				r = i + nums[i];
			}
		}

		return i == nums.length;
	}
}