package problems;

public class P100_Same_Tree {
    public static void main(String[] args) {
        Same_Tree_Solution sol = new Same_Tree_Solution();
        System.out.println();
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Same_Tree_Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != p.val) return false;

        return isSameTree(p.right, q.right) && isSameTree(q.left, p.left);
    }
}