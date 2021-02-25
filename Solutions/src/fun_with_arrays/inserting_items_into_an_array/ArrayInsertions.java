package fun_with_arrays.inserting_items_into_an_array;

/*
    Inserting a new element into an Array can take many forms:
    1.  Inserting a new element at the end of the Array.
    2.  Inserting a new element at the beginning of the Array.
    3.  Inserting a new element at any given index inside the Array.
 */

public class ArrayInsertions {
    public static void main(String[] args) {
        ArrayInsertionOperations arrayInsertionOperations = new ArrayInsertionOperations();
        arrayInsertionOperations.createAndInsert();
    }
}

class ArrayInsertionOperations {
    void createAndInsert() {
        // Declare an integer array of 6 elements
        int[] intArray = new int[6];
        int length = 0;

        // Add 3 elements to the array
        for (int i = 0; i < 3; i++) {
            intArray[length] = i;
            length++;
        }

        // Insert a new element at the end of the Array. Again, it's important to ensure
        // that there is enough space in the array for inserting a new element.
        intArray[length] = 10;
        length++;

        // To insert an element at the start of an array, first we will have to create space for a new element.
        // We do that by shifting each element one index to the right. This will firstly move the element at index 3,
        // then 2, then 1, then finally zero. We need to go backwards to avoid overwriting any elements.
        for (int i = 3; i >= 0; i--) {
            // Shift each element one position to the right starting from index 0.
            intArray[i + 1] = intArray[i];
        }
        intArray[0] = 20;

        // To insert an element at the anywhere of an array, say we want to insert the element at index 2.
        // First, we will have to create a space for the new element
        for (int i = 4; i >= 2; i--) {
            // Shift each element one position to the right starting from index 2.
            intArray[i + 1] = intArray[i];
        }
        intArray[2] = 30;

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }
    }
}