// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			}
		}

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) != 0) {
				int count = 1;
				map.put(nums[i], 0);

				//try less than
				int num = nums[i];
				while(map.containsKey(--num)) {
					map.put(num, 0);
					count++;
				}

				//try higher than
				num = nums[i];
				while(map.containsKey(++num)) {
					map.put(num, 0);
					count++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
    }
}