package june_daily_challenge;

public class D17_NumberOfSubArraysWithBoundedMaximum {
    public static void main(String[] args) {
        NumberOfSubArraysWithBoundedMaximumSolution solution = new NumberOfSubArraysWithBoundedMaximumSolution();
        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }
}

class NumberOfSubArraysWithBoundedMaximumSolution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int answer = 0, low = 0, mid = 0;
        for (int num : nums) {
            if (num > right) mid = 0;
            else answer += ++mid;
            if (num >= left) low = 0;
            else answer -= ++low;
        }
        return answer;
    }
}

class NumberOfSubArraysWithBoundedMaximumSolution2 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x : A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
}