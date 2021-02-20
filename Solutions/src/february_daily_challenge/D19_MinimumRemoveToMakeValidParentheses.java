package february_daily_challenge;

import java.util.Deque;
import java.util.LinkedList;

public class D19_MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParenthesesSolution solution = new MinimumRemoveToMakeValidParenthesesSolution();
        System.out.println(solution.minRemoveToMakeValid("(a(b(c)d)"));
    }
}

class MinimumRemoveToMakeValidParenthesesSolution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder builder = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                if(!deque.isEmpty()) {
                    deque.removeLast();
                } else {
                    builder.deleteCharAt(i);
                }
            }
            if(s.charAt(i) == ')') {
                deque.add(i);
            }
        }
        for(int i : deque) {
            builder.deleteCharAt(i);
        }
        return builder.toString();
    }
}