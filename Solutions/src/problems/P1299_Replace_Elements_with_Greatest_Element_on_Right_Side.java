package problems;

public class P1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
    public static void main(String[] args) {

    }

    public static int[] replaceElements(int[] arr) {
        int length = arr.length;
        int max = arr[length - 1];
        int nextMax = 0;

        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);

            arr[i] = nextMax;

            nextMax = max;
        }
        arr[length - 1] = -1;

        return arr;
    }
}
