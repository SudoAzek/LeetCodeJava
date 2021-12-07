package problems;

import java.util.Arrays;

public class P1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
    public static void main(String[] args) {
        Solution_How_Many_Numbers_Are_Smaller_Than_the_Current_Number sol = new Solution_How_Many_Numbers_Are_Smaller_Than_the_Current_Number();
        System.out.println(Arrays.toString(sol.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }
}

class Solution_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int arrLen = nums.length;
        int[] smallerArr = new int[arrLen];

        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < arrLen; j++) {
                if (nums[i] > nums[j]) {
                    smallerArr[i] = smallerArr[i] + 1;
                }
            }
        }

        return smallerArr;
    }
}

class Solution_How_Many_Numbers_Are_Smaller_Than_the_Current_Number_N {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smaller = new int[101];

        for (int i = 0; i < nums.length; i++) {
            smaller[nums[i]]++;
        }

        for (int i = 1; i < 101; i++) {
            smaller[i] += smaller[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int position = nums[i];
            if (position == 0) {
                nums[i] = 0;
            } else {
                nums[i] = smaller[position - 1];
            }
        }
        return nums;
    }
}

class Solution_How_Many_Numbers_Are_Smaller_Than_the_Current_Number_N2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]  ;
        for(int a:nums)count[a]++;
        for(int i =1;i<101;i++) count[i] += count[i-1];
        for(int i =0;i<nums.length;i++) {
            if(nums[i] != 0) nums[i] = count[nums[i] -1];
        }
        return nums;
    }
}