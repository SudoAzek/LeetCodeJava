package february_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class D10_CopyListWithRandomPointer {
    public static void main(String[] args) {
        CopyListWithRandomPointerSolution copyListWithRandomPointerSolution = new CopyListWithRandomPointerSolution();
    }
}

/*
// Definition for a Node.
*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class CopyListWithRandomPointerSolution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> newOldMap = new HashMap<>();
        Node current = head;
        while(current != null) {
            newOldMap.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node newNode = newOldMap.get(current);
            newNode.next = newOldMap.getOrDefault(current.next, null);
            newNode.random = newOldMap.getOrDefault(current.random, null);
            current = current.next;
        }
        return newOldMap.getOrDefault(head, null);
    }
}