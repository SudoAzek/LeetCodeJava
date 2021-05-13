package may_daily_challenge;

public class D12_RangeSumQuery2DImmutable {
}

class NumMatrixSolution1 {
    long[][] dp;

    public void NumMatrix(int[][] matrix) {
        int yLen = matrix.length + 1, xLen = matrix[0].length + 1;
        dp = new long[yLen][xLen];
        for (int i = 1; i < yLen; i++) {
            for (int j = 1; j < xLen; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int)(dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


class NumMatrixSolution2 {

    private int[][] maxtrixSum;

    public void NumMatrix(int[][] matrix) {
        maxtrixSum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int currRunningSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    maxtrixSum[i][j] = currRunningSum + matrix[i][j];
                    currRunningSum = maxtrixSum[i][j];
                } else {
                    currRunningSum = matrix[i][j] + currRunningSum;
                    maxtrixSum[i][j] = maxtrixSum[i-1][j] + currRunningSum;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumOfBigbox =  maxtrixSum[row2][col2];
        int subtractLeftSide = 0;
        if (col1 != 0) {
            subtractLeftSide = maxtrixSum[row2][col1-1];
        }
        int subtractTopSide = 0;
        if (row1 != 0) {
            subtractTopSide = maxtrixSum[row1-1][col2];
        }
        int addBack = 0;
        if (col1 != 0 && row1 != 0) {
            addBack = maxtrixSum[row1-1][col1-1];
        }

        return sumOfBigbox - subtractLeftSide - subtractTopSide + addBack;
    }
}