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