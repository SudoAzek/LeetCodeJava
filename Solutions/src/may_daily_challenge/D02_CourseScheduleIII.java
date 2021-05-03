package may_daily_challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D02_CourseScheduleIII {
    public static void main(String[] args) {
        CourseScheduleIIISolution solution = new CourseScheduleIIISolution();
        System.out.println(solution.scheduleCourse(new int[][]{{1,2}}));
    }
}

class CourseScheduleIIISolution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int dur = course[0], end = course[1];
            if (dur + total <= end) {
                total += dur;
                priorityQueue.add(dur);
            } else if (priorityQueue.size() > 0 && priorityQueue.peek() > dur) {
                total += dur - priorityQueue.poll();
                priorityQueue.add(dur);
            }
        }
        return priorityQueue.size();
    }
}

class CourseScheduleIIISolution2 {
    public int scheduleCourse(int[][] courses) {
        Comparator<int []> cmp = (a, b) -> a[1] - b[1];
        Arrays.sort(courses,cmp);
        PriorityQueue<int[]> coursesTaken = new PriorityQueue<>((a, b) -> (b[0]-a[0]));
        int time = 0;
        for(int [] course: courses){
            if(time + course[0] <= course[1]){
                time += course[0];
                coursesTaken.offer(course);
            }
            else{
                if(!coursesTaken.isEmpty() && coursesTaken.peek()[0] > course[0]){
                    int longCourseTime = coursesTaken.poll()[0];
                    time -= longCourseTime;
                    time += course[0];
                    coursesTaken.offer(course);
                }
            }
        }
        return coursesTaken.size();
    }
}