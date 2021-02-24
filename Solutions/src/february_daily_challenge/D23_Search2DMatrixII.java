package february_daily_challenge;

public class D23_Search2DMatrixII {
    public static void main(String[] args) {
        Search2DMatrixIISolution sol = new Search2DMatrixIISolution();
        System.out.println(sol.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 13));
    }
}

class Search2DMatrixIISolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int col = matrix[0].length - 1;
        for (int i = 0; i < matrix.length && col >= 0;) {
            if (matrix[i][col] == target) {
                return true;
            } else if (matrix[i][col] > target) {
                col--;
            } else {
                i++;
            }
        }
        return false;
    }
}

class Search2DMatrixIISolution_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            int start = 0;
            int end = matrix[0].length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] < target) start = ++mid;
                else end = mid - 1;
            }
        }
        return false;
    }
}

class Search2DMatrixIISolution_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lenA = matrix.length - 1;
        int lenB = matrix[0].length - 1;
        while (matrix[0][lenA] > target) {
            lenA = lenA / 2;
        }
        while (matrix[lenB][0] > target) {
            lenB = lenB / 2;
        }
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (target == matrix[i][j]) return true;
            }
        }
        return false;
    }
}

class Search2DMatrixIISolution_3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int start = 0;
            int end = matrix[0].length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (ints[mid] == target) return true;
                else if (ints[mid] < target) start = ++mid;
                else end = --mid;
            }
        }
        return false;
    }
}
