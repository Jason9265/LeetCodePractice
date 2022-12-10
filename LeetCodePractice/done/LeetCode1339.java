import java.util.Map;

public class LeetCode1339 {
    double a = Double.MAX_VALUE;
    double d;

    public int maxProduct(TreeNode root) {
        d = (double) countNode(root);
        d /= 2;
        findMax(root);
        return (int) (((d + a) * (d - a)) % 1000000007);
    }

    private int countNode(TreeNode node) {
        int sum = node.val;
        if (node.left != null) {
            countNode(node.left);
            sum += node.left.val;
        }
        if (node.right != null) {
            countNode(node.right);
            sum += node.right.val;
        }
        node.val = sum;
        return sum;
    }

    private void findMax(TreeNode node) {
        if (node.left != null && a != 0) {
            findMax(node.left);
        }
        if (node.right != null && a != 0) {
            findMax(node.right);
        }
        a = Math.min(a, Math.abs(d - (double) node.val));
    }
}
