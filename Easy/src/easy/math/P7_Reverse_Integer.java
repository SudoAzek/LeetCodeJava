package easy.math;

public class P7_Reverse_Integer {
    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int x = 1994;
        System.out.println(solution_1.reverse(x));
    }
}

/* Given a 32-bit signed integer, reverse the digits of an integer.

Note: Assume we are dealing with an environment that could only store integers with 32-bit signed integer range:
[12^31, 12^31 - 1]. For this problem, assume that the function returns 0 when the reversed integer overflows.
 */
class Solution_1 {
    /* Approach 1: Pop and Push Digits & Check before Overflow.
    We can build up the reverse integer one digit at a time. While doing so, we can check beforehand whether or not
    appending another digit would cause overflow. */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 100 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}