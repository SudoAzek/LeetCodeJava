package problems;

public class P53_Maximum_Subarray {
    public static void main(String[] args) {
        Solution_Maximum_Subarray sol = new Solution_Maximum_Subarray();
        System.out.println(sol.maxSubArray(new int[]{0, 1, 2, 3, 4}));
    }
}


class Solution_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }
        return max;
    }
}
