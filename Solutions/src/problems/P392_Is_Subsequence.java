package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P392_Is_Subsequence {
    public static void main(String[] args) {
        Solution_Is_Subsequence sol = new Solution_Is_Subsequence();
        System.out.println(sol.isSubsequence("axc", "ahbgdc"));
    }

}

class Solution_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedList<>();
        for (Character ch : s.toCharArray()) {
            queue.add(ch);
        }

        for (Character ch : t.toCharArray()) {
            if (queue.peek() == ch) {
                queue.poll();
            }
        }
        return queue.isEmpty();
    }
}

class Solution_Is_Subsequence2 {
    public boolean isSubsequence(String s, String t) {
        for (char ch : s.toCharArray()) {
            int find = t.indexOf(ch);
            if (find == -1) {
                return false;
            } else {
                t = t.substring(find + 1);
            }
        }

        return true;
    }
}