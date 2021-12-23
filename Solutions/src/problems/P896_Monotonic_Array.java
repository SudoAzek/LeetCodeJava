package problems;

public class P896_Monotonic_Array {
    public static void main(String[] args) {
        Solution_Monotonic_Array sol = new Solution_Monotonic_Array();
        System.out.println(sol.isMonotonic(new int[]{1, 3, 2}));
    }
}

class Solution_Monotonic_Array {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) return true;
        int direction = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (direction == 0) direction = nums[i] - nums[i - 1];

            if (breaksDirection(direction, nums[i - 1], nums[i])) return false;
        }
        return true;
    }

    boolean breaksDirection(int direction, int previousInt, int currentInt) {
        int difference = currentInt - previousInt;
        if (direction > 0) {
            return difference < 0;
        } else return difference > 0;
    }
}


class Solution_Monotonic_Array2 {
    public boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length <= 1)
            return true;

        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                break;
        }

        if (i == nums.length - 1)
            return true;

        i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                break;
        }

        return i == nums.length - 1;
    }
}