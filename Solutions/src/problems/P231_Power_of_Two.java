package problems;

public class P231_Power_of_Two {
    public static void main(String[] args) {
        Solution_Power_of_Two sol = new Solution_Power_of_Two();
        System.out.println(sol.isPowerOfTwo(256));
    }
}

class Solution_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
