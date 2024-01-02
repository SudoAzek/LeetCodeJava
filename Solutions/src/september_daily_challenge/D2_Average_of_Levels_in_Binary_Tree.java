package september_daily_challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D2_Average_of_Levels_in_Binary_Tree {
    public static void main(String[] args) {
    }
}

class Average_of_Levels_in_Binary_Tree_Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        List<Double> ans = new ArrayList<>();
        while (queue.size() > 0) {
            double queueLen = queue.size();
            double row = 0;
            for (int i = 0; i < queueLen; i++) {
                TreeNode curr = queue.poll();
                row += curr.val;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            ans.add(row/queueLen);
        }
        return ans;
    }
}