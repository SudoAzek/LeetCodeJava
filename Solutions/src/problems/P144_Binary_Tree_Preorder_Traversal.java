package problems;

import java.util.ArrayList;
import java.util.List;

public class P144_Binary_Tree_Preorder_Traversal {
}


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

class Solution_Binary_Tree_Preorder_Traversal_Recursive {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}

class Solution_Binary_Tree_Preorder_Traversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                preorderTraversal(root.left);
            }
            if (root.right != null) {
                preorderTraversal(root.right);
            }
        }
        return res;
    }
}

class Solution_Binary_Tree_Preorder_Traversal_Iterative {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode pred = root;
        boolean isLeft = true;

        while (root != null) {
            res.add(root.val);

            if (root.left != null && isLeft) {
                root = root.left;
                continue;
            } else {
                root = pred;
                isLeft = false;
            }
            if (root.right != null && !isLeft) {
                root = root.right;
            } else {
                root = pred;
            }
        }
        return res;
    }
}
