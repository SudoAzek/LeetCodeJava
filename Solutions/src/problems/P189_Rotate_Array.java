package problems;

import java.util.Arrays;

public class P189_Rotate_Array {
    public static void main(String[] args) {
        Solution_Rotate_Array sol = new Solution_Rotate_Array();
        sol.rotate(new int[] {-1,-100,3,99}, 2);
    }
}

class Solution_Rotate_Array {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int[] rotated = new int[nums.length];

        if (nums.length == 1) return;

        for (int i = 0; i < nums.length; i++) {

            if (i + k < nums.length && nums.length % 2 == 0) {
                rotated[i] = nums[nums.length - Math.abs(i - k)];
            } else if (i + k < nums.length - 1 && nums.length % 2 != 0) {
                rotated[i] = nums[nums.length - Math.abs(i - k)];
            } else {
                rotated[i] = nums[i - k];
            }
        }
        System.arraycopy(rotated, 0, nums, 0, nums.length);
        nums = rotated;
        System.out.println(Arrays.toString(rotated));
        System.out.println(Arrays.toString(nums));
    }
}