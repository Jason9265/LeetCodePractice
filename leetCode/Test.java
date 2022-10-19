import java.util.*;

public class Test {
    public static void main(String[] args) {
        Print p = new Print();

        // TreeNode
        TreeBuilder tb = new TreeBuilder();
        Integer[] treeA = new Integer[]{1, 2, 3, null, 4};
        TreeNode root = tb.iniTree(treeA);

        // array
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[][] arra1 = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] arra2 = new int[][]{{0, 0}, {1, 0}, {2, 0}, {0, 1}, {0, 2}};
        String[] stringArray = new String[]{"a"};

        // solution
        ListNode n1 = p.setListNode(new int[]{1, 3, 4, 7, 1, 2, 6});
        ListNode n2 = p.setListNode(new int[]{1, 2, 3, 4,5});
        ListNode n3 = p.setListNode(new int[]{2});
        LeetCode143 so = new LeetCode143();
        so.reorderList(n3);
        p.printListNode(n3);
    }
}
