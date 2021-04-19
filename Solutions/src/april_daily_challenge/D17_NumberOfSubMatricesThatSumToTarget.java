package april_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class D17_NumberOfSubMatricesThatSumToTarget {
    public static void main(String[] args) {
        NumberOfSubMatricesThatSumToTargetSolution solution = new NumberOfSubMatricesThatSumToTargetSolution();
        System.out.println(solution.numSubMatrixSumTarget(new int[][]{{1, -1}, {-1, 1}},0));
    }
}

class NumberOfSubMatricesThatSumToTargetSolution {
    public int numSubMatrixSumTarget(int[][] matrix, int target) {
        int xLen = matrix[0].length, yLen = matrix.length, answer = 0;
        Map<Integer, Integer> result = new HashMap<>();
        for (int[] r : matrix)
            for (int i = 1; i < xLen; i++)
                r[i] += r[i - 1];
            for (int i = 0; i < xLen; i++)
                for (int j = i; j < xLen; j++) {
                    result.clear();
                    result.put(0, 1);
                    int cSum = 0;
                    for (int k = 0; k < yLen; k++) {
                        cSum += matrix[k][j] - (i > 0? matrix[k][i - 1] : 0);
                        answer += result.getOrDefault(cSum - target, 0);
                        result.put(cSum, result.getOrDefault(cSum, 0) + 1);
                    }
                }
        return answer;
    }
}

class NumberOfSubMatricesThatSumToTargetSolution1 {
    public int numSubMatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        for (int y = 0,arr[] = new int[matrix[0].length]; y < matrix.length; y++) {
            MyMap.clear();
            for (int x = 0, sum = 0; x < matrix[0].length; x++) {
                sum += matrix[y][x];
                arr[x] = sum;
                if (arr[x] == target)
                    ans++;
                ans += MyMap.get(arr[x] - target);
                MyMap.inc(arr[x]);
            }
            for (int oy = y + 1, sum = 0; oy < matrix.length; oy++, sum = 0) {
                MyMap.clear();
                for (int x = 0; x < matrix[0].length; x++) {
                    sum += matrix[oy][x];
                    arr[x] += sum;
                    if (arr[x] == target)
                        ans++;
                    ans += MyMap.get(arr[x] - target);
                    MyMap.inc(arr[x]);
                }
            }
        }
        return ans;
    }
}

class MyMap {
    static int[][] arr = new int[1024][3];
    static int gen = 0;

    static void clear() {
        gen++;
    }

    static void inc(int val) {
        int ind = val;
        while (true) {
            ind &= 1023;
            if (arr[ind][0] != gen) {
                arr[ind][0] = gen;
                arr[ind][1] = val;
                arr[ind][2] = 1;
                return;
            }
            if (arr[ind][1] == val) {
                arr[ind][2]++;
                return;
            }
            ind++;
        }
    }

    static int get(int val) {
        int ind = val;
        while (true) {
            ind &= 1023;
            if (arr[ind][0] != gen)
                return 0;
            if (arr[ind][1] == val)
                return arr[ind][2];
            ind++;
        }
    }
}