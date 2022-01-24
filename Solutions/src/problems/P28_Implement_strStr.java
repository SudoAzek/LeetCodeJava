package problems;

public class P28_Implement_strStr {
    public static void main(String[] args) {

    }

    public static int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (haystackLen < needleLen) return -1;
        else if (haystackLen == 0) return 0;

        int threshold = haystackLen - needleLen;
        for (int i = 0; i <= threshold; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
