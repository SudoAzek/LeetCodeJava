package problems;

public class P35_Search_Insert_Position {
    public static void main(String[] args) {
        Solution_Search_Insert_Position sol = new Solution_Search_Insert_Position();
        System.out.println(sol.searchInsert(new int[]{1}, 2));
    }
}

class Solution_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        if (n == 1 && nums[0] < target) {
            return 1;
        } else if (n == 1 && nums[0] > target) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            if (target == nums[i - 1]) return i - 1;
            if (target > nums[i - 1] && target < nums[i]) return i;
            if (target > nums[n - 1]) return n;
        }
        return 0;
    }
}