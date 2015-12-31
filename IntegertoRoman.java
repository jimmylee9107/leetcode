// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.

// I	1
// V	5
// X	10
// L	50
// C	100
// D	500
// M	1,000

class IntegertoRoman {
	private final int[] base = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	private final String[] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	public String intToRoman(int num) {
		if (num <= 0) {
			return "";
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < base.length; i++) {
			int count = num / base[i];
			num -= count * base[i];
			for (; count > 0; count--) {
				res.append(sym[i]);
			}
		}
		return res.toString();
    }
}