package problems;

public class P98_Validate_Binary_Search_Tree {
    public static void main(String[] args) {

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode tree, long minValue, long maxValue) {
        if (tree == null) return true;

        if (tree.val <= minValue || tree.val >= maxValue) return false;

        return  isValidBSTHelper(tree.left, minValue, tree.val) && isValidBSTHelper(tree.right, tree.val, maxValue);
    }

//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
//        if (root == null) return true;
//        if (root.val >= maxVal || root.val <= minVal) return false;
//        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
//    }
}