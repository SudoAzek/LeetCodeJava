package august_daily_challenge;

import java.util.*;

public class D01_MakingALargeIsland {
    public static void main(String[] args) {
        MakingALargeIslandSolution solution = new MakingALargeIslandSolution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{{1, 0}, {0, 1}}));
    }
}

class MakingALargeIslandSolution {
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
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] < 1) return 0;
        grid[i][j] = 0;
        return 1 + traverse(i - 1, j, grid) + traverse(i, j - 1, grid) + traverse(i + 1, j, grid) + traverse(i, j + 1, grid);
    }
}

class MakingALargeIslandSolution2 {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int largestIsland(int[][] grid) {
        int N = grid.length;

        int ans = 0;
        boolean hasZero = false;
        for (int rows = 0; rows < N; ++rows)
            for (int cols = 0; cols < N; ++cols)
                if (grid[rows][cols] == 0) {
                    hasZero = true;
                    grid[rows][cols] = 1;
                    ans = Math.max(ans, check(grid, rows, cols));
                    grid[rows][cols] = 0;
                }

        return hasZero ? ans : N * N;
    }

    public int check(int[][] grid, int r0, int c0) {
        int N = grid.length;
        Stack<Integer> stack = new Stack();
        Set<Integer> seen = new HashSet();
        stack.push(r0 * N + c0);
        seen.add(r0 * N + c0);

        while (!stack.isEmpty()) {
            int code = stack.pop();
            int r = code / N, c = code % N;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!seen.contains(nr * N + nc) && 0 <= nr && nr < N &&
                        0 <= nc && nc < N && grid[nr][nc] == 1) {
                    stack.push(nr * N + nc);
                    seen.add(nr * N + nc);
                }
            }
        }

        return seen.size();
    }
}


class MakingALargeIslandSolution3 {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int[][] grid;
    int N;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        N = grid.length;

        int index = 2;
        int[] area = new int[N * N + 2];
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 1)
                    area[index] = dfs(r, c, index++);

        int answer = 0;
        for (int x : area) answer = Math.max(answer, x);
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet();
                    for (Integer move : neighbors(r, c))
                        if (grid[move / N][move % N] > 1)
                            seen.add(grid[move / N][move % N]);

                    int bns = 1;
                    for (int i : seen) bns += area[i];
                    answer = Math.max(answer, bns);
                }

        return answer;
    }

    public int dfs(int r, int c, int index) {
        int ans = 1;
        grid[r][c] = index;
        for (Integer move : neighbors(r, c)) {
            if (grid[move / N][move % N] == 1) {
                grid[move / N][move % N] = index;
                ans += dfs(move / N, move % N, index);
            }
        }

        return ans;
    }

    public List<Integer> neighbors(int r, int c) {
        List<Integer> ans = new ArrayList();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N)
                ans.add(nr * N + nc);
        }

        return ans;
    }
}

class MakingALargeIslandSolution4 {
    int[] sizes;
    int cur_size = 0;
    int res = 0;

    public int largestIsland(int[][] grid) {
        int ino = 2;
        int n = grid.length;
        sizes = new int[n * n + 10];
        res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    cur_size = 0;
                    dfs(grid, i, j, ino);
                    sizes[ino] = cur_size;
                    ++ino;
                    res = Math.max(res, cur_size);
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int newsize = 1;
                    int up = i > 0 ? grid[i - 1][j] : 0;
                    int down = i < n - 1 ? grid[i + 1][j] : 0;
                    int left = j > 0 ? grid[i][j - 1] : 0;
                    int right = j < n - 1 ? grid[i][j + 1] : 0;

                    newsize += sizes[up];
                    if (up != down) newsize += sizes[down];
                    if (left != down && left != up) newsize += sizes[left];
                    if (right != down && right != up && right != left) newsize += sizes[right];


                    res = Math.max(res, newsize);
                }
            }
        }

        return res;
    }

    void dfs(int[][] grid, int i, int j, int ino) {
        int n = grid.length;
        if (i < 0 || i == n || j < 0 || j == n || grid[i][j] != 1) return;
        ++cur_size;
        grid[i][j] = ino;
        dfs(grid, i - 1, j, ino);
        dfs(grid, i + 1, j, ino);
        dfs(grid, i, j - 1, ino);
        dfs(grid, i, j + 1, ino);
    }
}