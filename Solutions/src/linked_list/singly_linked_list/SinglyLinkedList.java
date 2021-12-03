package linked_list.singly_linked_list;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyListNode singlyListNode = new SinglyListNode(1994);
        System.out.println(singlyListNode);
    }
}

// Definition for singly-linked list.
class SinglyListNode {
    int val;
    SinglyListNode next;

    public SinglyListNode(int x) {
        val = x;
    }
}