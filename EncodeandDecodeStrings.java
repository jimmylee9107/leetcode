// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

// Machine 1 (sender) has the function:

// string encode(vector<string> strs) {
//   // ... your code
//   return encoded_string;
// }
// Machine 2 (receiver) has the function:
// vector<string> decode(string s) {
//   //... your code
//   return strs;
// }
// So Machine 1 does:

// string encoded_string = encode(strs);
// and Machine 2 does:

// vector<string> strs2 = decode(encoded_string);
// strs2 in Machine 2 should be the same as strs in Machine 1.

class EncodeandDecodeStrings {
	// Encodes a list of strings to a single string.
	// /escape 
    public String encode(List<String> strs) {
    	if (strs == null || strs.size() == 0) {
    		return "";
    	}

    	StringBuilder res = new StringBuilder();
    	for (String str : strs) {
    		res.append(str.length());
    		res.append('#');
    		res.append(str);
    	}
    	return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	List<String> res = new ArrayList<>();
    	if (s == null || s.length() == 0) {
    		return res;
    	}

    	int len = s.length();
    	int i = 0;
    	while(true) {
    		if (i >= len) {
    			break;
    		}

    		int start = i;
    		while(s.charAt(i) != '#') {
    			i++;
    		}

    		int l = Integer.parseInt(s.substring(start, i));
    		res.add(s.substring(i + 1, i + 1 + l));
    		i = i + 1 + l;

    	}
    	return res;
    }
}