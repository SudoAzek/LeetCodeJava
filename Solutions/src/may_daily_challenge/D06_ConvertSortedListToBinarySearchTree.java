package may_daily_challenge;


public class D06_ConvertSortedListToBinarySearchTree {
}

/**
 * Definition for singly-linked list.
 */
public class ListNode {
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

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ConvertSortedListToBinarySearchTreeSolution {
    ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        curr = head;
        return makeTree(1, count);
    }

    private TreeNode makeTree(int i, int j) {
        if (j < i) return null;
        int mid = i + j >> 1;
        TreeNode node = new TreeNode();
        node.left = makeTree(i, mid - 1);
        node.val = curr.val;
        curr = curr.next;
        node.right = makeTree(mid + 1, j);
        return node;
    }
}

class ConvertSortedListToBinarySearchTreeSolution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode s = head;
        ListNode f = head;
        ListNode previousS = null;
        while (f != null && f.next != null) {
            previousS = s;
            s = s.next;
            f = f.next.next;
        }
        previousS.next = null;
        TreeNode root = new TreeNode(s.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(s.next);
        return root;
    }
}