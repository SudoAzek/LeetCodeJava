package may_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D21_FindAndReplacePattern {
    public static void main(String[] args) {

    }
}

class FindAndReplacePatternSolution {
    List<String> answer;
    Map<Character, Character> codex;
    char[] cipher;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        answer = new ArrayList<>();
        codex = new HashMap<>();
        cipher = pattern.toCharArray();
        for (int i = 0; i < pattern.length(); i++) {
            cipher[i] = translate(cipher[i]);
        }
        for (String word : words) {
            compare(word);
        }
        return answer;
    }

    private char translate(char c) {
        if (!codex.containsKey(c))
            codex.put(c, (char) (97 + codex.size()));
        return codex.get(c);
    }

    private void compare(String word) {
        codex.clear();
        for (int i = 0; i < word.length(); i++) {
            if (translate(word.charAt(i)) != cipher[i]) return;
        }
        answer.add(word);
    }
}


class FindAndReplacePatternSolution1 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (getPatternMatch(words[i], pattern)) {
                result.add(words[i]);
            }
        }
        return result;
    }

    boolean getPatternMatch(String word, String pattern) {
        char[] arr = new char[26];
        char[] arr2 = new char[26];
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            int idx2 = pattern.charAt(i) - 'a';
            arr[idx] = pattern.charAt(i);
            arr2[idx2] = word.charAt(i);
        }
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            int idx2 = pattern.charAt(i) - 'a';
            if (arr[idx] != pattern.charAt(i)) {
                return false;
            } else if (arr2[idx2] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}