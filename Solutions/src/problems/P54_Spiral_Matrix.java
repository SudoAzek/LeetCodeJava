package problems;

import java.util.ArrayList;
import java.util.List;

public class P54_Spiral_Matrix {
    public static void main(String[] args) {
        Solution_Spiral_Matrix sol = new Solution_Spiral_Matrix();
        System.out.println(sol.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}

class Solution_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) break;
        }
        return result;
    }
}
