package problems;

import java.util.HashSet;
import java.util.Set;

public class P1832_Check_if_the_Sentence_Is_Pangram {
    public static void main(String[] args) {

    }
}

class Solution_Check_if_the_Sentence_Is_Pangram {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        Set<Character> appeared = new HashSet<>();
        char[] charString = sentence.toCharArray();
        for (Character ch : charString) {
            appeared.add(ch);
        }
        return appeared.size() == 26;
    }
}

class Solution_Check_if_the_Sentence_Is_Pangram2 {
    public boolean checkIfPangram(String sentence) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < a.length(); i++) {
            if (!sentence.contains(Character.toString(a.charAt(i))))
                return false;
        }
        return true;

    }
}

class SoSolution_Check_if_the_Sentence_Is_Pangram_1space {
    public boolean checkIfPangram(String sentence) {
        int seen = 0;
        for (char c : sentence.toCharArray()) {
            int ci = c - 'a';
            seen = seen | (1 << ci);
        }
        return seen == ((1 << 26) - 1);
    }
}

class Solution_Check_if_the_Sentence_Is_Pangram3 {
    public boolean checkIfPangram(String s) {
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for (int i : ch) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}