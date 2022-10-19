public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len == 1) {
            return head;
        }
        temp = head;
        for (int i = 0; i < len / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
