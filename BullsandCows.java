// For example:

// Secret number:  "1807"
// Friend's guess: "7810"
// Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
// Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

// Please note that both secret number and friend's guess may contain duplicate digits, for example:

// Secret number:  "1123"
// Friend's guess: "0111"
// In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
// You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.


class BullsandCows {
	public String getHint(String secret, String guess) {
		if (secret == null || guess == null || secret.length() == 0 || guess.length() == 0 || secret.length() != guess.length()) {
			return "";
		}

		int[] secret_hash = new int[10];
		for (char num : secret.toCharArray()) {
			secret_hash[num - '0']++;
		}

		StringBuilder res = new StringBuilder();
		int a = 0;
		int b = 0;
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				a++;
			}

			if (secret_hash[guess.charAt(i) - '0'] > 0) {
				secret_hash[guess.charAt(i) - '0']--;
				b++;
			}
		}

		
		res.append(a);
		res.append('A');
		res.append(b - a);
		res.append('B');
		
		return res.toString();
    }
}