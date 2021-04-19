package april_daily_challenge;

public class D15_FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumberSolution solution = new FibonacciNumberSolution();
        System.out.println(solution.fib(9));
    }
}

class FibonacciNumberSolution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return memo(n);
    }

    public int memo(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}