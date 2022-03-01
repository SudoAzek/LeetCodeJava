package problems;

public class P338_Counting_Bits {
}

class Solution_Counting_Bits {
    public int[] countBits(int n) {
        int cnt = 0;
        int[] ans = new int[n + 1];
        String str = "";

        for (int i = n; i > 0; i--) {
            str = Integer.toBinaryString(i);

            char[] c = str.toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '1') cnt++;
            }
            ans[i] = cnt;
            cnt = 0;
        }
        return ans;
    }
}


class Solution_Counting_Bits2 {
    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = a[i / 2] + i % 2;
        }
        return a;

    }
}

class Solution_Counting_Bits3 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = solveFor(i);
        }
        return result;
    }

    public int solveFor(int n) {
        if (n == 0 || n == 1) return n;

        if (n % 2 == 0) {
            return solveFor(n / 2);
        } else {
            return 1 + solveFor(n / 2);
        }
    }
}

class Solution_Counting_Bits3_with_Memo {
    public int[] countBits(int n) {
        int result[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = solveFor(i, result);
        }

        return result;
    }

    public int solveFor(int n, int[] memo) {
        if (n == 0 || n == 1) return n;

        if (memo[n] != 0) {
            return memo[n];
        }
        if (n % 2 == 0) {
            memo[n] = solveFor(n / 2, memo);
            return memo[n];
        } else {
            memo[n] = 1 + solveFor(n / 2, memo);
            return memo[n];
        }
    }
}