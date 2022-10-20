public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preNode = new ListNode();
        preNode.next = head;
        ListNode tempNode = preNode;
        while (check(tempNode, k)) {
            switchNodes(tempNode, k);
            for (int i = 0; i < k; i++) {
                tempNode = tempNode.next;
            }
        }
        return preNode.next;
    }

    private void switchNodes(ListNode node, int k) {
        ListNode tail = node;
        for (int i = 0; i <= k; i++) {
            tail = tail.next;
        }
        ListNode newHead = new ListNode();
        ListNode tempH = newHead;

        for (int i = 0; i < k; i++) {
            ListNode temp = node;
            for (int j = 0; j < k - i; j++) {
                temp = temp.next;
            }
            tempH.next = temp;
            tempH = tempH.next;
        }

        node.next = newHead.next;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        node.next = tail;
    }

    private boolean check(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next;
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
