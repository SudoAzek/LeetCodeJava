package problems;

public class P33_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Solution_Search_in_Rotated_Sorted_Array sol = new Solution_Search_in_Rotated_Sorted_Array();

    }
}


class Solution_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        final int firstInt = nums[0];
        int floorIndex = 0;
        int ceilingIndex = nums.length - 1;

        while (floorIndex < ceilingIndex) {
            int guessIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);

            if (firstInt > nums[guessIndex]) ;
        }
        return 1;
    }
}