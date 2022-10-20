public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len == 1 && n == 1) {
            return null;
        }
        n = len - n - 1;
        temp = head;
        if (n < 0) {
            return head.next;
        }
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
