import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode589 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root==null){
            return ans;
        }
        addNode(root);
        return ans;
    }

    private void addNode(Node node){
        ans.add(node.val);
        for(Node n : node.children){
            addNode(n);
        }
    }
}