package problems;

public class P498_Diagonal_Traverse {
    public static void main(String[] args) {

    }

    public int[] findDiagonalOrder(int[][] mat) {
        int lenVert = mat.length;
        int lenHor = mat[0].length;

        int rowIdx = 0;
        int colIdx = 0;

        int[] resultArr = new int[lenVert * lenHor];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = mat[rowIdx][colIdx];
            if ((rowIdx + colIdx) % 2 == 0) {
                if (colIdx == lenHor - 1) { rowIdx++; }
                else if (rowIdx == 0) { colIdx++; }
                else { rowIdx--; colIdx++; }
            } else {
                if (rowIdx == lenVert - 1) { colIdx++; }
                else if (colIdx == 0) { rowIdx++; }
                else { rowIdx++; colIdx--; }
            }
        }
        return resultArr;
    }
}
