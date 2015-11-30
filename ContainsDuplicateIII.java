//Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		if (k < 1 || t < 0) {
			return false;
		}
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long index = ((long)nums[i] - Integer.MIN_VALUE);
			long bucket = index / ((long)t + 1);
			if (map.containsKey(bucket) ||
				map.containsKey(bucket - 1) && index - map.get(bucket - 1) <= t||
				map.containsKey(bucket + 1) && map.get(bucket + 1) - index <= t) {
				return true;
			}
			map.put(bucket, index);
			if (map.size() > k) {
				long removeindex = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
				map.remove(removeindex);
			} 
		}
		return false;
	}	
}