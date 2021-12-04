package problems;

public class P1480_Running_Sum_of_1d_Array {
    public static void main(String[] args) {
        Solution_Running_Sum_of_1d_Array sol = new Solution_Running_Sum_of_1d_Array();
        System.out.println(sol.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }
}

class Solution_Running_Sum_of_1d_Array {
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
