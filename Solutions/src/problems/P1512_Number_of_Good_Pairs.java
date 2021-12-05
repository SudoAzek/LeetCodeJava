package problems;

import java.util.HashMap;

public class P1512_Number_of_Good_Pairs {
    public static void main(String[] args) {

    }
}

class Solution_Number_of_Good_Pairs {
    public int numIdenticalPairs(int[] nums) {
        int goodCnt = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j]) {
                    goodCnt++;
                }
            }
        }
        return goodCnt;
    }
}


class Solution_Number_of_Good_Pairs_HashMap {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                count += hm.get(nums[i]);
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else
                hm.put(nums[i], 1);
        }
        return count;
    }
}




