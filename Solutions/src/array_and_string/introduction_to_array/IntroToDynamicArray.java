package array_and_string.introduction_to_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntroToDynamicArray {
    public static void main(String[] args) {
        // 1. Initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null

        // 2. Cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));

        // 3. Make a copy
        List<Integer> v2 = v1;                      // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1

        // 4. Get length
        System.out.println("The size of v1 is: " + v1.size());

        // 5. Access element
        System.out.println("The first element of v1 is: " + v1.get(0));

        // 6. Iterate the vector
        System.out.print("[Version 1] The contents of v1 are:");
        for (int i = 0; i < v1.size(); i++) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();

        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();

        // 7. Modify element
        v2.set(0, 5);                               // modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is: " + v1.get(0));
        System.out.println("The first element in v3 is: " + v3.get(0));

        // 8. Sort
        Collections.sort(v1);

        // 9. Iterate all vector elements after sort
        System.out.print("The sorted contents of v1 are: ");
        for (int i = 0; i < v1.size(); i++) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();

        // 10. Add new element at the end of the vector
        v1.add(-1);
        v1.add(1, 6);

        // 11. Iterate all vector elements after adding new element at the end
        System.out.print("The contents of v1 are: ");
        for (int i = 0; i < v1.size(); i++) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();

        // 12. Delete the last element
        v1.remove(v1.size() - 1);

        // 13. Iterate all vector elements after deleting an element from the end
        System.out.print("The contents of v1 after deleting the last element:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();
    }
}
