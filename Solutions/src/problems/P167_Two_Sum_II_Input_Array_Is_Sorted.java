package problems;

public class P167_Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {

        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {
            if (numbers[leftPointer] + numbers[rightPointer] == target) {
                return new int[]{leftPointer + 1, rightPointer + 1};
            }
            if (numbers[leftPointer] + numbers[rightPointer] > target) {
                rightPointer--;
            } else if (numbers[leftPointer] + numbers[rightPointer] < target) {
                leftPointer++;
            }
        }
        return new int[]{-1, -1};
    }
}
