package fun_with_arrays.deleting_items_from_an_array.problems;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElementSolution solution = new RemoveElementSolution();
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}

class RemoveElementSolution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

class RemoveElementSolution_2 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                if (nums[i] == val) --i;
                length--;
            }
        }
        return length;
    }
}