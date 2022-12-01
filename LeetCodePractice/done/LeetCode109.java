import java.util.ArrayList;
import java.util.List;

public class LeetCode109 {
    List<TreeNode> l1;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        l1 = new ArrayList<>();
        while (head != null) {
            l1.add(new TreeNode(head.val));
            head = head.next;
        }

        int index = l1.size() / 2;
        TreeNode root = l1.get(index);
        if (l1.size() > 1)
            add(root, 0, index, l1.size());
        return root;
    }

    private void add(TreeNode node, int left, int middle, int right) {
        int i = (left + middle) / 2;
        if (i != left) {
            node.left = l1.get(i);
            add(node.left, left, i, middle);
        } else {
            if (i == 0) {
                node.left = l1.get(0);
            }
        }
        i = (middle + right + 1) / 2;
        if (i != right) {
            node.right = l1.get(i);
            add(node.right, middle, i, right);
        }
    }
}
