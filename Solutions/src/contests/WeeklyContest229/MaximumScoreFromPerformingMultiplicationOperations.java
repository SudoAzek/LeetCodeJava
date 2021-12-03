package contests.WeeklyContest229;

import java.util.Arrays;

public class MaximumScoreFromPerformingMultiplicationOperations {
    public static void main(String[] args) {
        MaximumScoreFromPerformingMultiplicationOperationsSolution sol = new MaximumScoreFromPerformingMultiplicationOperationsSolution();
        System.out.println(sol.maximumScore(new int[]{-5,-3,-3,-2,7,1}, new int[]{-10,-5,3,4,6}));
    }
}

class MaximumScoreFromPerformingMultiplicationOperationsSolution {
    public int maximumScore(int[] nums, int[] multipliers) {
        Arrays.sort(nums);
        Arrays.sort(multipliers);
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < multipliers.length; j++) {
                sum += nums[i] * multipliers[j];
            }
        }
        return sum;
    }
}
