package may_daily_challenge;

import java.util.Arrays;

public class D03_RunningSumOf1dArray {
    public static void main(String[] args) {
        RunningSumOf1dArraySolution solution = new RunningSumOf1dArraySolution();
        System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 1, 1, 1, 1})));
    }
}

class RunningSumOf1dArraySolution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}

class RunningSumOf1dArraySolution2 {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1]+nums[i];
        }
        System.gc();
        return nums;
    }
}