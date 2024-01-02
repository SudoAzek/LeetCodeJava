package problems;

public class Q4_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        Median_of_Two_Sorted_Arrays_Solution solution = new Median_of_Two_Sorted_Arrays_Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}

class Median_of_Two_Sorted_Arrays_Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double sum1 = 0, sum2 = 0;
        for (int num : nums1) sum1 += num;
        for (int num : nums2) sum2 += num;

        return (sum1 + sum2) / (nums1.length + nums2.length);
    }
}