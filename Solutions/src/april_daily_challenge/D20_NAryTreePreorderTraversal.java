package april_daily_challenge;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class D20_NAryTreePreorderTraversal {
    public static void main(String[] args) {

    }
}

/*
// Definition for a Node.
 */
class NodeNAry {
    public int val;
    public List<NodeNAry> children;

    public NodeNAry() {}

    public NodeNAry(int _val) {
        val = _val;
    }

    public NodeNAry(int _val, List<NodeNAry> _children) {
        val = _val;
        children = _children;
    }
};

class NAryTreePreorderTraversalSolution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(NodeNAry root) {
        if (root == null) return ans;
        ans.add(root.val);
        for (var ch : root.children) preorder(ch);
        return ans;
    }
}