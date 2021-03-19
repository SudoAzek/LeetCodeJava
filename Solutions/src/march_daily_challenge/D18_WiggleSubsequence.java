package march_daily_challenge;

public class D18_WiggleSubsequence {
    public static void main(String[] args) {
        WiggleSubsequenceSolution solution = new WiggleSubsequenceSolution();
        System.out.println(solution.wiggleMaxLength(new int[] {1, 7, 4, 9, 2, 5}));
    }
}


class WiggleSubsequenceSolution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] ups = new int[nums.length];
        int[] downs = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    ups[i] = Math.max(ups[i], downs[j] + 1);
                } else if (nums[i] < nums[j]) {
                    downs[i] = Math.max(downs[i], ups[j] + 1);
                }
            }
        }
        return 1 + Math.max(downs[nums.length - 1], ups[nums.length - 1]);
    }
}