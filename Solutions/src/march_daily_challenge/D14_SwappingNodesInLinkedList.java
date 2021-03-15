package march_daily_challenge;

public class D14_SwappingNodesInLinkedList {
    public static void main(String[] args) {
        SwappingNodesInLinkedListSolution sol = new SwappingNodesInLinkedListSolution();
//        ListNode listNode = new ListNode(11);
//        System.out.println(sol.swapNodes(listNode, 11));
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

class SwappingNodesInLinkedListSolution {
    public ListNode swapNodes(ListNode head, int k) {
        k = k - 1;
        ListNode firstNode = head;
        while (k > 0) {
            firstNode = firstNode.next;
            k--;
        }

        ListNode f = firstNode;
        ListNode secondNode = head;
        while (f.next != null) {
            secondNode = secondNode.next;
            f = f.next;
        }

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }
}