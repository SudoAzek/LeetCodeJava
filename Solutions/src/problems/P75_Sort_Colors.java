package problems;

import java.util.Arrays;

public class P75_Sort_Colors {
    public static void main(String[] args) {
        Solution_Sort_Colors sol = new Solution_Sort_Colors();
        sol.sortColors(new int[]{0, 1, 2});
    }
}

class Solution_Sort_Colors {
    public void sortColors(int[] a) {
        int i = 0;
        int j = a.length - 1;
        int k = 0;
        while (i <= j) {
            if (a[i] == 2) {
                a[i] = a[j];
                a[j] = 2;
                j--;
            } else if (a[i] == 0) {
                a[i] = a[k];
                a[k] = 0;
                k++;
                i++;
            } else i++;
        }
    }
}

class Solution_Sort_Colors_short {
    public void sortColors(int[] a) {
        int i = 0;
        int j = a.length - 1;
        int k = 0;
        while (i <= j) {
            if (a[i] == 2) {
                a[i] = a[j];
                a[j] = 2;
                j--;
            } else if (a[i] == 0) {
                a[i] = a[k];
                a[k] = 0;
                k++;
                i++;
            } else i++;
        }
    }
}

class Solution_Sort_Colors1 {
    public void sortColors(int[] nums) {

        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int swap = nums[i];
            nums[i] = nums[min];
            nums[min] = swap;
            i++;
        }
        System.out.println(Arrays.toString(nums));
    }
}

class Solution_Sort_Colors2 {
    public void sortColors(int[] nums) {

        if (nums.length == 0) return;

        int startIdx = 0;

        while (startIdx < nums.length - 1) {
            int smallestIdx = startIdx;
            for (int j = startIdx + 1; j < nums.length; j++) {
                if (nums[smallestIdx] > nums[j]) {
                    smallestIdx = j;
                }
            }
            int swap = nums[startIdx];
            nums[startIdx] = nums[smallestIdx];
            nums[smallestIdx] = swap;
            startIdx++;
        }
        System.out.println(Arrays.toString(nums));
    }
}