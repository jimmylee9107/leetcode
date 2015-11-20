// Given a positive integer, return its corresponding column title as appear in an Excel sheet.

// For example:

// 1 -> A
// 2 -> B
// 3 -> C
// ...
// 26 -> Z
// 27 -> AA
// 28 -> AB 

class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}

		StringBuilder res = new StringBuilder();
		while(n > 0) {
			n--;
			int index = n % 26;
			n /= 26;
			char num = (char)('A' + index);
			res.append(num);
		}

		return res.reverse().toString();
    }
}