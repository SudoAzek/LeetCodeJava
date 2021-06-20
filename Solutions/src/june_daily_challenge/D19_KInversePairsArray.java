package june_daily_challenge;

public class D19_KInversePairsArray {
    public static void main(String[] args) {
        KInversePairsArraySolution solution = new KInversePairsArraySolution();
        System.out.println(solution.kInversePairs(3, 0));
    }
}

class KInversePairsArraySolution {
    Integer[][] memo = new Integer[1001][1001];

    public int kInversePairs(int n, int k) {
        if (n == 0) return 0;
        if (k == 0) return 1;
        if (memo[n][k] != null) return memo[n][k];
        int inverse = 0;
        for (int i = 0; i <= Math.min(k, n - 1); i++) {
            inverse = (inverse + kInversePairs(n - i, k - i)) % 1000000007;
        }
        memo[n][k] = inverse;
        return inverse;
    }
}

class KInversePairsArraySolution2 {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    for (int p = 0; p <= Math.min(j, i - 1); p++)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007;
                }
            }
        }
        return dp[n][k];
    }
}

class KInversePairsArraySolution3 {
    Integer[][] memo = new Integer[1001][1001];
    int lim = 1000000007;

    public int kInversePairs(int n, int k) {
        return ((inverse(n, k) + lim - (k > 0 ? inverse(n, k - 1) : 0)) % lim);
    }

    public int inverse(int n, int k) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;
        if (memo[n][k] != null)
            return memo[n][k];
        int val = (inverse(n - 1, k) + lim - ((k - n) >= 0 ? inverse(n - 1, k - n) : 0)) % lim;
        memo[n][k] = (inverse(n, k - 1) + val) % lim;
        return memo[n][k];
    }
}

class KInversePairsArraySolution4 {
    public int kInversePairs(int n, int k) {
        // dp[i][j]: number of different arrays with numbers 1~i and j reverse pairs
        // dp[i][j] = sum of dp[i-1][j-m] with m = 0, 1, 2, ..., i-1 (take the sum of i elements) and j-m must>=0
        // dp[i-1][j]+"dp[i-1][j-1]+dp[i-1][j-2]+...+dp[i-1][j-i+1]" = dp[i-1][j]+"dp[i][j-1]-dp[i-1][j-i]"
        // => replace the acc sum inside "" to be "dp[i][j-1]-dp[i-1][j-i+1]"
        // with larger i, range of the term dp[i-1][j-i+1] will be larger
        // Note: if j-i+1<=0, use 0 for the term dp[i-1][j-i+1] (if j-i+1==0, it's the case j==i-1)
        // target: dp[n][k]
        // base case: dp[i][0]=1 for any i
        int mod = 1000000007;
        int[] dp = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            int[] pre = dp;
            dp = new int[k + 1];
            for (int j = 0; j <= k && j <= i * (i - 1) / 2; j++) {
                // w/o this "j<=i*(i-1)/2", we need to dp[n][k]−dp[n][k−1] for the ans
                // i*(i-1)/2 max number of inverse pair of i (for array i, i-1, i-2, ..., 2, 1 => i*(i-1)/2 inverse pairs)
                if (j == 0) dp[0] = 1;
                else {
                    int tmp = (pre[j] + mod - (j - i >= 0 ? pre[j - i] : 0)) % mod;
                    dp[j] = (dp[j - 1] + tmp) % mod;
                    // System.out.println(i+" "+j+" "+dp[i][j]);
                }
            }
        }
        return dp[k];
    }
}

class KInversePairsArraySolution5 {
    public int kInversePairs(int n, int k) {
        int M = 1_000_000_007;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            int[] cur = new int[k + 1];
            cur[0] = 1;
            for (int j = 1; j <= k; j++) {
                cur[j] = (cur[j - 1] + dp[j] - (j < i ? 0 : dp[j - i])) % M;
                if (cur[j] < 0) cur[j] += M;
            }
            dp = cur;
        }
        return dp[k];
    }
}