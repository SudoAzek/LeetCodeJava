package problems;

import java.util.Stack;

public class P155_Min_Stack {
    public static void main(String[] args) {
        MinStackWithStack minStackWithStack = new MinStackWithStack();
        minStackWithStack.push(-2);
        minStackWithStack.push(0);
        minStackWithStack.push(-3);
        System.out.println(minStackWithStack.getMin());
        minStackWithStack.pop();
        minStackWithStack.top();
        System.out.println(minStackWithStack.getMin());
    }
}

/*
    Source: https://leetcode.com/problems/min-stack/
    Time Comlexity :
    Space Complexity :
*/

class MinStackWithStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */