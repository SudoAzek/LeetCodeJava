package fun_with_arrays.searching_for_items_in_an_array.problems;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,0,10,-19,4,6,-8};
        CheckIfNAndItsDoubleExistSolution solution = new CheckIfNAndItsDoubleExistSolution();
        System.out.println(solution.checkIfExist(arr));
    }
}

class CheckIfNAndItsDoubleExistSolution {
    public boolean checkIfExist(int[] arr) {
        for (int value : arr) {
            for (int j = 1; j < arr.length; j++) {
                if (value == (2 * arr[j]) || arr[j] == (2 * value)) return true;
            }
        }
        return false;
    }
}