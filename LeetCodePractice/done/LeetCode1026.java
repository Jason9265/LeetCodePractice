public class LeetCode1026 {
    int answ = 0;
    public int maxAncestorDiff(TreeNode root) {
        checkNode(root);
        return answ;
    }

    private int[] checkNode(TreeNode node){
        int val = node.val;
        int[] ans = new int[]{val,val};
        if(node.left!=null){
            int[] temp = checkNode(node.left);
            ans[0]=Math.min(ans[0],temp[0]);
            ans[1]=Math.max(ans[1],temp[1]);
        }
        if(node.right!=null){
            int[] temp = checkNode(node.right);
            ans[0]=Math.min(ans[0],temp[0]);
            ans[1]=Math.max(ans[1],temp[1]);
        }
        if(node.left==null&&node.right==null){
            return ans;
        }
        answ=Math.max(answ,Math.abs(ans[0]-val));
        answ=Math.max(answ,Math.abs(ans[1]-val));
        return ans;
    }
}
