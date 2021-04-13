package april_daily_challenge;

import java.util.Arrays;

public class D12_BeautifulArrangementII {
    public static void main(String[] args) {
        BeautifulArrangementIISolution solution = new BeautifulArrangementIISolution();
        System.out.println(Arrays.toString(solution.constructArray(9, 3)));
    }
}

class BeautifulArrangementIISolution {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        for (int i = 0, a = 1, z = k + 1; i <= k ; i++) {
            answer[i] = i % 2 == 1 ? z-- : a++;
        }
        for (int i = k + 1; i < n;) {
            answer[i] = ++i;
        }
        return answer;
    }
}