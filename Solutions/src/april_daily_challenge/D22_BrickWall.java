package april_daily_challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D22_BrickWall {
    public static void main(String[] args) {
        BrickWallSolution solution = new BrickWallSolution();
    }
}

class BrickWallSolution {
    int least = 0;
    Map<Integer, Integer> freq = new HashMap<>();

    public int leastBricks(List<List<Integer>> wall) {
        for (List<Integer> integers : wall) {
            processRow(integers);
        }
        return wall.size() - least;
    }

    public void processRow(List<Integer> row) {
        int rowSum = row.get(0);
        for (int i = 1; i < row.size(); i++) {
            int f = freq.getOrDefault(rowSum, 0) + 1;
            freq.put(rowSum, f);
            if (f > least) least = f;
            rowSum += row.get(i);
        }
    }
}