package fun_with_arrays.searching_for_items_in_an_array;

public class SearchInAnArray {
    public static void main(String[] args) {
        SearchInAnArrayOperations sol = new SearchInAnArrayOperations();
        // Declare a new array of 6 elements
        int[] array = new int[6];

        // Variable to keep track of the length of the Array
        int length = 0;

        // Iterate through the 6 indexes of the Array
        for (int i = 0; i < 6; i++) {
            array[length++] = i;
        }

        // Print out the results of searching for 4 and 30.

        System.out.println("Does the array contain the element 4? - " + sol.linearSearch(array, length, 4));
        System.out.println("Does the array contain the element 30? - " + sol.linearSearch(array, length, 30));

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    }
}

class SearchInAnArrayOperations {
    // Linear Search
    boolean linearSearch(int[] array, int length, int element) {
        // Check for edge cases. Is the array null or empty? If it is, then we return false because the element we're
        // searching for couldn't possibly be in it.
        if (array == null || length == 0) return false;

        // Carry out the linear search by checking the each element starting from the first one.
        for (int i = 0; i < length; i++) {
            // We found the element at index i. So we return true to say it exists.
            if (array[i] == element) return true;
        }
        // We didn't find the element in the array.
        return false;
    }
}