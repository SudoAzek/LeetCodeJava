package problems;

import java.util.HashMap;
import java.util.Map;

public class P290_Word_Pattern {

    public static void main(String[] args) {
        String pattern = "abba", s = "dog dog do dog";

//        System.out.println(wordPattern(pattern, s));
        System.out.println(wordPattern3(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> keyMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        String[] words = s.split("\\s+");

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {


            if (keyMap.containsKey(pattern.charAt(i)) && !keyMap.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            } else if (wordMap.containsKey(words[i]) && !wordMap.get(words[i]).equals(pattern.charAt(i))) {
                return false;
            }

            wordMap.put(words[i], pattern.charAt(i));
            keyMap.put(pattern.charAt(i), words[i]);
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = s.split(" ");

        if (arr.length != pattern.length())
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (map.values().contains(arr[i]))
                    return false;
                map.put(ch, arr[i]);
            } else {
                if (!arr[i].equals(map.get(ch)))
                    return false;
            }
        }
        return true;
    }

    public static boolean wordPattern3(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (int i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}

