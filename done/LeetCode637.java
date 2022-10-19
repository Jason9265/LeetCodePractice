import java.util.ArrayList;
import java.util.List;

public class LeetCode637 {
    List<List<Double>> sumOFLevel;

    public List<Double> averageOfLevels(TreeNode root) {
        sumOFLevel = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        eachLevel(root, 0);
        for (int i = 0; i < sumOFLevel.size(); i++) {
            double temp = 0;
            for (double d : sumOFLevel.get(i)) {
                temp += d;
            }
            temp /= sumOFLevel.get(i).size();
            ans.add(temp);
        }
        return ans;
    }

    private void eachLevel(TreeNode node, int level) {
        if (sumOFLevel.size() <= level) {
            sumOFLevel.add(new ArrayList<>());
        }
        sumOFLevel.get(level).add((double) node.val);
        if (node.left != null) {
            eachLevel(node.left, level + 1);
        }
        if (node.right != null) {
            eachLevel(node.right, level + 1);
        }
    }
}
