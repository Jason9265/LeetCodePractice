import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {
    public TreeNode iniTree(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        int cur = 1;
        queue.offer(root);
        while (queue != null) {
            TreeNode r = queue.poll();
            if (arr[cur] == null) {
                r.left = null;
            } else {
                r.left = new TreeNode(arr[cur]);
                queue.offer(r.left);
            }
            if (++cur >= arr.length) {
                break;
            }
            if (arr[cur] == null) {
                r.right = null;
            } else {
                r.right = new TreeNode(arr[cur]);
                queue.offer(r.right);
            }
            if (++cur >= arr.length) {
                break;
            }
        }
        return root;
    }

    public void printTreeNode(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> printList = new LinkedList<>();
        if (node == null) {
            System.out.println("Empty");
        } else {
            printList.offer(node.val);
            queue.offer(node);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    printList.offer(temp.left.val);
                    queue.offer(temp.left);
                } else {
                    printList.offer(null);
                }
                if (temp.right != null) {
                    printList.offer(temp.right.val);
                    queue.offer(temp.right);
                } else {
                    printList.offer(null);
                }
            }
        }
        System.out.println(printList);
    }
}
