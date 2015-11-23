// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

// Note:
// The read function will only be called once for each test case.

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

class ReadNCharactersGivenRead4 {
 /**
 * @param buf Destination buffer
 * @param n   Maximum number of characters to read
 * @return    The number of characters read
 */
    public int read(char[] buf, int n) {
    	int count = 0;
    	int readnum = 4;
    	char[] buffer = new char[4];
    	while(count < n && readnum == 4) {
    		readnum = read4(buffer);
    		if (readnum > n - count) {
    			System.arraycopy(buffer, 0, buf, count, n - count);
    			return n;
    		}
    		System.arraycopy(buffer, 0, buf, count, readnum);
    		count += readnum;
    	}
    	return count;
    }
}