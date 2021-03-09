package march_daily_challenge;

public class D08_RemovePalindromicSubsequences {
    public static void main(String[] args) {
        RemovePalindromicSubsequencesSolution2 sol = new RemovePalindromicSubsequencesSolution2();
        System.out.println(sol.removePalindromeSub(""));
    }
}

class RemovePalindromicSubsequencesSolution {
    public int removePalindromeSub(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        for (int i = 0, j = chars.length - 1; i < j; i++, j--)
            if (chars[i] != chars[j]) return 2;
        return 1;
    }
}

class RemovePalindromicSubsequencesSolution1 {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // See below for code that compacts this into one line.
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reversedString = sb.toString();
        if (reversedString.equals(s)) {
            return 1;
        }
        return 2;
    }
}

class RemovePalindromicSubsequencesSolution2 {
    private boolean isPalindrome;

    boolean isPalindrome(char[] chars) {
        for (int i = 0, j = chars.length - 1; i < chars.length / 2 && j > chars.length / 2; i++, j--) {
            if (chars[i] == chars[j]) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public int removePalindromeSub(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        else if (isPalindrome(chars)) return 1;
        else return 2;
    }
}