package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P217_Contains_Duplicate {
    public static void main(String[] args) {

    }
}

class Solution_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet();

        for (int i : nums) {
            uniques.add(i);
        }

        return nums.length > uniques.size();
    }
}


class Solution_Contains_Duplicate2 {
    public boolean containsDuplicate(int[] nums) {
        int max = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }
        boolean[] mark = new boolean[max - min + 1];
        for (int j = 0; j < nums.length; j++) {
            if (mark[max - nums[j]]) {
                return true;
            } else {
                mark[max - nums[j]] = true;
            }
        }
        return false;
    }
}

class Solution_Contains_Duplicate3 {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j - 1] == nums[j]) {
                    return true;
                } else if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}

class Solution_Contains_Duplicate4 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        Set<Integer> checkDup = new HashSet();
        for (int i : nums) {
            if (!checkDup.add(i)) return true;
        }
        return false;

    }
}

class Solution_Contains_Duplicate5 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        // Set<Integer> checkDup = new HashSet();
        // for(int i: nums){
        //     if (!checkDup.add(i)) return true;
        // }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;

    }
}