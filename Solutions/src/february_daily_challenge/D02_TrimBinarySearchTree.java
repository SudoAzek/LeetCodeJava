package february_daily_challenge;
import java.util.Scanner;

public class D02_TrimBinarySearchTree {
    public static void main(String[] args) {
        TrimBinarySearchTreeSolution_1 trimBinarySearchTreeSolution_1 = new TrimBinarySearchTreeSolution_1();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

//        trimBinarySearchTreeSolution_1.trimBST(input);
    }
}

/*
Approach #1: Recursion
Intuition

Let trim(node) be the desired answer for the subtree at that node. We can construct the answer recursively.

Algorithm

When \text{node.val > high}node.val > high, we know that the trimmed binary tree must occur to the left of the node.
Similarly, when \text{node.val < low}node.val < low, the trimmed binary tree occurs to the right of the node. Otherwise,
we will trim both sides of the tree.
 */

/*
#Python solution by Mudin using recursive
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def trimBST(self, root, low, high):
        def dfs(t):
            if not t:
                return None

            if t.val < low:
                return dfs(t.right)
            if t.val > high:
                return dfs(t.left)

            t.left = dfs(t.left)
            t.right = dfs(t.right)
            return t
        return dfs(root)
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
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

class TrimBinarySearchTreeSolution_1 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
