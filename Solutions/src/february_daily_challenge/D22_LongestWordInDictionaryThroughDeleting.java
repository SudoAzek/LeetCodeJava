package february_daily_challenge;

import java.util.Arrays;
import java.util.List;

public class D22_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeletingSolution sol = new LongestWordInDictionaryThroughDeletingSolution();
        System.out.println(sol.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}

class LongestWordInDictionaryThroughDeletingSolution {
    public String findLongestWord(String s, List<String> d) {

        String res = "";
        for (String c : d)
            if ((c.length() > res.length() || c.length() == res.length() && c.compareTo(res) < 0) && isSubsequence(c, s))
                res = c;
        return res;
    }

    public boolean isSubsequence(String a, String b) {
        int j = -1;
        for (int i = 0; i < a.length(); i++) {
            j = b.indexOf(a.charAt(i), j + 1);
            if (j == -1) {
                return false;
            }
        }
        return true;
    }
}

class LongestWordInDictionaryThroughDeletingSolution_1 {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String str : d) {
            int index = -1;
            char[] chars = str.toCharArray();
            for (char c : chars) {
                index = s.indexOf(c, index + 1);
                if (index == -1) break;
            }
            if (index == -1) continue;
            if (str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 0)) {
                result = str;
            }
        }
        return result;
    }
}
