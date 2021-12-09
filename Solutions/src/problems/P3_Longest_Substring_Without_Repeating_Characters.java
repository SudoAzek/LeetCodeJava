package problems;

import java.util.HashSet;

public class P3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        Solution_Longest_Substring_Without_Repeating_Characters sol = new Solution_Longest_Substring_Without_Repeating_Characters();
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));
    }
}

class Solution_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(set.add(chars[i])) {
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
