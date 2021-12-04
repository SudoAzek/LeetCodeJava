package problems;

import java.util.Arrays;

public class P1480_Running_Sum_of_1d_Array {
    public static void main(String[] args) {
        Solution_Running_Sum_of_1d_Array sol = new Solution_Running_Sum_of_1d_Array();
        System.out.println(Arrays.toString(sol.runningSum(new int[]{1, 2, 3, 4})));
    }
}

class Solution_Running_Sum_of_1d_Array {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
