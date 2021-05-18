package may_daily_challenge;

import java.util.*;

public class D17_LongestStringChain {
    public static void main(String[] args) {
        LongestStringChainSolution solution = new LongestStringChainSolution();
        System.out.println(solution.longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
    }
}


class LongestStringChainSolution {
    public int longestStrChain(String[] words) {
        List<Set<String>> wordsSet = new ArrayList<>(17);
        for (int i = 0; i < 17; i++) {
            wordsSet.add(new HashSet<>());
        }
        for (String word : words) {
            wordsSet.get(word.length()).add(word);
        }
        Map<String, Integer> dp = new HashMap<>();
        int best = 1;
        for (int i = 16; i > 0; i--) {
            if (wordsSet.get(i  - 1).isEmpty()) continue;
            for (String word : wordsSet.get(i)) {
                int wVal = dp.getOrDefault(word, 1);
                for (int j = 0; j < word.length(); j++) {
                    String pred = word.substring(0, j) + word.substring(j + 1);
                    if (wordsSet.get(i - 1).contains(pred) && wVal >= dp.getOrDefault(pred, 1)) {
                        dp.put(pred, wVal + 1);
                        best = Math.max(best, wVal + 1);
                    }
                }
            }
        }
        return best;
    }
}