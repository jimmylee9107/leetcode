// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length();
		int[] f = new int[len + 1];
		f[0] = 1;
		f[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= len; i++) {
			int num = Integer.parseInt(s.substring(i - 2, i));
			int twostepbehind = num >= 10 && num <= 26 ? f[i - 2] : 0;
			int onestepbehind = Integer.parseInt(s.substring(i - 1, i)) != 0 ? f[i - 1] : 0;
			f[i] = twostepbehind + onestepbehind; 
		}
		return f[len];
    }
}