package april_daily_challenge;

public class D28_UniquePathsII {
}

class UniquePathsIISolution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int l1 = obstacleGrid.length, l2 = obstacleGrid[0].length;
        int[][] dp = new int[l1][l2];
        dp[0][0] = 1;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (obstacleGrid[i][j] == 1 || (i == 0 && j == 0)) continue;
                else dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0);
            }
        }
        return dp[l1 - 1][l2 - 1];
    }
}

class UniquePathsIISolution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;

        //filling the first row
        for (int i = 1; i < r; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        //filling the first column
        for (int j = 1; j < c; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                obstacleGrid[i][j] = (obstacleGrid[i][j] == 1) ? 0 : (obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]);

            }
        }
        return obstacleGrid[r - 1][c - 1];
    }
}