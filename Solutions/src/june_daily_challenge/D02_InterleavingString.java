package june_daily_challenge;

public class D02_InterleavingString {
    public static void main(String[] args) {
        InterleavingStringSolution1 solution = new InterleavingStringSolution1();
        System.out.println(solution.isInterleave("abc", "bcd", "abcbdc"));
    }
}

class InterleavingStringSolution1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return is_Interleave(s1, 0, s2, 0, "", s3);
    }

    public boolean is_Interleave(String s1, int i, String s2, int j, String res, String s3) {
        if (res.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        boolean answer = false;
        if (i < s1.length())
            answer |= is_Interleave(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length())
            answer |= is_Interleave(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return answer;
    }
}

class InterleavingStringSolution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[] dp = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}

class InterleavingStringSolution3 {
    boolean[][] cache; // defaults to false, true means invalid

    public boolean isInterleave(String s1, String s2, String s3) {
        cache = new boolean[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length())
            return false;
        return DFS(s1, s2, s3, 0, 0, 0);
    }

    boolean DFS(String s1, String s2, String s3, int i, int j, int k) {
        if (cache[i][j])
            return false;
        if (k == s3.length())
            return true;
        boolean valid =
                i < s1.length() && s1.charAt(i) == s3.charAt(k) && DFS(s1, s2, s3, i + 1, j, k + 1) ||
                        j < s2.length() && s2.charAt(j) == s3.charAt(k) && DFS(s1, s2, s3, i, j + 1, k + 1);
        if (!valid)
            cache[i][j] = true;

        return valid;
    }
}