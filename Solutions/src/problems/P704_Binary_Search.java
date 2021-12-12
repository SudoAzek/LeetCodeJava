package problems;

public class P704_Binary_Search {
}

class Solution_Binary_Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int pivot = 0;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            pivot = start + (end - start) / 2;
            if (target == nums[pivot]) {
                return pivot;
            }

            if (target > nums[pivot]) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }
        return -1;
    }
}