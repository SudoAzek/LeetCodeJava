package april_daily_challenge;

import java.util.Stack;

public class D01_PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedListSolution1 solution1 = new PalindromeLinkedListSolution1();
        System.out.println(solution1.isPalindrome(new ListNode()));
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class PalindromeLinkedListSolution1 {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode curr = head; curr != null; curr = curr.next) stack.push(curr.val);
        for (ListNode curr = head; curr != null && stack.peek() == curr.val; curr = curr.next) stack.pop();

        return stack.isEmpty();
    }
}

class PalindromeLinkedListSolution2 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next;

        ListNode reverseSecHalf = reverseList(slow);

        while (reverseSecHalf != null && head.val == reverseSecHalf.val) {
            reverseSecHalf = reverseSecHalf.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray())
                if (c == '0') zeros++;
                else ones++;
            for (int i = m; i >= zeros; i--)
                for (int j = n; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        }
        return dp[m][n];
    }
}