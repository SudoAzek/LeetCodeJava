package april_daily_challenge;

public class D25_RotateImage {
    public static void main(String[] args) {

    }
}

class RotateImageSolution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, depth = n / 2;
        for (int i = 0; i < depth; i++) {
            int length = n - 2 * i - 1, opposite = n - 1 - i;
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[opposite - j][i];
                matrix[opposite - j][i] = matrix[opposite][opposite - j];
                matrix[opposite][opposite - j] = matrix[i + j][opposite];
                matrix[i + j][opposite] = temp;
            }
        }
    }
}


class RotateImageSolution1 {
    public void rotate(int[][] matrix) {
        int m = matrix.length-1;

        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix.length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}