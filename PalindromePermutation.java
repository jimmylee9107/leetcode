// Given a string, determine if a permutation of the string could form a palindrome.

// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.

class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int[] source = new int[256];
		for (char c : s.toCharArray()) {
			source[c]++;
		}

		boolean visited = false;
		for (int i = 0; i < 256; i++) {
			if (source[i] % 2 == 0) {
				continue;
			}

			if (visited) {
				return false;
			}
			visited = true;
		}
		return true;
    }
}