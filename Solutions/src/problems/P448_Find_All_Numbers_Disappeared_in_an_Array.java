package problems;

import java.util.ArrayList;
import java.util.List;

public class P448_Find_All_Numbers_Disappeared_in_an_Array {

    public static void main(String[] args) {

    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] countArr = new int[nums.length + 1];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            countArr[nums[i]]++;
        }

        for (int i = 1; i < countArr.length; i++) {
            if (countArr[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
