package march_daily_challenge;

public class D04_IntersectionOfTwoLinkedLists {
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class IntersectionOfTwoLinkedListsSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null)
                a = headB;
            else a = a.next;

            if (b == null)
                b = headA;
            else b = b.next;
        }
        return a;
    }
}