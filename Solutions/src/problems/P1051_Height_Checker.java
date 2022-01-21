package problems;

import java.util.Arrays;

public class P1051_Height_Checker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
    public static int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) count++;
        }
        return count;
    }
}
