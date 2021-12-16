package problems;

import java.util.Arrays;

public class P1913_Maximum_Product_Difference_Between_Two_Pairs {
    public static void main(String[] args) {
        Solution_Maximum_Product_Difference_Between_Two_Pairs sol = new Solution_Maximum_Product_Difference_Between_Two_Pairs();
        System.out.println(sol.maxProductDifference(new int[]{5, 6, 2, 7, 4}));
    }
}

class Solution_Maximum_Product_Difference_Between_Two_Pairs {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }
}

class Solution_Maximum_Product_Difference_Between_Two_Pairs2 {
    public int maxProductDifference(int[] nums) {
       /* Arrays.sort(nums);
        int length = nums.length;
        int w = nums[length-1];
        int x = nums[length-2];
        int y = nums[0];
        int z = nums[1];
        return w * x - y * z;*/


        /*int w = Integer.MIN_VALUE;
        int x = Integer.MIN_VALUE;
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;

        for(int i : nums){
            if(w < i){
                x = w;
                w = i;
            }
            else if(x < i)
                x = i;
            if(y > i){
                z = y;
                y = i;
            }
            else if(z > i)
                z = i;

        }
        return w * x - y * z;*/

        int n = nums.length;

        for (int k = 1; k <= 2; k++) {
            int max = max(nums, 0, n - k);
            int temp = nums[n - k];
            nums[n - k] = nums[max];
            nums[max] = temp;

        }

        for (int k = 0; k <= 1; k++) {
            int min = min(nums, k, n - 3);
            int temp = nums[k];
            nums[k] = nums[min];
            nums[min] = temp;
        }

        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];

    }

    public int min(int[] arr, int a, int b) {
        int min = a;
        for (int i = a + 1; i <= b; i++)
            if (arr[i] < arr[min])
                min = i;
        return min;
    }

    public int max(int[] arr, int a, int b) {
        int max = a;
        for (int i = a + 1; i <= b; i++)
            if (arr[i] > arr[max])
                max = i;
        return max;
    }
}

class Solution_Maximum_Product_Difference_Between_Two_Pairs3 {
    public int maxProductDifference(int[] nums) {
        int max = 0;
        int max2 = 0;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int num : nums){

            if(num>max){
                max2 = max;
                max = num;

            }else if(num>max2){
                max2 = num;
            }

            if(num<min){
                min2 = min;
                min = num;
            }else if(num<min2){
                min2 = num;
            }
        }

        return ((max*max2)-(min*min2));
    }
}
