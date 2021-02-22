package fun_with_arrays.introduction.problems;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnesSolution sol = new MaxConsecutiveOnesSolution();
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1}));
    }
}

class MaxConsecutiveOnesSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) count++;
            else count = 0;
            if (max < count) max = count;
        }
        return max;
    }
}

class MaxConsecutiveOnesSolution_1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                curr++;
            else
                curr = 0;
            if (curr > max)
                max = curr;
        }
        return max;
    }
}

class MaxConsecutiveOnesSolution_2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
}
