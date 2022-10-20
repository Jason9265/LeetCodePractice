public class LeetCode606 {
    String ans = "";

    public String tree2str(TreeNode root) {
        if (root == null) {
            return ans;
        }
        ans += root.val;
        addNode(root);
        return ans;
    }

    private void addNode(TreeNode node) {
        if (node.left != null) {
            ans += "(" + node.left.val;
            addNode(node.left);
            ans += ")";
            if (node.right != null) {
                ans += "(" + node.right.val;
                addNode(node.right);
                ans += ")";
            }
//            ans += ")";
        } else {
            if (node.right != null) {
                ans += "()(" + node.right.val;
                addNode(node.right);
                ans += ")";
            }
        }
    }
}
