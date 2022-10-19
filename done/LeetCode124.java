public class LeetCode124 {
    int res = 0;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = root.val;
        sumNode1(root);
        return res;
    }

    private int sumNode1(TreeNode node) {
        int sum = node.val;
        if (node.left != null || node.right != null) {
            if (node.left != null && node.right != null) {
                int l = sumNode1(node.left);
                int r = sumNode1(node.right);
                int tempMax = Math.max(r, l);
                res = Math.max(res, sum + Math.max(l + r, tempMax));
                if (tempMax > 0)
                    sum += tempMax;
            } else {
                if (node.left == null) {
                    int r = sumNode1(node.right);
                    sum = Math.max(sum, sum + r);
                } else {
                    int l = sumNode1(node.left);
                    sum = Math.max(sum, sum + l);
                }
            }
        }
        res = Math.max(res, sum);
        return sum;
    }
}
