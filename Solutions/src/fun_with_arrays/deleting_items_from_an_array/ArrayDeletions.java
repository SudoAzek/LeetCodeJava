package fun_with_arrays.deleting_items_from_an_array;

public class ArrayDeletions {
    public static void main(String[] args) {
        ArrayDeletionOperations arrayDeletionOperations = new ArrayDeletionOperations();
        arrayDeletionOperations.createAndDelete();
    }
}

class ArrayDeletionOperations {
    void createAndDelete() {
        // Deleting from the end of an array

        // Declare an integer array of 10 elements.
        int[] intArray = new int[10];

        // The array currently contains 0 elements.
        int length = 0;

        // Add elements at the first 6 indexes of the array
        for (int i = 0; i < 6; i++) {
            intArray[length] = i;
            length++;
        }

        // Deleting from the end is as simple as reducing the length of the array by 1.
        length--;

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }
        System.out.println();

        for (int i = 0; i < length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }
        System.out.println();

        // Deleting from the start of an array

        // Starting at index 1, we shift each element by one position to the left
        for (int i = 1; i < length; i++) {
            // Shift each element one position to the left
            intArray[i - 1] = intArray[i];
        }
        length--;

        for (int i = 0; i < length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }

        // Deleting from anywhere in the array

        // Say we want to delete the element at index 1
        for (int i = 1; i < length; i++) {
            // Shift each element one position to the left
            intArray[i - 1] = intArray[i];
        }
        // Again, the length needs to be consistent with the current state of the array.
        length--;
    }
}
