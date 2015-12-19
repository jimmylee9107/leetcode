// This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

// Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

class ShortestWordDistanceII {
	private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
        	if (!map.containsKey(words[i])) {
        		map.put(words[i], new ArrayList<>());
        	}
        	map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int i1 = 0;
        int len1 = list1.size();
        int i2 = 0;
        int len2 = list2.size();
        int min = Integer.MAX_VALUE;
        while(i1 < len1 && i2 < len2) {
        	int a = list1.get(i1);
        	int b = list2.get(i2);
        	min = Math.min(min, Math.abs(a - b));
        	if (a > b) {
        		i2++;
        	} else {
        		i1++;
        	}
        }
        return min;
    }
}