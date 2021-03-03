package top_easy_interview_questions.array;


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
        for (int x : nums) {
            if(i == 0 || x > nums[i - 1]) {
                nums[i++] = x;
            }
        }
        return i;
    }
}