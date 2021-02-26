package fun_with_arrays.in_place_operations;

import java.util.Arrays;

public class InPlaceArrayOperations {
    public static void main(String[] args) {
        ArrayInPlaceOperations arrayInPlaceOperations = new ArrayInPlaceOperations();
        int[] array = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(Arrays.toString(arrayInPlaceOperations.squareEven(array, array.length)));
//        System.out.println(arrayInPlaceOperations.removeDuplicates(array));
        System.out.println(Arrays.toString(arrayInPlaceOperations.copyWithRemovedDuplicates(array)));
    }
}

class ArrayInPlaceOperations {
    public int[] squareEvenNaive(int[] array, int length) {
        // Check for the edge cases.
        if (array == null) return array;

        // Create a resultant Array which would hold the result.
        int[] result = new int[length];

        // Iterate through the original Array
        for (int i = 0; i < length; i++) {
            // Get the element from slot i of the input Array
            int element = array[i];

            // If the index is an even number, then we need to square the element
            if (i % 2 == 0) {
                element *= element;
            }

            // Write the element into the result Array
            result[i] = element;
        }

        // Return the result Array
        return array;
    }

    public int[] squareEven(int[] array, int length) {
        // Check for the edge cases.
        if (array == null) return array;

        // Iterate through the original Array
        for (int i = 0; i < length; i++) {
            // If the index is an even number, then we need to square the element and replace the original value in the Array.
            if (i % 2 == 0) {
                array[i] *= array[i];
            }
        }
        // Now, just need to return the original array
        return array;
    }

    public int removeDuplicates(int[] nums) {
        // The initial length is simply the capacity
        int length = nums.length;

        // Assume the last element is always unique. Then for each element, delete it iff it is the same as the one
        // after it. Use our deletion algorithm for deleting from any index
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                // Delete the element at index i, using our standard deletion algorithm algorithm we learned
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                length--;
            }
        }
        return length;
    }

    public int[] copyWithRemovedDuplicates(int[] nums) {
        // Check for edge cases
        if (nums == null || nums.length == 0) return nums;

        // Count how many unique elements are in the array.
        int uniqueNums = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i] != nums[i + 1]) uniqueNums++;
        }
        System.out.println(uniqueNums);

        // Create a result Array
        int[] result = new int[uniqueNums];

        // Write the unique elements into the result Array
        int positionInResult = 0;
        for (int i = 0; i < nums.length; i++) {
            // The same condition as in the previous loop. Except this time, we can write each unique number into the
            // result Array instead of just counting them
            if(i == 0 || nums[i - 1] != nums[i]) result[positionInResult++] = nums[i];
        }
        return result;
    }
}

