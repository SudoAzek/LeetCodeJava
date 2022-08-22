package problems;

import org.w3c.dom.ls.LSOutput;

public class P377_Combination_Sum_IV {
    public static void main(String[] args) {
        Combination_Sum_IV_Solution solution = new Combination_Sum_IV_Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }

}


class Combination_Sum_IV_Solution {
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