package april_daily_challenge;

import java.util.Collections;
import java.util.List;

public class D21_Triangle {
    public static void main(String[] args) {
        TriangleSolution solution = new TriangleSolution();
//        System.out.println(solution.minimumTotal());
    }
}

class TriangleSolution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
            for (int col = 0; col <= row; col++) {
                int smallestAbove = Integer.MAX_VALUE;
                if (col > 0) {
                    smallestAbove = triangle.get(row - 1).get(col - 1);
                }
                if (col < row) {
                    smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(col));
                }
                int path = smallestAbove + triangle.get(row).get(col);
                triangle.get(row).set(col, path);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}

class TriangleSolution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        return recur(triangle, 0, 0, dp);
    }

    public int recur(List<List<Integer>> triangle, int row, int i, int[][] dp) {
        if (row == triangle.size()) {
            return 0;
        }
        if (dp[row][i] != 0) {
            return dp[row][i];
        }
        dp[row][i] = Math.min(triangle.get(row).get(i) + recur(triangle, row + 1, i, dp), triangle.get(row).get(i) + recur(triangle, row + 1, i + 1, dp));
        return dp[row][i];
    }
}