package april_daily_challenge;

import java.util.Stack;

public class D01_PalindromeLinkedList {
}

/**
 * Definition for singly-linked list.
 */
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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