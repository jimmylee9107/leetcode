// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:
// For the return value, each inner list's elements must follow the lexicographic order.
// All inputs will be in lower-case.
class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new LinkedList<>();
		if (strs == null || strs.length == 0) {
			return res;
		}
		Arrays.sort(strs);
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] key = str.toCharArray();
			Arrays.sort(key);
			String keyStr = String.valueOf(key);

			List<String> list = map.get(keyStr);
			if (list == null) {
				list = new LinkedList<String>();
				map.put(keyStr, list);
			}

			list.add(str);
		}
		res.addAll(map.values());
		return res;
    }
}