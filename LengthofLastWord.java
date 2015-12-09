// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// For example, 
// Given s = "Hello World",
// return 5.

class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		StringBuilder temp = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (temp.length() == 0) {
				if (s.charAt(i) == ' ') {
					continue;
				} else {
					temp.append(s.charAt(i));
				}
			} else {
				if (s.charAt(i) == ' ') {
					break;
				} else {
					temp.append(s.charAt(i));
				}
			}
		}
		return temp.length();
    }
}