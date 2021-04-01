package march_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D31_StampingTheSequence {
    public static void main(String[] args) {
        StampingTheSequenceSolution solution = new StampingTheSequenceSolution();
        System.out.println(Arrays.toString(solution.movesToStamp("abc", "ababc")));
    }
}

class StampingTheSequenceSolution {
    public int[] movesToStamp(String stamp, String target) {
        if (stamp.equals(target)) return new int[]{0};
        char[] stampChars = stamp.toCharArray(), targetChars = target.toCharArray();
        int stampLen = stampChars.length, targetLen = targetChars.length - stampLen + 1, i, j;
        List<Integer> L = new ArrayList<>();
        boolean targetDiff = true, stampDiff;
        while (targetDiff) {
            for (i = 0, targetDiff = false; i < targetLen; i++) {
                for (j = 0, stampDiff = false; j < stampLen; j++) {
                    if (targetChars[i + j] == '*') continue;
                    else if (targetChars[i + j] != stampChars[j]) break;
                    else stampDiff = true;
                }
                if (j == stampLen && stampDiff) {
                    for (j = i, targetDiff = true; j < stampLen + i; j++) {
                        targetChars[j] = '*';
                    }
                    L.add(0, i);
                }
            }
        }
        for (i = 0; i < targetChars.length; i++) {
            if (targetChars[i] != '*') return new int[]{};
        }
        int[] answer = new int[L.size()];
        for (i = 0; i < L.size(); i++) {
            answer[i] = L.get(i);
        }
        return answer;
    }
}