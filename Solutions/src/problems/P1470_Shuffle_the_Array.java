package problems;

public class P1470_Shuffle_the_Array {
}

class Solution_Shuffle_the_Array {
    public int[] shuffle(int[] nums, int n) {
        int arrLen = nums.length;
        int[] res = new int[arrLen];
        int j = 0;
        for (int i = 0; i < arrLen; i++) {
            if (i % 2 == 0) {
                res[i] = nums[i - j];
            } else {
                res[i] = nums[n + j];
                j++;
            }
        }
        return res;
    }
}

class Solution_Shuffle_the_Array_with_While {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];

        int j = 0;
        int i = 0;
        while (j < nums.length && i < n) {
            ans[j] = nums[j - i];
            ans[j + 1] = nums[j + n - i];
            j += 2;
            i++;
        }

        return ans;
    }
}

class Solution_Shuffle_the_Array_with_While2 {
    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[nums.length];
        int j = 0, i = 0, temp = n;
        while (i < n) {

            output[j] = nums[i];
            j++;
            output[j] = nums[temp];
            temp++;
            j++;
            i++;
        }
        return output;
    }
}