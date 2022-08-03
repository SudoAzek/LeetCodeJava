package problems;

public class P1991_Find_the_Middle_Index_in_Array {
    public static void main(String[] args) {
        Find_the_Middle_Index_in_Array_Solution solution = new Find_the_Middle_Index_in_Array_Solution();
        System.out.println(solution.findMiddleIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class Find_the_Middle_Index_in_Array_Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0, leftSum = 0;

        for (int i : nums) sum += i;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]  ) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
