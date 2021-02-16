package daily_challenge;

import java.util.Arrays;

public class D15_TheKWeakestRowsInMatrix {
    public static void main(String[] args) {
        TheKWeakestRowsInMatrixSolution sol = new TheKWeakestRowsInMatrixSolution();
        int[][] mat = new int[][]{{1,1,0,0,0},
                                {1,1,1,1,0},
                                {1,0,0,0,0},
                                {1,1,0,0,0},
                                {1,1,1,1,1}};
        System.out.println(Arrays.toString(sol.kWeakestRows(mat, 5)));

    }
}

/*
class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        hmap = {}
        for i in range(len(mat)):
            for n in mat[i]:
                if n == 1:
                    hmap[i] = hmap.get(i, 0) + 1
                else:
                    hmap[i] = hmap.get(i, 0)
        res = list(hmap.keys())
        res = sorted(res, key = lambda x: hmap[x])
        return res[:k]
 */

class TheKWeakestRowsInMatrixSolution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int count;
        int[] res = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) count++;
            }
            res[i] = count;
        }

//        for (int i = 0; i < res.length ; i++) {
//            res[i]
//        }
//        Arrays.sort(res);
        int ress[] = new int[res.length];
        int min = res[0];
        for(int i = 1; i < res.length; i++) {
            for (int j = 1; j < res.length; j++) {

            }
            if(res[i] < min) {
                min = res[i];
            }
            ress[i] = res[i];
        }
        return Arrays.copyOfRange(ress,0, k);
    }
}
