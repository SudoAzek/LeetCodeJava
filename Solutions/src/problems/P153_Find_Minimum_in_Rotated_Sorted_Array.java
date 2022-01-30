package problems;

public class P153_Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Solution_Find_Minimum_in_Rotated_Sorted_Array sol = new Solution_Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(sol.findMin(new int[]{11, 13, 15, 17}));
    }
}

class Solution_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        final int firstInt = nums[0];
        int floorIndex = 0;
        int ceilingIndex = nums.length - 1;

        while (floorIndex < ceilingIndex) {
            int guessIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);

            if (firstInt >= nums[guessIndex]) {
                ceilingIndex = guessIndex;
            } else {
                floorIndex = guessIndex;
            }

            if (floorIndex + 1 == ceilingIndex) {
                break;
            }
        }
        return nums[ceilingIndex];
    }
}