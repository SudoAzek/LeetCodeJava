package daily_challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D06_BinaryTreeRightSideView {
    public static void main(String[] args) {

    }
}

 // Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

class D06_BinaryTreeRightSideViewSolution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                if (i == (size - 1)) result.add(current.val);
            }
        }

        return result;
    }
}