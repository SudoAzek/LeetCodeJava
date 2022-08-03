package problems;

public class P724_Find_Pivot_Index {
    public static void main(String[] args) {
        Find_Pivot_Index_Solution solution = new Find_Pivot_Index_Solution();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class Find_Pivot_Index_Solution {
    public int pivotIndexMy(int[] nums) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        int leftSum = 0;
        int rightSum = 0;

        while (leftIdx < rightIdx) {
            if (leftSum <= rightSum) {
                leftSum += nums[leftIdx];
                leftIdx++;
            } else {
                rightSum += nums[rightIdx];
                rightIdx--;
            }
            if (leftSum == rightSum && rightIdx - leftIdx == 2) {
                return leftIdx + 1;
            }
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}