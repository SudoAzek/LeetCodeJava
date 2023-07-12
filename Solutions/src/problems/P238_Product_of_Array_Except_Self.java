package problems;

import java.util.Arrays;

public class P238_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        Arrays.fill(productArray, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    productArray[i] *= nums[j];
                }
            }
        }
        return productArray;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
