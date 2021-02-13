package fun_with_arrays.introduction;

public class ArrayWithLoop {
    public static void main(String[] args) {
        int[] squareNumbers = new int[10];

        // Go through each of the Array indexes, from 0 to 9.
        for (int i = 0; i < squareNumbers.length ; i++) {
            // We need to be careful with the 0-indexing. The next square number
            // is given by (i + 1) * (i + 1).
            // Calculate it and insert it into the Array at index i.
            int square = (i + 1) * (i + 1);
            squareNumbers[i] = square;
        }

        // Go through each the Array indexes, from 0 to 9.
        for (int i = 0; i < squareNumbers.length; i++ ) {
            // Access and print what's at the i'th index.
            System.out.println(squareNumbers[i]);
        }

        // For each VALUE in the Array
        for (int i : squareNumbers) {
            // Print the current value of square.
            System.out.println(i);
        }
    }
}
