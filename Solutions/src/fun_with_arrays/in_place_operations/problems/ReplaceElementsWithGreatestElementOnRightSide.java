package fun_with_arrays.in_place_operations.problems;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSideSolution sol = new ReplaceElementsWithGreatestElementOnRightSideSolution();
        int[] array = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(sol.replaceElements(array)));
    }
}

class ReplaceElementsWithGreatestElementOnRightSideSolution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (max < arr[i]) {
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            } else {
                arr[i] = max;
            }
        }
        return arr;
    }
}

class ReplaceElementsWithGreatestElementOnRightSideSolution_1 {
    public int[] replaceElements(int[] arr) {
        int length = arr.length - 1;
        for (int i = 0; i <= length; i++) {
            int greatest = 0;
            if (i < length) {
                greatest = arr[i + 1];
            } else {
                greatest = -1;
            }

            for (int j = i + 1; j <= length; j++) {
                if (greatest < arr[j]) greatest = arr[j];
            }
            arr[i] = greatest;
        }
        return arr;
    }
}