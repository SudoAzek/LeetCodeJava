package problems;

import java.util.HashMap;
import java.util.HashSet;

public class P340_Longest_Substring_with_At_Most_K_Distinct_Characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longestSubStringLen = 1;
        HashSet<Character> seenLetters = new HashSet<>();
        seenLetters.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            while(seenLetters.contains(s.charAt(i))&& seenLetters.size() < k) {
                longestSubStringLen++;
            }

        }


        return longestSubStringLen;

    }
}
