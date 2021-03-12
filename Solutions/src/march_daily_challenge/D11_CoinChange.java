package march_daily_challenge;

import java.util.Arrays;

public class D11_CoinChange {
    public static void main(String[] args) {
        CoinChangeSolution solution = new CoinChangeSolution();
        System.out.println(solution.coinChange(new int[]{186,419,83,408},6249));
    }
}

class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int remainder, int[] count) {
        if (remainder < 0) return -1;
        if (remainder == 0) return 0;
        if (count[remainder - 1] != 0) return count[remainder - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, remainder - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[remainder - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remainder - 1];
    }
}

class CoinChangeSolution2 {
    public int coinChange(int[] coins, int amount){
        return -1;
    }
}

class CoinChangeSolutionFail {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0; long sum = 0;
        while (sum < amount) {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (sum + coins[i] > amount && i == 0) {
                    return -1;
                } else if ((sum + coins[i]) <= amount) {
                    sum += coins[i];
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}