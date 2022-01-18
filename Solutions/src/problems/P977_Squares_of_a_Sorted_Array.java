package problems;

import java.util.Arrays;

public class P977_Squares_of_a_Sorted_Array {
    public static void main(String[] args) {

    }
}


class Solution_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        int[] squared = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squared[i] = nums[i] * nums[i];
        }
        Arrays.sort(squared);
        return squared;
    }

    public int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];

        int leftPnt = 0, rightPnt = nums.length - 1;
        int index = nums.length - 1;
        while (leftPnt <= rightPnt) {
            if (Math.abs(nums[leftPnt]) > Math.abs(nums[rightPnt])) {
                result[index] = nums[leftPnt] * nums[leftPnt];
                index--;
                leftPnt++;
            } else {
                result[index] = nums[rightPnt] * nums[rightPnt];
                rightPnt--;
                index--;
            }
        }
        return result;
    }
}