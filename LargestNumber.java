class LargestNumber {
	private String checkzero(StringBuilder res) {
		if (res == null || res.length() == 0) {
			return "0";
		}
		int i;
		for (i = 0; i < res.length(); i++) {
			if (res.charAt(i) != '0') {
				break;
			}
		}

		if (i == res.length()) {
			return "0";
		}

		return res.substring(i, res.length());
	}
	
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "0";
		}

		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Comparator<String> cmp = (a, b) -> (a + b).compareTo(b + a);
		Arrays.sort(strs, cmp);
		StringBuilder res = new StringBuilder();
		for (int i = nums.length - 1; i >= 0; i--) {
			res.append(strs[i]);
		}

		return checkzero(res);
    }
}