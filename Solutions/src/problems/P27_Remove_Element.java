package problems;

public class P27_Remove_Element {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        // Input: nums = [0,1,2,2,3,0,4,2], val = 2
        int count = 0;
        int insertPosition = 0;
        for (int num : nums) {
            if (num != val) {
                nums[insertPosition++] = num;
            } else {
                count++;
            }
        }
        return nums.length - count;
    }
}
