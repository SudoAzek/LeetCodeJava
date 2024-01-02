package problems;

public class P2_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next.next = new ListNode(9);


        ListNode l2 = new ListNode(9);

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0;
        int n2 = 0;
        int n;

        for (int i = 1; l1 != null; i *= 10) {
            n1 += l1.val * i;
            l1 = l1.next;
        }

        for (int i = 1; l2 != null; i *= 10) {
            n2 += l2.val * i;
            l2 = l2.next;
        }

        n = n1 + n2;
        ListNode result = new ListNode();
        ListNode head = result;

        while (n > 0) {
            head.val = n % 10;
            head.next = new ListNode();
            head = head.next;
            n /= 10;
        }

        return result;
    }

}


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
