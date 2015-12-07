// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?

class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		int[] source = new int[26];
		int[] target = new int[26];

		for (char c : s.toCharArray()) {
			source[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			target[c - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (source[i] != target[i]) {
				return false;
			}
		}
		return true;
    }
}
