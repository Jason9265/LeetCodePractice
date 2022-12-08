import java.util.Stack;

public class LeetCode872 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        14m
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        inStack(root1);
        inStack2(root2);
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    private void inStack(TreeNode node) {
        if (node.left != null) {
            inStack(node.left);
        }
        if (node.right != null) {
            inStack(node.right);
        }
        if (node.left == null && node.right == null) {
            stack1.push(node.val);
        }
    }

    private void inStack2(TreeNode node) {
        if (node.left != null) {
            inStack2(node.left);
        }
        if (node.right != null) {
            inStack2(node.right);
        }
        if (node.left == null && node.right == null) {
            stack2.push(node.val);
        }
    }
}
