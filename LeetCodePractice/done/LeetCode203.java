public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preNode = new ListNode();
        preNode.next = head;
        ListNode temp = preNode;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }
        return preNode.next;
    }
}
