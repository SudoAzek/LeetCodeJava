package march_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class D05_AverageOfLevelsInBinaryTree {
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

class AverageOfLevelsInBinaryTreeSolution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> cnt = new ArrayList<>();
        List<Double> res = new ArrayList<>();

        avg(root, 0, res, cnt);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / cnt.get(i));
        }
        return res;
    }

    public void avg(TreeNode treeNode, int i, List<Double> sum, List<Integer> cnt) {
        if (treeNode == null) return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + treeNode.val);
            cnt.set(i, cnt.get(i) + 1);
        } else {
            sum.add(1.0 * treeNode.val);
            cnt.add(1);
        }
        avg(treeNode.left, i + 1, sum, cnt);
        avg(treeNode.right, i + 1, sum, cnt);
    }
}