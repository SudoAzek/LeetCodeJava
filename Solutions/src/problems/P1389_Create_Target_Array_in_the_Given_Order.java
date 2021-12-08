package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1389_Create_Target_Array_in_the_Given_Order {
    public static void main(String[] args) {
        Solution_Create_Target_Array_in_the_Given_Order sol = new Solution_Create_Target_Array_in_the_Given_Order();
        System.out.println(Arrays.toString(sol.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
    }
}

class Solution_Create_Target_Array_in_the_Given_Order {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target;
        List<Integer> targetList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }

        target = targetList.stream().mapToInt(i -> i).toArray();
        return target;
    }
}

class Solution_Create_Target_Array_in_the_Given_Order2 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < index.length; i++) {
            result.add(index[i], nums[i]);
        }
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = result.get(i);
        }
        return target;
    }
}
