package june_daily_challenge;

public class D01_MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIslandSolution solution = new MaxAreaOfIslandSolution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1}}));


//        (new int[][]{
//                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }
}

class MaxAreaOfIslandSolution {
    private int n, m;

    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) answer = Math.max(answer, traverse(i, j, grid));
            }
        }
        return answer;
    }

    private int traverse(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] < 1) return 0; // Traverse function edge case
        grid[i][j] = 0;
        return 1 + traverse(i - 1, j, grid) + traverse(i, j - 1, grid) + traverse(i + 1, j, grid) + traverse(i, j + 1, grid);
    }
}

class MaxAreaOfIslandSolution2 {
    int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, area(i, j));
                }
            }
        }
        return ans;
    }

    private int area(int i, int j) { // Recursive call
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + area(i - 1, j) + area(i + 1, j) + area(i, j - 1) + area(i, j + 1);
    }
}

// Solution with using boolean 2D array instead of setting each cell to 0
class MaxAreaOfIslandSolution3 {
    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) { // Recursive call
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0) return 0;
        seen[r][c] = true;
        return (1 + area(r + 1, c) + area(r - 1, c) + area(r, c - 1) + area(r, c + 1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int answer = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                answer = Math.max(answer, area(r, c));
            }
        }
        return answer;
    }
}

