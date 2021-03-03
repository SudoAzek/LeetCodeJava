package fun_with_arrays.inserting_items_into_an_array.problems;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArraySolution sol = new MergeSortedArraySolution();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        sol.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Loop through the arrays, from the last element to the first
       while ((m - 1) >= 0 && n - 1 >= 0) {
           if (nums1[m - 1] >= nums2[n - 1]) {
               nums1[(m - 1) + n - 1 + 1] = nums1[(m - 1)];
               m--;
           } else {
               nums1[(m - 1) + (n - 1) + 1] = nums2[n - 1];
               n--;
           }
       }
       // Copy in the remaining elements
        while((n - 1) >= 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }
}

class MergeSortedArraySolution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        int i = 0, j = 0, k = 0;

        // Traverse both arrays
        while (i < m && j < n) {
            // Check if the current element of first array is smaller than current element of second array.
            // If yes, store first array element and increment first array index. Otherwise do same with second array.
            if (nums1[i] < nums2[j] && nums1[i] != 0) nums3[k++] = nums1[i++];
            if (nums1[i] == 0) m--;
            else nums3[k++] = nums2[j++];
        }

        // Store remaining elements of first array
        while (i < m)
            nums3[k++] = nums1[i++];

        // Store remaining elements of second array
        while (j < n)
            nums3[k++] = nums2[j++];

        for (int l = 0; l < m + n; l++) {
            nums1[l] = nums3[l];
        }
    }
}

class MergeSortedArraySolution3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int newArraySize = n + m;
        int[] nums3 = new int[newArraySize];

        while (k < newArraySize) {
            if (nums1[i] < nums2[j] && nums1[i] != 0) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        if (m >= 0) System.arraycopy(nums3, 0, nums1, 0, newArraySize);
    }
}

