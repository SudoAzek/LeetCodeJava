package fun_with_arrays.inserting_items_into_an_array.problems;

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZerosSolution sol = new DuplicateZerosSolution();
        sol.duplicateZeros(new int[]{0, 4, 1, 0, 0, 8, 0, 0, 3});
    }
}

class DuplicateZerosSolution {
    public void duplicateZeros(int[] arr) {
        int zerocounts = 0;
        int len = arr.length - 1;
        for (int i = 0; i <= len - zerocounts; i++) {
            if (arr[i] == 0) {
                if (i == len - zerocounts) {
                    arr[len] = 0;
                    len--;
                    break;
                }
                zerocounts++;
            }
        }
        int last = len - zerocounts;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zerocounts] = 0;
                zerocounts--;
                arr[i + zerocounts] = 0;
            } else {
                arr[i + zerocounts] = arr[i];
            }
        }
    }
}

class DuplicateZerosSolution_2 {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--)
                    arr[j] = arr[j - 1];
                i++;
            }
        }

        for (int x : arr) {
            System.out.print(" " + x);
        }
        System.out.println();
    }
}

class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--)
                    arr[j] = arr[j - 1];
                i++;
            }
        }
    }
}