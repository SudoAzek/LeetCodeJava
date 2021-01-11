package easy.math;

public class P9_Palindrome_Number {
    public static void main(String[] args) {
        NumPalindrome numPalindrome = new NumPalindrome();
        int x = 1994;
        System.out.println(numPalindrome.isPalindrome(x));
    }
}

/* Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
   Follow up: Could you solve it without converting the integer to string?
*/

class NumPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
