package april_daily_challenge;

public class D18_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfListSolution solution = new RemoveNthNodeFromEndOfListSolution();
//        System.out.println(solution.removeNthFromEnd());
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class RemoveNthNodeFromEndOfListSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = node;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return node.next;
    }
}