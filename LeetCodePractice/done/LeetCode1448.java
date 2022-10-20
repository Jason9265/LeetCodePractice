public class LeetCode1448 {
    public int goodNodes(TreeNode root) {
        int ans = 1;
        if (root.left != null) {
            ans += countGoodNodes(root.left, root.val);
        }
        if (root.right != null) {
            ans += countGoodNodes(root.right, root.val);
        }

        return ans;
    }

    private int countGoodNodes(TreeNode node, int max_t) {
        int ans = 0;
        if (node.val >= max_t) {
            max_t = node.val;
            ans++;
        }
        if (node.left != null) {
            ans += countGoodNodes(node.left, max_t);
        }
        if (node.right != null) {
            ans += countGoodNodes(node.right, max_t);
        }
        return ans;
    }
}
