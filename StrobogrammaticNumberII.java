// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Find all strobogrammatic numbers that are of length = n.

// For example,
// Given n = 2, return ["11","69","88","96"].

class StrobogrammaticNumberII {
	private List<String> helper(int i, int n) {
		if (i == 0) {
			return Arrays.asList("");
		}

		if (i == 1) {
			return Arrays.asList("0", "1", "8");
		}

		List<String> prev = helper(i - 2, n);
		List<String> res = new LinkedList<String>();
		for (String num : prev) {
			if (i != n) {
				res.add("0" + num + "0");
			}
			res.add("1" + num + "1");
			res.add("8" + num + "8");
			res.add("6" + num + "9");
			res.add("9" + num + "6");
		}
		return res;
	}

	public List<String> findStrobogrammatic(int n) {
		return helper(n, n);
    }
}