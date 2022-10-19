import java.util.ArrayList;
import java.util.List;

public class LeetCode102 {
    List<List<Integer>> eachLevel;

    public List<List<Integer>> levelOrder(TreeNode root) {
        eachLevel = new ArrayList<>();
        if(root==null)
            return eachLevel;
        eachLevel(root, 0);
        return eachLevel;
    }

    private void eachLevel(TreeNode node, int level) {
        if (eachLevel.size() <= level) {
            eachLevel.add(new ArrayList<>());
        }
        eachLevel.get(level).add(node.val);
        if (node.left != null) {
            eachLevel(node.left, level + 1);
        }
        if (node.right != null) {
            eachLevel(node.right, level + 1);
        }
    }
}
