// There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

// For example,
// Given the following words in dictionary,

// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]
// The correct order is: "wertf".

// Note:
// You may assume all letters are in lowercase.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.

class AlienDictionary {
	private void getorder(String word1, String word2, Map<Character, Set<Character>> graph) {
		int len = Math.min(word1.length(), word2.length());
		for (int i = 0; i < len; i++) {
			char c1 = word1.charAt(i);
			char c2 = word2.charAt(i);

			if (c1 != c2) {
				if (!graph.get(c1).contains(c2)) {
					graph.get(c1).add(c2);
				}
				break;
			}
		}
	}

	private String topologicalsort(Map<Character, Set<Character>> graph) {
		Map<Character, Integer> indegree = new HashMap<>();
		for (char c1 : graph.keySet()) {
			for (char c2 : graph.get(c1)) {
				int num = indegree.containsKey(c2) ? indegree.get(c2) + 1 : 1;
				indegree.put(c2, num);
			}
		}

		Queue<Character> queue = new LinkedList<>();
		for (char c : graph.keySet()) {
			if (!indegree.containsKey(c)) {
				queue.offer(c);
			}
		}

		int count = 0;
		StringBuilder res = new StringBuilder();
		while(!queue.isEmpty()) {
			char c = queue.poll();
			res.append(c);
			count++;
			Set<Character> set = graph.get(c);
			if (set != null && set.size() > 0) {
				for (char c2 : set) {
					int num = indegree.get(c2);
					if (num == 1) {
						queue.offer(c2);
					} else {
						indegree.put(c2, num - 1);
					}
				}
			}
		}

		return count == graph.size() ? res.toString() : "";
	}

	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> graph = new HashMap<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				if (!graph.containsKey(words[i].charAt(j))) {
					graph.put(words[i].charAt(j), new HashSet<>());
				}
			}

			if (i > 0) {
				getorder(words[i - 1], words[i], graph);
			}
		}

		return topologicalsort(graph);
    }
}