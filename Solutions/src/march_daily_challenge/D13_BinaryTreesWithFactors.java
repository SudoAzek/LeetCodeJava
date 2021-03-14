package march_daily_challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D13_BinaryTreesWithFactors {
}

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int len = A.length;
        long[] dp = new long[len];
        Arrays.sort(A);
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < len; ++i)
            index.put(A[i], i);

        for (int i = 0; i < len; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        long ans = 0;
        for (long x : dp) ans += x;
        return (int) (ans % MOD);
    }
}