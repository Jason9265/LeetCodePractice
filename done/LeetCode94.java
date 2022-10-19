import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return ans;
        addNode(root);
        return ans;
    }

    private void addNode(TreeNode node) {
        if (node.left != null)
            addNode(node.left);
        ans.add(node.val);
        if (node.right != null)
            addNode(node.right);
    }
}
