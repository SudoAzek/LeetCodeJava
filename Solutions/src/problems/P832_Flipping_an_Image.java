package problems;

public class P832_Flipping_an_Image {
}

class Solution_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] flipped = new int[image.length][image[0].length];
        int b = image[0].length - 1;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <= b; j++) {
                flipped[i][j] = Math.abs(1 - image[i][b - j]);
            }
        }
        return flipped;
    }
}

class Solution_Flipping_an_Image2 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}