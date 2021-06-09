package june_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class D08_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

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
class ConstructBinaryTreeFromPreorderAndInorderTraversalSolution1 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return splitTree(preorder, inorder, map, 0, 0, inorder.length - 1);
//    }
//
//    private TreeNode splitTree(int[] preorder, int[] inorder, Map<Integer, Integer> map, int i, int i1, int i2) {
//        int rVal = preorder[i], iMid = map.get(rVal);
//        TreeNode root = new TreeNode(rVal);
//        if (iMid > i1) root.left = splitTree(preorder, inorder, map, i + 1, i1, iMid - 1);
//        if (iMid < i2) root.right = splitTree(preorder, inorder, map, i + iMid - i1 + 1, iMid + 1, i2);
//        return root;
//    }
}

class ConstructBinaryTreeFromPreorderAndInorderTraversalSolution2 {
//    private int in = 0;
//    private int pre = 0;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, inorder, Integer.MIN_VALUE);
//    }
//
//    private TreeNode build(int[] preorder, int[] inorder, int stop) {
//        if (pre >= preorder.length) return null;
//        if (inorder[in] == stop) {
//            in++;
//            return null;
//        }
//        TreeNode node = new TreeNode(preorder[pre++]);
//        node.left = build(preorder, inorder, node.val);
//        node.right = build(preorder, inorder, stop);
//        return node;
//    }
}