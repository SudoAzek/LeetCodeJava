package contests.WeeklyContest229;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        MinimumNumberOfOperationsToMoveAllBallsToEachBoxSolution solution = new MinimumNumberOfOperationsToMoveAllBallsToEachBoxSolution();
        System.out.println(Arrays.toString(solution.minOperations("001011")));
    }

}

class MinimumNumberOfOperationsToMoveAllBallsToEachBoxSolution {
    public int[] minOperations(String boxes) {
        int sum = 0;
        int[] arr = new int[boxes.length()];
        char[] chars = boxes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '0') {
                    continue;
                } else {
                    sum += Math.abs(i - j);
                }
            }
            arr[i] = sum;
            sum = 0;
        }
        return arr;
    }
}