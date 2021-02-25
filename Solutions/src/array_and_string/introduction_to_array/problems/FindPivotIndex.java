package array_and_string.introduction_to_array.problems;

public class FindPivotIndex {
    public static void main(String[] args) {
        FindPivotIndexSolution sol = new FindPivotIndexSolution();
        System.out.println(sol.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
    }
}

class FindPivotIndexSolution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}

class FindPivotIndexSolution_1 {
    public int pivotIndex(int[] nums) {
        int right = nums.length - 1;

        int leftSum = nums[0];
        int rightSum = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (i >= right) return -1;
            if (leftSum == rightSum) return i;

            if (leftSum < rightSum) {
                leftSum += nums[i];
            } else {
                rightSum += nums[--right];
                --i;
            }
        }
        return -1;
    }
}