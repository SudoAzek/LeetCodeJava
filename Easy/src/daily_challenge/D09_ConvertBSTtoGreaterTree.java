package daily_challenge;

public class D09_ConvertBSTtoGreaterTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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
}

class D09_ConvertBSTtoGreaterTreeSolution {
    public TreeNode convertBST(TreeNode root) {
        calc(root, 0);
        return root;
    }

    public int calc(TreeNode t, int i) {
        if(t == null) return i;
        t.val += calc(t.right, i);
        return calc(t.left, t.val);
    }
}