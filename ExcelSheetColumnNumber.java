// Related to question Excel Sheet Column Title

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 

class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int res = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			int num = s.charAt(i) - 'A' + 1;
			res = 26 * res + num;
		}
		return res;
    }
}