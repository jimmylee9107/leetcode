// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

// For example,
// Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

// Note:
// Because the range might be a large number, the low and high numbers are represented as string.

class StrobogrammaticNumberIII {
	private List<String> getlist(int i, int n) {
		if (i == 0) {
			return Arrays.asList("");
		}
		if (i == 1) {
			return Arrays.asList("0", "1", "8");
		}
		
		List<String> list = getlist(n - 2, n);
		List<String> res = new ArrayList<String>();
		for (String num : list) {
			if (i != n) {
				res.add("0" + num + "0");
			}
			res.add("1" + num + "1");
			res.add("6" + num + "9");
			res.add("9" + num + "6");
			res.add("8" + num + "8");
		}
		return res;
	}

	public int strobogrammaticInRange(String low, String high) {
		if (low == null || high == null || high.length() == 0 || low.length() == 0) {
			return 0;
		}

		int count = 0;
		List<String> list = new ArrayList<String>();
		for (int i = low.length(); i <= high.length(); i++) {
			list.addAll(getlist(i,i));
		}

		for (String num : list) {
			if (num.length() == low.length() && num.compareTo(low) < 0 || num.length() == high.length() && num.compareTo(high) > 0) {
				continue;
			}
			count++;
		}
		return count;
    }
}