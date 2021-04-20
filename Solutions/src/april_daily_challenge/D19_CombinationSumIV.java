package april_daily_challenge;

import java.util.Arrays;

public class D19_CombinationSumIV {
    public static void main(String[] args) {
        CombinationSumIVSolution1 solution1 = new CombinationSumIVSolution1();
        System.out.println(solution1.combinationSum4(new int[] {1, 2, 3}, 4));
    }
}

// With Top-Down DP:
class CombinationSumIVSolution1 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}

// With Bottom-Up DP:
class CombinationSumIVSolution2 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target; i++) {
            if (dp[i] == 0) continue;
            for (int num : nums) {
                if (num + i <= target) dp[i + num] += dp[i];
            }
        }
        return dp[target];
    }
}

class CombinationSumIVSolution3 {
    int [] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    public int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for(int i=0; i<nums.length;i++) {
            if(target>=nums[i])
                res += helper(nums, target-nums[i]);
        }
        dp[target] = res;
        return res;

    }
}