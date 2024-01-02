package september_daily_challenge;


public class D1_Count_Good_Nodes_in_Binary_Tree {
    public static void main(String[] args) {

    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
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


class Count_Good_Nodes_in_Binary_Tree_Solution {
    int goodNodes;

    public int goodNodes(TreeNode root) {
        goodNodes = 0;
        good(root, Integer.MIN_VALUE);
        return goodNodes;
    }

    public void good(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) goodNodes++;
        max = Math.max(max, root.val);
        good(root.left, max);
        good(root.right, max);
    }
}