import java.util.ArrayList;
import java.util.List;

public class LeetCode2487 {
    List<Integer> list = new ArrayList<>();
    public ListNode removeNodes(ListNode head) {
        ListNode ph = new ListNode();
        ph.next = head;
        ListNode temp = new ListNode();
        temp = ph;
        while (temp.next != null) {
            temp = temp.next;
        }
        list.add(temp.val);
        temp = ph;
        func(ph);
        return ph.next;
    }

    private void func(ListNode node) {
        if (node.next.next != null) {
            func(node.next);
        }
        if (node.next.val < list.get(list.size() - 1)) {
            node.next = node.next.next;
        } else {
            list.add(node.next.val);
        }
    }
}
