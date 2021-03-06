
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

// Note:
// The read function may be called multiple times.

class ReadNCharactersGivenRead4II {
/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	private int len = 0;
    private int offset = 0;
    private char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int count = Math.min(n, len - offset);
        System.arraycopy(buffer, offset, buf, 0, count);
        offset += count;
        int readnum = 4;
        while(n > count && readnum == 4) {
            readnum = len = read4(buffer);
            offset = Math.min(n - count, readnum);
            System.arraycopy(buffer, 0, buf, count, offset);
            count += offset;
        }
        return count;
    }
}