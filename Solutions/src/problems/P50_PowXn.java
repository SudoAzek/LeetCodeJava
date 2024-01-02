package problems;

import org.w3c.dom.ls.LSOutput;

public class P50_PowXn {
    public static void main(String[] args) {
        PowXn_Solution solution = new PowXn_Solution();
        System.out.printf("%f", (solution.myPow(1.00000, 2147483647)));
    }
}


class PowXn_Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while (n != 0) {
            if ((n & 1) != 0) pow *= x;

            x *= x;
            n >>>= 1;
        }
        return pow;
    }

    public double myPowMy(double x, int n) {

        if (n != 0) {
            int m = Math.abs(n);
            double pow = 1;
            while (m > 0) {
                pow *= x;
                m--;
            }

            if (n > 0) {
                return pow;
            } else {
                return 1.0 / pow;
            }
        }
        return 1.0;
    }
}