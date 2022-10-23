import java.util.*;

public class Test {
    public static void main(String[] args) {
        Print p = new Print();
        LeetCodeContest lcd = new LeetCodeContest();

        // TreeNode
        TreeBuilder tb = new TreeBuilder();
        Integer[] treeA = new Integer[]{1, 2, 3, null, 4};
        TreeNode root = tb.iniTree(treeA);

        // array
        int[] arr1 = new int[]{1,1,1,1,1};
        int[][] arra1 = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] arra2 = new int[][]{{0, 0}, {1, 0}, {2, 0}, {0, 1}, {0, 2}};
        String[] stringArray1 = new String[]{"10:00", "11:00"};
        String[] stringArray2 = new String[]{"01:20", "03:00"};

        // solution
    }
}
