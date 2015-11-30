// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

class RemoveDuplicatesfromSortedArrayII {
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = 1;
		int prev = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (prev == nums[i]) {
				count++;
				if (count <= 2) {
					swap(nums, res++, i);
				}
			} else {
				prev = nums[i];
				count = 1;
				swap(nums, res++, i);
			}
		}
		return res;
    }
}