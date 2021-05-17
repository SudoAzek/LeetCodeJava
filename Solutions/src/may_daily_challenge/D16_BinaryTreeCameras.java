package may_daily_challenge;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class D16_BinaryTreeCameras {
    public static void main(String[] args) {
        BinaryTreeCamerasSolution solution = new BinaryTreeCamerasSolution();
//        System.out.println(solution.minCameraCover());
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
class BinaryTreeCamerasSolution {
    private int answer = 0;
    public int minCameraCover(TreeNode root) {
        return dfs(root) > 2 ? answer + 1 : answer;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int val = dfs(root.left) + dfs(root.right);
        if (val == 0) return 3;
        if (val < 3) return 0;
        answer++;
        return 1;
    }
}