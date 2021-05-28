package may_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class D27_MaximumProductOfWordLengths {
    public static void main(String[] args) {
        MaximumProductOfWordLengthsSolution solution = new MaximumProductOfWordLengthsSolution();
        System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}

class MaximumProductOfWordLengthsSolution {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bits[i] = bits[i] | 1 << (words[i].charAt(j) - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            for (int j = i + 1; j < bits.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }
}

class MaximumProductOfWordLengthsSolution1 {
    public int maxProduct(String[] words) {
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() * words[j].length() > maxProduct && !doShareCommonLetter(words[i], words[j])) {
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }
        return maxProduct;
    }

    private boolean doShareCommonLetter(String s1, String s2) {
        boolean[] s1LetterPresence = new boolean[26];
        for (int i = 0; i < s1.length(); i++) {
            s1LetterPresence[s1.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s1LetterPresence[s2.charAt(i) - 'a']) {
                return true;
            }
        }
        return false;
    }
}

class MaximumProductOfWordLengthsSolution2 {
    public int maxProduct(String[] words) {
        Map<String, int[]> stringMap = new HashMap<>();
        for (String word : words) {
            int[] chars = new int[26];
            for (char c : word.toCharArray()) {
                chars[c - 'a']++;
                stringMap.put(word, chars);
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!isMatchCharacters(stringMap.get(words[i]), stringMap.get(words[j]))) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private boolean isMatchCharacters(int[] firstWord, int[] secondWord) {
        for (int i = 0; i < 26; i++) {
            if (firstWord[i] != 0 && secondWord[i] != 0) {
                return true;
            }
        }
        return false;
    }
}