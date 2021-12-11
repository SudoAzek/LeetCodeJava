package problems;

import java.util.Arrays;

public class P566_Reshape_the_Matrix {
    public static void main(String[] args) {
        Solution_Reshape_the_Matrix sol = new Solution_Reshape_the_Matrix();
        System.out.println(Arrays.deepToString(sol.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }
}

class Solution_Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;

        int row = 0;
        int col = 0;

        int[][] reshape = new int[r][c];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                reshape[row][col] = mat[i][j];
                col++;

                if (col > c - 1) {
                    row++;
                    col = 0;
                }
            }
        }
        return reshape;
    }
}
