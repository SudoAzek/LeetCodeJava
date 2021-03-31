package march_daily_challenge;

import java.util.Arrays;

public class D30_RussianDollEnvelopes {
    public static void main(String[] args) {
        RussianDollEnvelopesSolution solution = new RussianDollEnvelopesSolution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
}

class RussianDollEnvelopesSolution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int answer = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, answer, height);
            if (left < 0) left = -left - 1;
            if (left == answer) answer++;
            dp[left] = height;
        }
        return answer;
    }
}