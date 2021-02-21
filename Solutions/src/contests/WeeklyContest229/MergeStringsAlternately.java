package contests.WeeklyContest229;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abc";
        String s2 = "pqr";
        System.out.println(solution.mergeAlternately(s1, s2));
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < word1.length() || i < word2.length() ; i++) {
            if(i < word1.length()) res.append(word1.charAt(i));
            if(i < word2.length()) res.append(word2.charAt(i));
        }
        return res.toString();
    }
}