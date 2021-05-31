package may_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D30_MaximumGap {
    public static void main(String[] args) {
        MaximumGapSolution solution = new MaximumGapSolution();
        System.out.println(solution.maximumGap(new int[]{3, 6, 9, 1}));
    }
}

class MaximumGapSolution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int high = 0, low = Integer.MAX_VALUE, answer = 0;
        for (int n : nums) {
            high = Math.max(high, n);
            low = Math.min(low, n);
        }

        int bSize = Math.max((high - low) / (nums.length - 1), 1);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = (high - low) / bSize; i >= 0; i--) {
            buckets.add(new ArrayList<>());
        }
        for (int n : nums) {
            buckets.get((n - low) / bSize).add(n);
        }
        int currHigh = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket.isEmpty()) continue;
            int prevHigh = currHigh > 0 ? currHigh : bucket.get(0), currLow = bucket.get(0);
            for (int n : bucket) {
                currHigh = Math.max(currHigh, n);
                currLow = Math.min(currLow, n);
            }
            answer = Math.max(answer, currLow - prevHigh);
        }
        return answer;
    }
}

class MaximumGapSolution1 {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 2) return 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff > max)
                max = diff;
        }
        return max;
    }
}