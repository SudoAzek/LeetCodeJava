package problems;

public class P312_Burst_Balloons {
}

class Solution_Burst_Balloons {
    public int maxCoins(int[] nums) {
        int[] numbers = new int[nums.length + 2];
        int n = 1;
        for (int i : nums) if (i > 0) numbers[n++] = i;
        numbers[0] = numbers[n++] = 1;

        int[][] dp = new int[n][n];
        for (int j = 2; j < n; ++j)
            for (int left = 0; left < n - j; ++left) {
                int right = left + j;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right], numbers[left] * numbers[i] * numbers[right] + dp[left][i] + dp[i][right]);
            }
        return dp[0][n - 1];
    }
}