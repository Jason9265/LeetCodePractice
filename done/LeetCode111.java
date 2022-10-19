public class LeetCode111 {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMin(root, 1);
        return min;
    }

    private void findMin(TreeNode node, int num) {
        if (node.left != null) {
            findMin(node.left, num + 1);
        }
        if (node.right != null) {
            findMin(node.right, num + 1);
        }
        if (node.left == null && node.right == null) {
            min = Integer.min(min, num);
        }
    }
}
