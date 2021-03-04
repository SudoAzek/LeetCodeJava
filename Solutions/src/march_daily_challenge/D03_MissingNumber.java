package march_daily_challenge;

import java.util.Arrays;

public class D03_MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1};
        MissingNumberSolution solution = new MissingNumberSolution();
        System.out.println(solution.missingNumber(arr));

    }
}

class MissingNumberSolution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (1 + nums.length) * nums.length / 2 - sum;
    }
}

class MissingNumberSolution1 {
    public int missingNumber(int[] nums) {
        int linearSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            linearSum += i + 1;
        }
        return linearSum - sum;
    }
}

class MissingNumberSolution2 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (1 + nums.length) * nums.length / 2 - sum;
    }
}

class MissingNumberSolution3 {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

