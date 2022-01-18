package problems;

public class P1089_Duplicate_Zeros {
    public static void main(String[] args) {

    }


    public void duplicateZeros(int[] arr) {
        // [1,0,2,3,0,4,5,0]

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--)
                    arr[j] = arr[j - 1];
                i++;
            }
        }
    }

    public void duplicateZeros2(int[] arr) {
        // [1,0,2,3,0,4,5,0]

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    public void duplicateZeros3(int[] arr) {
        if (arr.length < 2) return;

        int zeroes = 0;
        int j = arr.length - 1;

        for (int i = 0; i <= j - zeroes; i++) {
            if (arr[i] == 0) {
                if (i == j - zeroes) {
                    arr[j] = 0;
                    j--;
                    break;
                }
                zeroes++;
            }
        }
        int k = j - zeroes;
        while (k >= 0) {
            if (arr[k] == 0) {
                arr[j] = 0;
                j--;
            }
            arr[j] = arr[k];
            k--;
            j--;
        }
    }
}
