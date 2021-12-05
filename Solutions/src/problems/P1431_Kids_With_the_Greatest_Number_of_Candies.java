package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1431_Kids_With_the_Greatest_Number_of_Candies {
    public static void main(String[] args) {
        Solution_Kids_with_the_Greatest_Number_of_Candies sol = new Solution_Kids_with_the_Greatest_Number_of_Candies();
        System.out.println(sol.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }
}


class Solution_Kids_with_the_Greatest_Number_of_Candies {
    List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> boolCandies = new ArrayList<>();
        int[] sortedArray = Arrays.copyOf(candies, candies.length);
        Arrays.sort(sortedArray);
        int max = sortedArray[sortedArray.length - 1];
        System.out.println(max);

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                boolCandies.add(true);
            } else {
                boolCandies.add(false);
            }
        }
        return boolCandies;
    }
}