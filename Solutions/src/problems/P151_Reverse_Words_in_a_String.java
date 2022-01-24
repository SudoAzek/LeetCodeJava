package problems;

import java.util.Arrays;

public class P151_Reverse_Words_in_a_String {
    public static void main(String[] args) {
        String s = "example   good a";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");

        int i = 0, j = words.length - 1;
        while (i < j) {
            String buffer = words[i];
            words[i++] = words[j];
            words[j--] = buffer;
        }
        return Arrays.toString(words)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }
}
