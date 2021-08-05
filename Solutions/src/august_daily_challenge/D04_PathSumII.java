package august_daily_challenge;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class D04_PathSumII {
    public static void main(String[] args) {

        System.out.println();
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

//class PathSumIISolution {
//    public void pathSum(TreeNode root, int targetSum, int sum, List<List<Integer>> result, ArrayList<Integer> list) {
//        list.add(root.val);
//        sum += root.val;
//        if (sum == targetSum && root.left == null && root.right == null) {
//            result.add(new ArrayList<>(list));
//        }
//
//        if (root.left != null) {
//            pathSum(root.left, targetSum, sum, result, list);
//            list.remove(list.size() - 1);
//        }
//
//        if (root.right != null) {
//            pathSum(root.right, targetSum, sum, result, list);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null)
//            return result;
//        pathSum(root, targetSum, 0, result, new ArrayList<Integer>());
//        return result;
//    }
//}
//
//class PathSumIISolution2 {
//    private int maxPathLen = 2000;
//    private int[] path = new int[maxPathLen];
//    List<List<Integer>> result = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        findAllPath(0, root, sum);
//        return result;
//    }
//
//    private void findAllPath(int index, TreeNode root, int sum) {
//        if (root == null) {
//            return;
//        }
//        path[index] = root.val;
//        if (root.left == null && root.right == null && root.val == sum) {
//            List<Integer> list = new ArrayList<Integer>();
//            for (int i = 0; i <= index; i++) {
//                list.add(path[i]);
//            }
//            result.add(list);
//            return;
//        }
//        findAllPath(index + 1, root.left, sum - root.val);
//        findAllPath(index + 1, root.right, sum - root.val);
//    }
//
//}