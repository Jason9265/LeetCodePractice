public class LeetCode2095 {
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len == 1) {
            return null;
        }
        temp = head;
        for (int i = 0; i < len / 2 - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
