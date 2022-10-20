import java.util.ArrayList;
import java.util.List;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        List<ListNode> list1 = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list1.add(temp);
            temp = temp.next;
        }
        ListNode preHead = new ListNode();
        for (int i = 0; i < list1.size(); i++) {
            if (i % 2 == 0) {
                preHead.next = list1.get(i / 2);
                if (i == list1.size() - 1) {
                    list1.get(i / 2).next = null;
                }
            } else {
                preHead.next = list1.get(list1.size() - 1 - (i / 2));
                if (i == list1.size() - 1) {
                    list1.get(list1.size() - 1 - (i / 2)).next = null;
                }
            }
            preHead = preHead.next;
        }
    }
}
