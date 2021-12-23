package problems;

import java.util.LinkedList;
import java.util.Queue;

public class P210_Course_ScheduleII {
    public static void main(String[] args) {

    }
}

class Solution_Course_ScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        int[] inDegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        for (int[] ints : prerequisites) {
            inDegree[ints[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();
            for (int[] ints : prerequisites) {
                if (ints[1] == prerequisite) {
                    inDegree[ints[0]]--;
                    if (inDegree[ints[0]] == 0) {
                        order[index++] = ints[0];
                        queue.offer(ints[0]);
                    }
                }
            }
        }
        return (index == numCourses) ? order : new int[0];
    }
}