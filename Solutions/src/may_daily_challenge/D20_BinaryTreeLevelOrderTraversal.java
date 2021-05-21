package may_daily_challenge;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class D20_BinaryTreeLevelOrderTraversal {
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
//class BinaryTreeLevelOrderTraversalSolution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> answer = new ArrayList<>();
//        if (root == null) return answer;
//        Deque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int queueLen = queue.size();
//            List<Integer> row = new ArrayList<>();
//            for (int i = 0; i < queueLen; i++) {
//                TreeNode current = queue.poll();
//                row.add(current.val);
//                if (current.left != null) queue.add(current.left);
//                if (current.right != null) queue.add(current.right);
//            }
//            answer.add(row);
//        }
//        return answer;
//    }
//}
//
//class BinaryTreeLevelOrderTraversalSolution1 {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> smallAns = new ArrayList<>();
//        lineBFS3(root,ans,smallAns);
//        return ans;
//    }
//    public void lineBFS3(TreeNode root,List<List<Integer>> ans,List<Integer> smallAns){
//        if(root==null)
//            return;
//        LinkedList<TreeNode> que = new LinkedList<>();
//        que.addLast(root);
//        while(que.size()!=0){
//            int size = que.size();
//            while(size-->0){
//                TreeNode rn = que.removeFirst();
//                smallAns.add(rn.val);
//                if(rn.left!=null){
//                    que.addLast(rn.left);
//                }
//                if(rn.right!=null){
//                    que.addLast(rn.right);
//                }
//            }
//            ans.add(smallAns);
//            smallAns = new ArrayList<>();
//        }
//    }
//}