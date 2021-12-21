package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class P350_Intersection_of_Two_Arrays_II {
    public static void main(String[] args) {
        Solution_Intersection_of_Two_Arrays_II sol = new Solution_Intersection_of_Two_Arrays_II();
        System.out.println(Arrays.toString(sol.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}


class Solution_Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        ArrayList<Integer> intersection = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection.stream().mapToInt(n -> n).toArray();
    }
}

class Solution_Intersection_of_Two_Arrays_II2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        int[] res = new int[nums1.length * nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }

        return Arrays.copyOfRange(res, 0, k);
    }
}