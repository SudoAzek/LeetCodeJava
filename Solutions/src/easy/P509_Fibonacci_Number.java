package easy;

public class P509_Fibonacci_Number {
    public static void main(String[] args) {
        System.out.println(FibonacciNumberSolution.fib(4));
    }
}

class FibonacciNumberSolution {
    public static int fib(int n) {
        if (n == 1) return 1;
        else if (n == 0) return 0;
        else return fib(n - 1) + fib(n - 2);
    }
}