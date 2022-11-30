import java.util.ArrayList;
import java.util.List;

public class LeetCode108 {
    //40m
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        int index = nums.length / 2;
        root.val = nums[index];
        if (nums.length > 1)
            add(root, nums, 0, index, nums.length);
        return root;
    }

    private void add(TreeNode node, int[] nums, int left, int middle, int right) {
        int i = (left + middle) / 2;
        if (i != left) {
            node.left = new TreeNode(nums[i]);
            add(node.left, nums, left, i, middle);
        } else {
            if (i == 0) {
                node.left = new TreeNode(nums[0]);
            }
        }
        i = (middle + right + 1) / 2;
        if (i != right) {
            node.right = new TreeNode(nums[i]);
            add(node.right, nums, middle, i, right);
        }
    }
}
