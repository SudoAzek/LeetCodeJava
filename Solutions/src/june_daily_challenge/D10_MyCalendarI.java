package june_daily_challenge;

import java.util.Map;
import java.util.TreeMap;

public class D10_MyCalendarI {
    public static void main(String[] args) {
        MyCalendarSolution solution = new MyCalendarSolution();
        System.out.println(solution.book(10, 20));
    }
}

class MyCalendarSolution {
    TreeMap<Integer, Integer> calendar = new TreeMap<>();

    public MyCalendarSolution() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }
}


class MyCalendarSolution2 {
    class Node {
        private int start;
        private int end;
        private Node left;
        private Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node root;

    public MyCalendarSolution2() {
        root = null;
    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }
        Node node = root;
        while (node != null) {
            if (end <= node.start) {
                if (node.left == null) {
                    node.left = new Node(start, end);
                    return true;
                }
                node = node.left;
            } else if (start >= node.end) {
                if (node.right == null) {
                    node.right = new Node(start, end);
                    return true;
                }
                node = node.right;
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

