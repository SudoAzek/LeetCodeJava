package june_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D13_PalindromePairs {
    public static void main(String[] args) {

    }
}

class PalindromePairsSolution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wMap = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            wMap.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                for (int j = 0; j < words.length; j++) {
                    String w = words[j];
                    if (isPal(w, 0, w.length() - 1) && j != i) {
                        answer.add(List.of(i, j));
                        answer.add(List.of(j, i));
                    }
                }
                continue;
            }
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            String bw = sb.toString();
            if (wMap.containsKey(bw)) {
                int res = wMap.get(bw);
                if (res != i) answer.add(List.of(i ,res));
            }
            for (int j = 1; j < bw.length(); j++) {
                if (isPal(bw, 0, j - 1)) {
                    String s = bw.substring(j);
                    if (wMap.containsKey(s))
                        answer.add(List.of(wMap.get(s), i));
                }
                if (isPal(bw, j, bw.length() - 1)) {
                    String s = bw.substring(0, j);
                    if (wMap.containsKey(s))
                        answer.add(List.of(wMap.get(s), i));
                }
            }
        }
        return answer;
    }

    private boolean isPal(String word, int i, int j) {
        while (i < j)
            if (word.charAt(i++) != word.charAt(j--)) return false;
            return true;
    }
}
