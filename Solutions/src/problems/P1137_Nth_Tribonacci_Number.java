package problems;

public class P1137_Nth_Tribonacci_Number {
    public static void main(String[] args) {
        Solution_Nth_Tribonacci_Number sol = new Solution_Nth_Tribonacci_Number();
        System.out.println(sol.tribonacci(1));
    }
}

class Solution_Nth_Tribonacci_Number {
    public int tribonacci(int n) {
        int[] tee = new int[n + 1];
        if (n > 1) {

            tee[0] = 0;
            tee[1] = 1;
            tee[2] = 1;

            for (int i = 3; i <= n; i++) {
                tee[i] = tee[i - 3] + tee[i - 2] + tee[i - 1];
            }


            return tee[n];
        } else if (n == 1) {
            tee[0] = 0;
            tee[1] = 1;
            return tee[n];
        } else {
            return 0;
        }
    }
}

class Solution_Nth_Tribonacci_Number2 {
    public int tribonacci(int n) {
        // zero-index based, we need to return dp[n]
        int[] dp = new int[Math.max(n + 1, 3)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}