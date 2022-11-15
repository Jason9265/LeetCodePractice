public class LeetCode222 {
    int ans = 0;

    //    new way to do it, binary search
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null) {
            if (root.left == null)
                return 1;
            else
                return 2;
        }
        int layer = 1;
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
            layer += 1;
        }
        ans = (int) Math.pow(2, layer) - 1;
        boolean[] arr = new boolean[layer];
        for (int i = 1; i < layer; i++) {
            node = root;
            for (int j = 1; j < layer; j++) {
                node = arr[j] ? node.left : node.right;
            }
            if (i < layer - 1) {
                if (node.left == null) {
                    arr[i] = true;
                } else if (node.right != null) {
                    arr[i - 1] = false;
                    arr[i] = true;
                } else {
                    return ans + countNum(arr, 1);
                }
            }
        }
//        for (boolean b : arr) {
//            System.out.println(b);
//        }

        if (node.left == null) {
            int temp = ans + countNum(arr, 0);
            arr[arr.length - 1] = true;
            node = root;
            for (int j = 1; j < layer; j++) {
                node = arr[j] ? node.left : node.right;
            }
            if (node.right == null) {
                if (node.left == null) {
                    return temp - 2;
                } else
                    return temp - 1;
            } else
                return temp;
        } else if (node.right != null) {
            int temp = ans + countNum(arr, 2);
            node = root;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i]) {
                    arr[i] = false;
                    i++;
                    while (i < arr.length) {
                        arr[i] = true;
                        i++;
                    }
                    break;
                }
            }
            if (node.left != null) {
                if (node.right != null) {
                    return temp + 2;
                } else
                    return temp + 1;
            } else
                return temp;
        } else {
            return ans + countNum(arr, 1);
        }
    }

    private int countNum(boolean[] arr, int in) {
        int n = 0;
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                n += (int) Math.pow(2, (arr.length - i));
            }
        }
        return n + in;
    }
}
/*
[1,2,3,4,5,6]
[1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
 */