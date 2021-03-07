package easy;

public class P441_ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoinsSolution arrangingCoinsSolution = new ArrangingCoinsSolution();
        ArrangingCoinsSolution_1 arrangingCoinsSolution_1 = new ArrangingCoinsSolution_1();
        ArrangingCoinsSolution_2 arrangingCoinsSolution_2 = new ArrangingCoinsSolution_2();
        System.out.println(arrangingCoinsSolution.arrangeCoins(8));
        System.out.println(arrangingCoinsSolution_1.arrangeCoins(8));
        System.out.println(arrangingCoinsSolution_2.arrangeCoins(8));
    }
}

class ArrangingCoinsSolution {
    public int arrangeCoins(int n) {
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            if(n >= i) {
                n -= i;
                count++;
            }
        }
        return count;
    }
}

class ArrangingCoinsSolution_1 {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}

class ArrangingCoinsSolution_2 {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        long k, curr;
        while (left <= right) {
            k = left + (right - left) / 2;
            curr = k * (k + 1) / 2;

            if (curr == n) return (int)k;

            if (n < curr) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return (int)right;
    }
}