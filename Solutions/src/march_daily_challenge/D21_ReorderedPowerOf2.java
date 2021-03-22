package march_daily_challenge;

import java.util.Arrays;

public class D21_ReorderedPowerOf2 {
    public static void main(String[] args) {
        ReorderedPowerOf2Solution sol = new ReorderedPowerOf2Solution();
        System.out.println(sol.reorderedPowerOf2(1994));
    }
}

class ReorderedPowerOf2Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] res1 = String.valueOf(N).toCharArray();
        Arrays.sort(res1);
        for (int i = 0; i < 30; i++) {
            char[] res2 = String.valueOf(1 << i).toCharArray();
            Arrays.sort(res2);
            if (Arrays.equals(res1, res2)) return true;
        }
        return false;
    }
}