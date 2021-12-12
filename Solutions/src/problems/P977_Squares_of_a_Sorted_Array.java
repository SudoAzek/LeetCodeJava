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
}