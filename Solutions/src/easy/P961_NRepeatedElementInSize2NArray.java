package easy;

import java.util.HashMap;
import java.util.Map;

public class P961_NRepeatedElementInSize2NArray {
    public static void main(String[] args) {
        NRepeatedElementInSize2NArraySolution2 solution = new NRepeatedElementInSize2NArraySolution2();
        System.out.println(solution.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}

class NRepeatedElementInSize2NArraySolution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for (int i : count.keySet()) {
            if (count.get(i) > 1) return i;
        }

        throw null;
    }
}

class NRepeatedElementInSize2NArraySolution1 {
    public int repeatedNTimes(int[] nums) {
        for (int j = 1; j <= 3; ++j)
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == nums[i + j]) return nums[i];
        throw null;
    }
}

class NRepeatedElementInSize2NArraySolution2 {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (hm.containsKey(nums[i])) {
                return nums[i];
            } else {
                hm.put(nums[i], 1);
            }
        }
        return 0;
    }
}