package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1313_Decompress_Run_Length_Encoded_List {
    public static void main(String[] args) {
        Solution_Decompress_Run_Length_Encoded_List sol = new Solution_Decompress_Run_Length_Encoded_List();
        System.out.println(Arrays.toString(sol.decompressRLElist(new int[]{1, 2, 3, 4})));
    }
}

class Solution_Decompress_Run_Length_Encoded_List {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int count = nums[i];
            while (count > 0) {
                lst.add(nums[i + 1]);
                count--;
            }
        }
        return lst.stream().mapToInt(i -> i).toArray();
    }
}

class Solution_Decompress_Run_Length_Encoded_List2 {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2)
            len += nums[i];

        int[] res = new int[len];
        int startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(res, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return res;
    }
}

class Solution_Decompress_Run_Length_Encoded_List3 {
    public int[] decompressRLElist(int[] nums) {
        int sum = 0, index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        int[] res = new int[sum];
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[index++] = nums[i + 1];
            }
        }
        return res;
    }
}