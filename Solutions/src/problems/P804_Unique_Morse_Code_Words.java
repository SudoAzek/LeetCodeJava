package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P804_Unique_Morse_Code_Words {
    public static void main(String[] args) {
        Solution_Unique_Morse_Code_Words sol = new Solution_Unique_Morse_Code_Words();
        System.out.println(sol.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}

class Solution_Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> morseMap = new HashMap<>();
        morseMap.put('a', ".-");
        morseMap.put('b', "-...");
        morseMap.put('c', "-.-.");
        morseMap.put('d', "-..");
        morseMap.put('e', ".");
        morseMap.put('f', "..-.");
        morseMap.put('g', "--.");
        morseMap.put('h', "....");
        morseMap.put('i', "..");
        morseMap.put('j', ".---");
        morseMap.put('k', "-.-");
        morseMap.put('l', ".-..");
        morseMap.put('m', "--");
        morseMap.put('n', "-.");
        morseMap.put('o', "---");
        morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");
        morseMap.put('r', ".-.");
        morseMap.put('s', "...");
        morseMap.put('t', "-");
        morseMap.put('u', "..-");
        morseMap.put('v', "...-");
        morseMap.put('w', ".--");
        morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");
        morseMap.put('z', "--..");
        HashSet<String> uniqueTransformations = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                if (morseMap.get(words[i].charAt(j)) != null) {
                    sb.append(morseMap.get(words[i].charAt(j)));
                }
            }
            uniqueTransformations.add(sb.toString());
        }
        return uniqueTransformations.size();
    }
}

class Solution_Unique_Morse_Code_Words2 {
    private static String[] morseMap = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueString = new HashSet<>();
        for (String word : words) {
            uniqueString.add(toMorse(word));
        }
        return uniqueString.size();
    }

    public String toMorse(String word) {
        StringBuilder builder = new StringBuilder();
        for (char c : word.toCharArray()) {
            builder.append(morseMap[c - 'a']);
        }
        return builder.toString();
    }
}