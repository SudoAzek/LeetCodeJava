package problems;

import java.util.Arrays;

public class P88_Merge_Sorted_Array {
    public static void main(String[] args) {

    }
}

class Solution_Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int temp = 0;
        int pos = 0;
        int[] tempArr = nums1;

        System.arraycopy(tempArr, 0, nums1, 0, m);
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}

class Solution_Merge_Sorted_Array2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}

class Solution_Merge_Sorted_Array3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] r = new int[m + n];
        int k = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                r[k] = nums1[i];
                k++;
                i++;
            } else {
                r[k] = nums2[j];
                k++;
                j++;
            }
        }
        if (i < m && j >= n) {
            while (i < m) {
                r[k] = nums1[i];
                k++;
                i++;
            }
        } else if (i >= m && j < n) {
            while (j < n) {
                r[k] = nums2[j];
                k++;
                j++;
            }
        }

        for (int l = 0; l < k; l++) {
            nums1[l] = r[l];
        }
    }
}