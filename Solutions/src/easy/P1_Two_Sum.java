package easy;

import java.util.Arrays;

public class P1_Two_Sum {
    public static void main(String[] args) {
        TwoSumSolution solution_1 = new TwoSumSolution();
        int[] arr = {2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(solution_1.twoSum(arr, target)));
    }
}

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
 * to target. May assume that each input would have exactly one solution, and you may not use the same element twice.
 * Can return the answer in any order. */

class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] + nums[r] == target) return new int[]{l, r};
            else if (nums[l] + nums[r] > target) r--;
            else if (nums[l] + nums[r] < target) l++;
        }
        return nums;
    }
}

class TwoSumSolution_2 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] T;
        while (l < r) {
            if (target < nums[r]) {
                r--;
            } else if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else {
                l++;
            }
        }
        return null;
    }
}

class TwoSumSolution_1 {
    // Approach 1: Brute Force
    // The brute force approach is simple. Loop through each element x and find if there is
    // another value that equals to target - x
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
