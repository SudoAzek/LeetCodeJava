package problems;

import java.util.HashSet;
import java.util.Set;

public class P219_Contains_Duplicate_II {
    public static void main(String[] args) {
        Contains_Duplicate_II_Solution sol = new Contains_Duplicate_II_Solution();
        System.out.println(sol.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}

class Contains_Duplicate_II_Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= Math.max(0, i - k); j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}