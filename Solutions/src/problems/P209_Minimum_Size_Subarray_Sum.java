package problems;

public class P209_Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int runningSum = 0;
            int min = 0;
            while (j < nums.length) {
                if (runningSum < target) {
                    runningSum += nums[j++];
                    min++;
                } else {
                    break;
                }
                if (runningSum == target) {
                    minLen = Math.min(minLen, min);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        /*
                    [1,2,3,4,5]
            right:           r
            left:    l
            sum: 12
        */
        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
