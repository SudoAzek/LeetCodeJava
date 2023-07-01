package problems;

import java.util.HashSet;
import java.util.Set;

public class P3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        Solution_Longest_Substring_Without_Repeating_Characters sol = new Solution_Longest_Substring_Without_Repeating_Characters();
        Solution_Longest_Substring_Without_Repeating_Characters1 sol1 = new Solution_Longest_Substring_Without_Repeating_Characters1();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol1.lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (set.add(chars[i])) {
                count++;
            } else {
                count = 0;
                set.clear();
                set.add(chars[i]);
                count++;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}


class Solution_Longest_Substring_Without_Repeating_Characters1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
    private boolean checkRepetition(String s, int start, int end) {
        Set<Character> chars = new HashSet<>();

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (chars.contains(c)) {
                return false;
            }
            chars.add(c);
        }
        return true;
    }
}