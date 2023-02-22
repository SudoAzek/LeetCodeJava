package problems;

import java.util.Arrays;

public class P43_Multiply_Strings {
    public static void main(String[] args) {
        Solution_Multiply_Strings sol = new Solution_Multiply_Strings();
        System.out.println(sol.multiply("2642", "5821"));
    }
}


class Solution_Multiply_Strings {
    public String multiply(String num1, String num2) {
        int size = num1.length();
        int m;
        int carry;
        int[] Z = new int[2 * size];
        for (int i = size - 1; i >= 0; i--) {
            carry = 0;
            for (int j = size - 1; j >= 0; j--) {
                System.out.println(num1.charAt(j));
                System.out.println(num2.charAt(i));
                m = Z[(i + j) + 1] + carry + Character.getNumericValue(num1.charAt(j)) * Character.getNumericValue(num2.charAt(i));
                Z[(i + j) + 1] = m % 10;
                carry = m / 10;
            }
            Z[i] = carry;
        }

        String str = String.join("", Arrays.stream(Z).mapToObj(String::valueOf).toArray(String[]::new));
        int ind = 0;
        for (int i = 0; i < str.length(); i++) {
            char p = str.charAt(i);
            if (p != '0') {
                ind = i;
                break;
            }
        }
        return str.substring(ind);
    }
}