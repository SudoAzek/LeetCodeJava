package february_daily_challenge;

public class D27_DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegersSolution solution = new DivideTwoIntegersSolution();
        System.out.println(solution.divide(-2147483648,  -1));
    }
}

/*
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        sign = 1
        if(divisor < 0 and dividend > 0) or (divisor > 0 and dividend < 0):
            sign = -1
        divisor = abs(divisor)
        dividend = abs(dividend)
        quotient = 0

        while dividend - divisor >= 0:
            i = 0
            while(dividend - (divisor << 1 << i)) >= 0:
                i += 1
            quotient += 1 << i
            dividend -= divisor << i

        quotient *= sign

        return 2147483647 if (~~quotient > 2147483647) else ~~ quotient



        class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        res, flag = 0, 0
        if (dividend < 0 and divisor > 0) or (dividend > 0 and divisor < 0):
            flag = -1
        dividend, divisor = abs(dividend), abs(divisor)
        while dividend >= divisor:
            n = 0
            while dividend >= divisor << n:
                n += 1
            res += 1 << (n - 1)
            dividend -= (divisor << (n-1))
        res = -res if flag == -1 else res
        if res < -2147483648 or res > 2147483647:
            return 2147483647
        return res
 */
class DivideTwoIntegersSolution {
    public int divide(int dividend, int divisor) {
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dividendd = Math.abs((long)dividend);
        divisor = Math.abs(divisor);
        int count = 0;

        while (dividendd >= divisor) {
            dividendd -= divisor;
            count++;
        }
        return count * sign;
    }
}

