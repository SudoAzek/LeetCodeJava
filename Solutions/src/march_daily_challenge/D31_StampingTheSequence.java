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

class StampingTheSequenceSolution2 {
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> res = new ArrayList<>();
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] v = new boolean[t.length];
        int repCnt = 0;
        while (repCnt < t.length) {
            boolean replaced = false;
            for (int i = 0; i + s.length - 1 < t.length; i++) {
                if (!v[i] && canReplace(s, t, i)) {
                    v[i] = true;
                    replaced = true;
                    repCnt += replace(s, t, i);
                    res.add(i);

                    if (repCnt == t.length) break;
                }
            }
            if (!replaced) break;
        }

        if (repCnt < t.length) return new int[0];

        int[] r = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) {
            r[res.size() - 1 - i] = res.get(i);
        }
        return r;
    }

    public boolean canReplace(char[] s, char[] t, int si) {
        for (int i = si; i < si + s.length; i++) {
            if (t[i] != s[i - si] && t[i] != '*') return false;
        }
        return true;
    }

    public int replace(char[] s, char[] t, int si) {
        int cnt = 0;
        for (int i = si; i < si + s.length; i++) {
            if (t[i] != '*') {
                t[i] = '*';
                cnt++;
            }
        }
        return cnt;
    }
}