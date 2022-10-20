public class LeetCode814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        setNodes(root);
        deleteNode(root);
        if ((root.val == 0 || root.val == -1) && root.left == null && root.right == null) {
            root = null;
        }
        return root;
    }

    private void setNodes(TreeNode node) {
        if (node.left != null) {
            setNodes(node.left);
        }
        if (node.right != null) {
            setNodes(node.right);
        }
        if (node.val == 0) {
            if (node.left == null && node.right == null) {
                node.val = -1;
            } else if (node.left == null && node.right.val == -1) {
                node.val = -1;
            } else if (node.right == null && node.left.val == -1) {
                node.val = -1;
            }
            if (node.left != null && node.left.val == -1 && node.right != null && node.right.val == -1) {
                node.val = -1;
            }
        }
    }

    private void deleteNode(TreeNode node) {
        if (node.left != null && node.left.val == -1) {
            node.left = null;
        }
        if (node.right != null && node.right.val == -1) {
            node.right = null;
        }
        if (node.left != null) {
            deleteNode(node.left);
        }
        if (node.right != null) {
            deleteNode(node.right);
        }
    }
}
