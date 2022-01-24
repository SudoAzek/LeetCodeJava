package problems;

public class P747_Largest_Number_At_Least_Twice_of_Others {

    public static void main(String[] args) {

    }

    public static int dominantIndex(int[] nums) {

        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[maxIndex] && nums[maxIndex] < 2 * nums[i]) return -1;
        }
        return maxIndex;
    }
}
