import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeetCode103 {
    List<List<Integer>> eachLevel;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        eachLevel = new ArrayList<>();
        if (root == null)
            return eachLevel;
        eachLevel(root, 0);
        for (int i = 0; i < eachLevel.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(eachLevel.get(i));
            }
        }
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