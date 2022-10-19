public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        TreeNode temp = root;
        if (nums.length == 0) {
            return root;
        }
        if (nums.length == 1) {
            root.val = nums[0];
            return root;
        }

        return root;
    }

    private TreeNode addLeft(int[] nums, TreeNode n) {
        return n;
    }

    private TreeNode addRight(int[] nums, TreeNode n) {
        return n;
    }
}
