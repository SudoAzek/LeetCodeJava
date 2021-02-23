package array_and_string.introduction_to_array;

import java.util.Arrays;

public class IntroToArray {
    public static void main(String[] args) {
        // 1. Initialize
        int[] a0 = new int[5];
        int[] a1 = {1, 2, 3};

        // 2. Get length
        System.out.println("The size of a1 is: " + a1.length);

        // 3. Access Element
        System.out.println("The first element is: " + a1[0]);

        // 4. Iterate all Elements
        System.out.print("[Version 1] The contents of a1 are: ");
        for (int i = 0; i < a1.length; i++) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();

        System.out.print("[Version 2] The contents of a1 are: ");
        for (int item : a1) {
            System.out.print(" " + item);
        }
        System.out.println();

        // 5. Modify Element
        a1[0] = 4;

        // 6. Sort
        Arrays.sort(a1);

        // 7. Iterate all Elements after sort
        System.out.print("The sorted contents of a1 are: ");
        for (int item : a1) {
            System.out.print(" " + item);
        }
        System.out.println();
    }
}
