package march_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D29_FlipBinaryTreeToMatchPreorderTraversal {
}

class FlipBinaryTreeToMatchPreorderTraversalDFSSolution {
    List<Integer> flipped;
    int index;
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new ArrayList<>();
        index = 0;
        this.voyage = voyage;

        dfs(root);
        if (!flipped.isEmpty() && flipped.get(0) == -1 ) {
            flipped.clear();
            flipped.add(-1);
        }

        return flipped;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }

            if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
                flipped.add(node.val);
                dfs(node.right);
                dfs(node.left);
            } else {
                dfs(node.left);
                dfs(node.right);
            }
        }
    }
}

class SolutionDFS {
    int voix = 0;
    List<Integer> answer = new ArrayList<>();
    private void dfs(TreeNode node, int[] V) {
        if (node == null || (answer.size() != 0 && answer.get(0) == -1)) return;
        if (node.val != V[voix++]) answer = new ArrayList<>(Arrays.asList(-1));
        else if (node.left != null && node.left.val != V[voix]) {
            answer.add(node.val);
            dfs(node.right, V);
            dfs(node.left, V);
        } else {
            dfs(node.left, V);
            dfs(node.right, V);
        }
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] V) {
        dfs(root, V);
        return answer;
    }
}