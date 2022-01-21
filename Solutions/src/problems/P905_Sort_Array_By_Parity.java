package problems;

import java.util.Arrays;

public class P905_Sort_Array_By_Parity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0, 2, 4})));
    }

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) return nums;

        int insertPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int buffer = nums[insertPosition];
                nums[insertPosition] = nums[i];
                nums[i] = buffer;
                insertPosition++;
            }
        }
        return nums;
    }
}
