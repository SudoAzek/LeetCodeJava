package august_daily_challenge;

import java.util.Arrays;
import java.util.HashMap;

public class D02_TwoSum {
    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}

class TwoSumSolution1 {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{nums[l], nums[r]};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{};
    }
}

class TwoSumSolution3 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] T;
        while (l < r) {
            if (target < nums[r]) {
                r--;
            } else if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else {
                l++;
            }
        }
        return null;
    }
}

class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int b = nums[i], a = target - b;
            if (seen.containsKey(a)) return new int[]{seen.get(a), i};
            seen.put(b, i);
        }
        return new int[]{};
    }
}

class TwoSumSolution4 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[]{0, 1};
        if (nums.length == 2) return ret;
        for (short i = 0; i < (short) Math.ceil(nums.length / 2); i++) {
            for (short j = 0; j < nums.length; j++) {
                if (i != j) if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
                if (nums.length - 1 - i != j) if (nums[nums.length - 1 - i] + nums[j] == target) {
                    ret[0] = nums.length - 1 - i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
    }
}