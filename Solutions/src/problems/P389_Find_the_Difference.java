package problems;

import java.util.HashMap;
import java.util.HashSet;

public class P389_Find_the_Difference {
    public static void main(String[] args) {
        String s = "", t = "y";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        HashSet<Character> chars = new HashSet<>();

        for (Character ch : s.toCharArray()) {
            chars.add(ch);
        }

        for (Character ch : t.toCharArray()) {
            if (!chars.contains(ch)) {
                return ch;
            }
            chars.remove(ch);
        }
        return ' ';
    }

    public char findTheDifferenceBit (String s, String t) {
        char c = 0;
        for(char cs : s.toCharArray()) c ^= cs;
        for(char ct : t.toCharArray()) c ^= ct;
        return c;
    }
}
