import java.util.ArrayList;
import java.util.List;

public class LeetCode590 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if(root==null){
            return ans;
        }
        addNode(root);
        return ans;
    }

    private void addNode(Node node){
        for(Node n : node.children){
            addNode(n);
        }
        ans.add(node.val);
    }
}
