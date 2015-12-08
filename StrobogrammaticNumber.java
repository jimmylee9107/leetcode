// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to determine if a number is strobogrammatic. The number is represented as a string.

// For example, the numbers "69", "88", and "818" are all strobogrammatic.

class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) {
			return true;
		}
		
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('8', '8');
		map.put('1', '1');
		map.put('6', '9');
		map.put('9', '6');

		int start = 0;
		int end = num.length() - 1;
		while(start < end) {
			if (!map.containsKey(num.charAt(start)) || map.get(num.charAt(start)) != num.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return start == end ? num.charAt(start) == '0' || num.charAt(start) == '8' || num.charAt(start) == '1' : true;
    }
}