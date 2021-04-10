package april_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class D09_VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        VerifyingAnAlienDictionarySolution solution = new VerifyingAnAlienDictionarySolution();
        System.out.println(solution.isAlienSorted(new String[] {"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
    }
}

class VerifyingAnAlienDictionarySolution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            alpha.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1], b = words[i];
            for (int j = 0; j < a.length(); j++) {
                if (j == b.length()) return false;
                char aChar = a.charAt(j), bChar = b.charAt(j);
                if (alpha.get(aChar) < alpha.get(bChar)) break;
                if (alpha.get(aChar) > alpha.get(bChar)) return false;
            }
        }
        return true;
    }
}


class D09_VerifyingAnAlienDictionary2 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!compareTwoWords(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean compareTwoWords(String word1, String word2, int[] orderMap) {
        for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
            // If we do not find a mismatch letter between words[i] and words[i + 1],
            // we need to examine the case when words are like ("apple", "app").
            int currentWordChar = word1.charAt(j) - 'a';
            int nextWordChar = word2.charAt(j) - 'a';
            if (currentWordChar == nextWordChar) {
                continue;
            }

            return orderMap[word1.charAt(j) - 'a'] < orderMap[word2.charAt(j) - 'a'];

        }
        return word1.length() <= word2.length();
    }
}