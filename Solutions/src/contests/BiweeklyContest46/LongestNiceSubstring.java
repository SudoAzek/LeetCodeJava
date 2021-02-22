package contests.BiweeklyContest46;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        LongestNiceSubstringSolution sol = new LongestNiceSubstringSolution();
        System.out.println(sol.longestNiceSubstring("YazaAay"));
    }
}


class LongestNiceSubstringSolution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] charArr = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char c : charArr) set.add(c);

        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String subA = longestNiceSubstring(s.substring(0, i));
            String subB = longestNiceSubstring(s.substring(i + 1));
            return subA.length() >= subB.length() ? subA : subB;
        }
        return s;
    }
}


class LongestNiceSubstringSolution_1 {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int[] ans = new int[]{-1, -2};
        for (int i = 0; i < n; i++) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') lower |= 1 << (c - 'a');
                else upper |= 1 << (c - 'A');
                int diff = Integer.bitCount(lower ^ upper);
                if (diff == 0 && j - i > ans[1] - ans[0]) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}


class LongestNiceSubstringSolution_2 {
    public boolean isNice(String s, int l, int r) {
        for (char c = 'A'; c <= 'Z'; c++) {
            boolean lower = false;
            boolean upper = false;
            for (int i = l; i <= r; i++) {
                char x = s.charAt(i);
                upper |= x == c;
                lower |= x == c - 'A' + 'a';
            }
            if (lower != upper) {
                return false;
            }
        }
        return true;
    }

    public String longestNiceSubstring(String s) {
        int n = s.length();
        String best = "";
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                if (isNice(s, l, r) && r - l + 1 > best.length()) {
                    best = s.substring(l, r + 1);
                }
            }
        }
        return best;
    }
}

// WRONG!
class LongestNiceSubstringSolution_3 {
    public String longestNiceSubstring(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Boolean flag = false;
        int start = 0;
        int end = 0;
        for (int i = 1; i < charArr.length; i++) {
            if ((int) charArr[i - 1] + 32 == (int) charArr[i] || (int) charArr[i - 1] == (int) charArr[i] + 32) {
                start = i - 1;
                end = i;
                sb.append(charArr[start]);
                flag = true;
            } else if (flag) {
                break;
            }
        }
        sb.append(charArr[end]);
        if (sb.toString().length() < 2) {
            return "";
        } else {

            return sb.toString();
        }
    }
}