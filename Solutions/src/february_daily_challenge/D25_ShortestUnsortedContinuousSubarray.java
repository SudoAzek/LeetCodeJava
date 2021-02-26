package february_daily_challenge;

public class D25_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarraySolution solution = new ShortestUnsortedContinuousSubarraySolution();
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}

class ShortestUnsortedContinuousSubarraySolution {
    public int findUnsortedSubarray(int[] nums) {
        int k = 0, m = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 1; j >= 0; i++, j--) {
            max = Math.max(max, nums[i]);
            if (nums[i] != max) m = i;

            min = Math.min(min, nums[j]);
            if (nums[j] != min) k = j;
        }
        return (m - k + 1);
    }
}

class ShortestUnsortedContinuousSubarraySolution_2 {
    // stack space O(n)
    // stack used to track numbers bigger than all previous numbers
    // at each index i
    // compare with numbers in stack, if bigger than the top one, add it to the stack as it's bigger than all previous numbers
    // if smaller than the top one, keep popping the top one and store the topest one
    // in the end, add the topest one back to the stack(stack still holds its assumption)
    // during this process, the smaller index is the end of the continuous subarray
    // the starting index is the smallist  poped out index
    // public int findUnsortedSubarray(int[] nums) {
    //     Stack<Integer> stack = new Stack<>();
    //     int start = nums.length;
    //     int end = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
    //             stack.add(i);
    //         } else {
    //             end = i;
    //             int top = stack.peek();
    //             while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
    //                 start = Math.min(stack.pop(), start);
    //             }
    //             stack.add(top);
    //         }
    //     }
    //     if (start == nums.length) {
    //         return 0;
    //     }
    //     return end - start + 1;
    // }

    // by observing the above solution, actually we can get rid of the stack by doing the two direction scan
    public int findUnsortedSubarray(int[] nums) {
        int end = 0;
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= num) {
                num = nums[i];
            } else {
                end = i;
            }
        }
        int start = nums.length;
        num = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] <= num) {
                num = nums[j];
            } else {
                start = j;
            }
        }
        if (start == nums.length) {
            return 0;
        }
        return end - start + 1;
    }
}