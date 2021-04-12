package april_daily_challenge;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class D11_DeepestLeavesSum {
}

/**
 * Definition for a binary tree node.
 */
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class DeepestLeavesSumSolution {
    public int deepestLeavesSum(TreeNode1 root) {
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        int answer = 0, queue_len = 0;
        while (queue.size() > 0) {
            queue_len = queue.size();
            answer = 0;
            for (int i = 0; i < queue_len; i++) {
                TreeNode1 current = queue.poll();
                answer += current.val;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return answer;
    }
}

class DeepestLeavesSumSolution2 {
    int deepestLevel=0;
    int sum=0;
    void helper(TreeNode root,int crrLevel)
    {
        if(root==null)
        {
            return;
        }
//        if(crrLevel>=deepestLevel)
//        {
//            sum=crrLevel==deepestLevel?sum+root.val:root.val;
//            deepestLevel=crrLevel;
//        }
//        helper(root.left,crrLevel+1);
//        helper(root.right,crrLevel+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        helper(root,0);
        return sum;
    }
}