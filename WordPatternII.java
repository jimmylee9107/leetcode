// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

// Examples:
// pattern = "abab", str = "redblueredblue" should return true.
// pattern = "aaaa", str = "asdasdasdasd" should return true.
// pattern = "aabb", str = "xyzabcxzyabc" should return false.
// Notes:
// You may assume both pattern and str contains only lowercase letters.
class WordPatternII {
	private boolean helper(String pattern, String str, Map<Character, String> map, Set<String> dict, int p, int index) {
		if (index == str.length() || p == pattern.length()) {
			return index == str.length() && p == pattern.length();
		}

		boolean found = false;
		if (!map.containsKey(pattern.charAt(p))) {
			for (int i = index + 1; i <= str.length(); i++) {
				String temp = str.substring(index, i);
				if (dict.contains(temp)) {
					continue;
				}
				map.put(pattern.charAt(p), temp);
				dict.add(temp);
				if (helper(pattern, str, map, dict, p + 1, i)) {
					return true;
				}
				dict.remove(temp);
				map.remove(pattern.charAt(p));
			}
		} else {
			for (int i = index + 1; i <= str.length(); i++) {
				String temp = str.substring(index, i);
				if (!temp.equals(map.get(pattern.charAt(p)))) {
					continue;
				}
				if (helper(pattern, str, map, dict, p + 1, i)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern == null || str == null || pattern.length() > str.length()) {
			return false;
		}  

		return helper(pattern, str, new HashMap<Character, String>(), new HashSet<String>(), 0, 0);		
    }
}