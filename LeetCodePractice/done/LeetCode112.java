public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return checkNode(root, root.val, targetSum);
    }

    private boolean checkNode(TreeNode node, int num, int targetSum) {
        boolean l = false, r = false;
        if (node.left != null) {
            l = checkNode(node.left, num + node.left.val, targetSum);
        }
        if (node.right != null) {
            r = checkNode(node.right, num + node.right.val, targetSum);
        }
        if (node.left == null && node.right == null) {
            if (num == targetSum) {
                return true;
            }
        }
        return l || r;
    }
}
