package problems;

public class P941_Valid_Mountain_Array {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[] {2,1}));
    }

    public static boolean validMountainArray(int[] arr) {
        int length = arr.length;
        int leftPointer = 0;
        int rightPointer = length - 1;

        while (leftPointer + 1 < length && arr[leftPointer + 1] > arr[leftPointer]) {
            leftPointer++;
        }
        while (rightPointer - 1 > 0 && arr[rightPointer - 1] > arr[rightPointer]) {
            rightPointer--;
        }

        return leftPointer > 0 && leftPointer == rightPointer && rightPointer < length - 1;
    }
}
