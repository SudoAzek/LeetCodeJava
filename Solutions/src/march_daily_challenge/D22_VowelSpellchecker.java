package march_daily_challenge;

import java.util.*;

public class D22_VowelSpellchecker {
    public static void main(String[] args) {
        SolutionVowelSpellchecker sol = new SolutionVowelSpellchecker();
//        System.out.println(sol.spellchecker());
    }
}

class SolutionVowelSpellchecker {
    Set<String> words_perfect;
    Map<String, String> words_cap;
    Map<String, String> words_vow;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        words_perfect = new HashSet<>();
        words_cap = new HashMap<>();
        words_vow = new HashMap<>();

        for (String word : wordlist) {
            words_perfect.add(word);

            String wordLow = word.toLowerCase();
            words_cap.putIfAbsent(wordLow, word);

            String wordLowDV = deVowel(wordLow);
            words_vow.putIfAbsent(wordLowDV, word);
        }

        String[] ans = new String[queries.length];
        int t = 0;
        for (String query : queries) {
            ans[t++] = solve(query);
        }
        return ans;
    }

    public String solve(String query) {
        if (words_perfect.contains(query))
            return query;

        String queryL = query.toLowerCase();
        if (words_cap.containsKey(queryL))
            return words_cap.get(queryL);

        String queryLV = deVowel(queryL);
        if (words_vow.containsKey(queryLV))
            return words_vow.get(queryLV);

        return "";
    }

    public String deVowel(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c: word.toCharArray())
            ans.append(isVowel(c) ? '*' : c);
        return ans.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}