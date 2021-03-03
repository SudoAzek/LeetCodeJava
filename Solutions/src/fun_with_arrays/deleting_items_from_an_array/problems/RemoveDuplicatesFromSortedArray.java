package fun_with_arrays.deleting_items_from_an_array.problems;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArraySolution sol = new RemoveDuplicatesFromSortedArraySolution();
        System.out.println(sol.removeDuplicates(arr));
    }
}

class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}

class RemoveDuplicatesFromSortedArraySolution1 {
    public int removeDuplicates(int[] nums) {
        int i = nums.length - 1;
        int size = nums.length;
        while (i >= 1) {
            if(nums[i - 1] == nums[i]) {
                for (int j = i; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                size--;
            }
            i--;
        }
        return size;
    }
}

class RemoveDuplicatesFromSortedArraySolution2 {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int x : nums) {
            hashSet.add(x);
        }
        return hashSet.size();
    }
}

class RemoveDuplicatesFromSortedArraySolution3 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
