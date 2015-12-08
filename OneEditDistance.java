//Given two strings S and T, determine if they are both one edit distance apart.

class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) >= 2) {
            return false;
        }
        
        int index1 = 0;
        int index2 = 0;
        while(index1 < s.length() && index2 < t.length()) {
            if (s.charAt(index1) != t.charAt(index2)) {
                if (s.substring(index1 + 1).equals(t.substring(index2 + 1))) {
                    return true;
                }
                if (s.substring(index1 + 1).equals(t.substring(index2))) {
                    return true;
                }
                if (s.substring(index1).equals(t.substring(index2 + 1))) {
                    return true;
                } 
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }
}