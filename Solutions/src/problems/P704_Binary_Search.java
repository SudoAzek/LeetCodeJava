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

class Solution_Recursive_Binary_Search {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return -1;
        }
        int midpoint = (start + end) / 2;
        if (nums[midpoint] == target) {
            return midpoint;
        } else if (nums[midpoint] < target) {
            return search(nums, midpoint + 1, end, target);
        } else {
            return search(nums, start, midpoint, target);
        }
    }
}