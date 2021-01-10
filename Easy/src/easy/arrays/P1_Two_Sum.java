package easy.arrays;

import java.util.Arrays;

public class P1_Two_Sum {
    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] arr = {2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(solution_1.twoSum(arr, target)));
    }
}

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
 * to target. May assume that each input would have exactly one solution, and you may not use the same element twice.
 * Can return the answer in any order. */

class Solution_1 {
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

class Solution_2 {}
