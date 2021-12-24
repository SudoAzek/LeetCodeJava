package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56_Merge_Intervals {
    public static void main(String[] args) {
        Solution_Merge_Intervals sol = new Solution_Merge_Intervals();
        System.out.println(Arrays.deepToString(sol.merge(new int[][]{{1, 4}, {4, 5}})));
    }
}

class Solution_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

class Solution_Merge_Intervals2 {
    public int[][] merge(int[][] intervals) {
        int nMerged = 1; //number of merged intervals
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i]; // save a set of interval
            int m0 = interval[0], m1 = interval[1], nRemain = 0;
            for (int j = 0; j < nMerged; j++) {
                int[] candidate = intervals[j]; //pick a set of interval
                int c0 = candidate[0], c1 = candidate[1];
                //compare both selected interval
                //if upperbound of b is smaller than lower-bound of a
                if (c1 < m0) {
                    nRemain++; //increment remaining interval
                }
                //if upperbound of a is smaller than lower bound of b
                else if (m1 < c0) {
                    intervals[nRemain++] = interval;
                    interval = candidate;
                } else {
                    //wrap interval m0,m1 into c0,c1 (eliminate m0,m1)
                    //if lower-bound of b is smaller than lower-bound of a, make selected interval lower-bound as c0 the smallest
                    if (c0 < m0) interval[0] = c0;
                    //if upperbound of b is larger than upperbound of a, make selected interval upperbound as c1 the largest.
                    if (c1 > m1) interval[1] = c1;
                }
            }
            intervals[nRemain++] = interval; //replace interval with new define interval
            nMerged = nRemain;
        }

        int[][] result = new int[nMerged][];
        for (int i = 0; i < nMerged; i++) {
            result[i] = intervals[i];
        }
        return result;
        //Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    }
}