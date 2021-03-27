package march_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class D26_WordSubsets {
}

class WordSubsetsSolution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bMax = count("");
        for (String b : B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; i++) {
                bMax[i] = Math.max(bMax[i], bCount[i]);
            }
        }

        List<String> answer = new ArrayList<>();
        search:
        for (String a : A) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; i++) {
                if (aCount[i] < bMax[i])
                    continue search;
            }
            answer.add(a);
        }
        return answer;
    }

    public int[] count(String S) {
        int[] answer = new int[26];
        for (char ch : S.toCharArray()) answer[ch - 'a']++;
        return answer;
    }
}

class WordSubsetsSolution2 {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26];
        for (int i = 0; i < B.length; i++) {
            int[] curr = new int[26];
            for (char ch : B[i].toCharArray()) {
                curr[ch - 'a'] += 1;
                count[ch - 'a'] = Math.max(curr[ch - 'a'], count[ch - 'a']);
            }
        }

        List<String> res = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            int[] curr = new int[26];
            boolean flag = true;
            for (char ch : A[i].toCharArray()) {
                curr[ch - 'a'] += 1;
            }

            for (int j = 0; j < 26; j++) {
                if (count[j] > curr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(A[i]);
        }
        return res;
    }
}