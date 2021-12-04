package problems;

public class P1672_Richest_Customer_Wealth {
    public static void main(String[] args) {
        Solution_Richest_Customer_Wealth sol = new Solution_Richest_Customer_Wealth();
        System.out.println(sol.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }
}

class Solution_Richest_Customer_Wealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            maxWealth = Math.max(maxWealth, sum);
        }
        return maxWealth;
    }
}