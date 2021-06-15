package june_daily_challenge;

import java.util.Arrays;

public class D14_MaximumUnitsOnATruck {
    public static void main(String[] args) {
        MaximumUnitsOnATruckSolution solution = new MaximumUnitsOnATruckSolution();
        System.out.println(solution.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }

}

class MaximumUnitsOnATruckSolution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int answer = 0;
        for (int[] b : boxTypes) {
            int count = Math.min(b[0], truckSize);
            answer += count * b[1];
            truckSize -= count;
            if (truckSize == 0) return answer;
        }
        return answer;
    }
}

class MaximumUnitsOnATruckSolution2 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        int[] buckets = new int[1001];

        for (int i = 0; i < n; i++) {
            buckets[boxTypes[i][1]] += boxTypes[i][0];
        }

        int cap = truckSize;
        int units = 0;
        for (int i = 1000; i >= 1; i--) {
            if (buckets[i] > 0) {
                if (buckets[i] > cap) {
                    units += cap * i;
                    return units;
                } else {
                    units += buckets[i] * i;
                }
                cap -= buckets[i];
            }
        }
        return units;
    }
}
