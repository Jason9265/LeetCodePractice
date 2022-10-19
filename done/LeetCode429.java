import java.util.ArrayList;
import java.util.List;

public class LeetCode429 {
    List<List<Integer>> eachLevel;

    public List<List<Integer>> levelOrder(Node root) {
        eachLevel = new ArrayList<>();
        if (root == null)
            return eachLevel;
        eachLevel(root, 0);
        return eachLevel;
    }

    private void eachLevel(Node node, int level) {
        if (eachLevel.size() <= level) {
            eachLevel.add(new ArrayList<>());
        }
        eachLevel.get(level).add(node.val);
        for (Node n : node.children) {
            eachLevel(n, level + 1);
        }
    }
}
