package problems;

public class P485_Max_Consecutive_Ones {
    public static void main(String[] args) {
        P485_Max_Consecutive_Ones sol = new P485_Max_Consecutive_Ones();
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int onesCount = 0;
        for (int number : nums) {
            if (number == 1) {
                onesCount++;
            } else {
                onesCount = 0;
            }
            ans = Math.max(ans, onesCount);
        }
        return ans;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int tempCount = 0, numOfOnes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempCount++;

                if (tempCount > numOfOnes) {
                    numOfOnes = tempCount;
                }
            } else {
                tempCount = 0;
            }
        }
        return numOfOnes;
    }
}
