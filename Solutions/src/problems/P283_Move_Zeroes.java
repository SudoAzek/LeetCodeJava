package problems;

public class P283_Move_Zeroes {
    public static void main(String[] args) {
        Solution_Move_Zeroes sol = new Solution_Move_Zeroes();
        sol.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}

class Solution_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}

class Solution_Move_Zeroes2 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int cur = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int temp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}