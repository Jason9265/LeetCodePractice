import java.util.LinkedList;
import java.util.Queue;

public class Print {
    public void printIntArray(int[] arr) {
        System.out.println("------------------------------");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("------------------------------");
    }

    public void printIntegerArray(Integer[] arr) {
        System.out.println("------------------------------");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("------------------------------");
    }

    public void print2DIntArray(int[][] arr) {
        System.out.println("------------------------------");
        for (int[] arr1 : arr) {
            for (int i : arr1) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    public void printStringArray(String[] arr) {
        System.out.println("------------------------------");
        for (String i : arr) {
            System.out.print(i + " | ");
        }
        System.out.println();
        System.out.println("------------------------------");
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

    // useless
    public ListNode setListNode(int[] array) {
        ListNode ph = new ListNode();
        ListNode temp = new ListNode();
        ph.next = temp;
        for (int i : array) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return ph.next.next;
    }

    // useless
    public void printListNode(ListNode node) {
        System.out.println("------------------------------");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println("------------------------------");
    }
}
