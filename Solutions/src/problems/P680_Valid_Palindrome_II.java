package problems;

public class P680_Valid_Palindrome_II {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abcxa"));
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return checkPalindrome(s, i, j -1) || checkPalindrome(s, i + 1, j);
            }
            ++i;
            --j;
        }
        return true;
    }

    static boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }

        return true;
    }
}
