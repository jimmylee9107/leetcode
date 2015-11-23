// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.


class ReverseWordsinaString {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
        	return s;
        }

        StringBuilder res = new StringBuilder();
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
        			res.append(temp.reverse());
        			res.append(' ');
        			temp = new StringBuilder();
        		} else {
        			temp.append(s.charAt(i));
        		}
        	}
        }

        if (temp.length() > 0) {
        	res.append(temp.reverse());
        	res.append(' ');
        }

        return res.length() > 1 ? res.substring(0, res.length() - 1) : "";
    }
}