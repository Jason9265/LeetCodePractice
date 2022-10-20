import java.util.*;

public class Practice {
    static int maxOfMoney = 0;
    static int tempMax = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        Tree root = new Tree(arr.get(0));
        Tree temp = root;
        int tempMax = arr.get(0);
        setTree(root, arr, 0);
        pre(root);
        System.out.println(maxOfMoney);
    }

    private static void pre(Tree node) {
        tempMax+=node.value;
        maxOfMoney=Math.max(maxOfMoney,tempMax);
        tempMax-=node.value;
        if (node.left != null) {
            pre(node.left);

        }
        if (node.right != null) {
            pre(node.right);
        }
    }

    private static void setTree(Tree node, List<Integer> arr, int i) {
        if (arr.size() > 2 * i + 1) {
            node.left = new Tree(arr.get(2 * i + 1));
            if (arr.size() > 2 * (2 * i + 1) + 1) {
                setTree(node.left, arr, 2 * i + 1);
            }
        }
        if (arr.size() > 2 * i + 2) {
            node.right = new Tree(arr.get(2 * i + 2));
            if (arr.size() > 2 * (2 * i + 2) + 1) {
                setTree(node.right, arr, 2 * i + 2);
            }
        }
    }

    private static int findMax(Tree node) {
        return 0;
    }
}

class Tree {
    int value;
    Tree left;
    Tree right;

    Tree() {

    }

    Tree(int value) {
        this.value = value;
    }
}