package problems;

public class P80_Remove_Duplicates_from_Sorted_Array_II {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {

        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
