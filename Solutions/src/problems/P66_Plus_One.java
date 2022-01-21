package problems;

import java.util.Arrays;

public class P66_Plus_One {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    // Not working with large numbers
    public int[] plusOne2(int[] digits) {
        long result = 0;

        int j = digits.length - 1;
        for (int i = 0; i < digits.length; i++) {
            long calc = (long) Math.pow(10, j--) * digits[i];
            result += calc;
        }
        result = result + 1;

        int length = String.valueOf(result).length();

        int[] resultArr = new int[length];
        for (int i = resultArr.length - 1; i >= 0; i--) {
            resultArr[i] = (int)(result % 10);
            result /= 10;
        }

        return resultArr;
    }
}
