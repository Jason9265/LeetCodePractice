import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode987 {
    List<List<List<Integer>>> left = new ArrayList<>();
    List<List<List<Integer>>> right = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        setNode(root, 0, 0);
        for (int i = left.size() - 1; i >= 0; i--) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < left.get(i).size(); j++) {
                Collections.sort(left.get(i).get(j));
                temp.addAll(left.get(i).get(j));
            }
            ans.add(temp);
        }
        for (int i = 0; i < right.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < right.get(i).size(); j++) {
                Collections.sort(right.get(i).get(j));
                temp.addAll(right.get(i).get(j));
            }
            ans.add(temp);
        }
        return ans;
    }

    private void setNode(TreeNode node, int level, int layer) {
        if (level >= 0) {
            if (right.size() <= level) {
                right.add(new ArrayList<>());
            }
            while (right.get(level).size() <= layer / 2) {
                right.get(level).add(new ArrayList<>());
            }
            right.get(level).get(layer / 2).add(node.val);
        } else {
            if (left.size() < -level) {
                left.add(new ArrayList<>());
            }
            while (left.get(-level - 1).size() <= layer / 2) {
                left.get(-level - 1).add(new ArrayList<>());
            }
            left.get(-level - 1).get(layer / 2).add(node.val);
        }
        if (node.left != null) {
            setNode(node.left, level - 1, layer + 1);
        }
        if (node.right != null) {
            setNode(node.right, level + 1, layer + 1);
        }
    }
}
