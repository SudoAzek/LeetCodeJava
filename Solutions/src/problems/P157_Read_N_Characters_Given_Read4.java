package problems;

public class P157_Read_N_Characters_Given_Read4 {
    public static void main(String[] args) {

    }
}


/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

//public class Solution extends Reader4 {
//    /**
//     * @param buf Destination buffer
//     * @param n   Number of characters to read
//     * @return    The number of actual characters read
//     */
//    public int read(char[] buf, int n) {
//        int copiedChars = 0, readChars = 4;
//        char[] buf4 = new char[4];
//
//        while (copiedChars < n && readChars == 4) {
//            readChars = read4(buf4);
//
//            for (int i = 0; i < readChars; ++i) {
//                if (copiedChars == n) return copiedChars;
//                buf[copiedChars] = buf4[i];
//                ++copiedChars;
//            }
//        }
//        return copiedChars;
//    }
//}