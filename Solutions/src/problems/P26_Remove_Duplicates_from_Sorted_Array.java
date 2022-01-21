package problems;

public class P26_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int currentPointer = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[currentPointer] != nums[i]) {
                currentPointer++;
                nums[currentPointer] = nums[i];
            }
        }
        return currentPointer + 1;
    }
}
