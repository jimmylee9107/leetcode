// Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

// Example:
// Given "bcabc"
// Return "abc"

// Given "cbacdcbc"
// Return "acdb"

class RemoveDuplicateLetters {
	//O(n)
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}

		int begin = 0;
		int end = findLastIndex(map);
		int size = map.size();
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < size; i++) {
			char minChar = 'z' + 1;
			int pos = -1;
			for (int k = begin; k <= end; k++) {
				if (map.containsKey(s.charAt(i)) && s.charAt(i) < minChar) {
					minChar = s.charAt(i);
					pos = k;
				}
			}

			begin = pos + 1;
			res.append(minChar);
			map.remove(minChar);
			if (i == size - 1) {
				break;
			}

			if (s.charAt(end) == minChar) {
				end = findLastIndex(map);
			}
		}

		return res.toString();
    }

    private int findLastIndex(Map<Character, Integer> map) {
    	if (map == null || map.size() == 0) {
    		return Integer.MAX_VALUE;
    	}

    	int min = Integer.MAX_VALUE;
    	for (int index : map.values()) {
    		min = Math.min(min, index);
    	}

    	return min;
    }

}