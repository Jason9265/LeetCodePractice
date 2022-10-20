public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean[] flagArray = new boolean[lists.length];
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                flagArray[i] = true;
            }
        }
        ListNode preNode = new ListNode();
        ListNode temp = new ListNode();
        preNode.next = temp;
        while (!checkFlag(flagArray)) {
            int min = Integer.MAX_VALUE, index = -1;
            int i = 0;
            while (i < lists.length) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        index = i;
                    }
                }
                i++;
            }
            temp.next = lists[index];
            temp = temp.next;
            lists[index] = lists[index].next;
            if (lists[index] == null) {
                flagArray[index] = true;
            }
        }
        return preNode.next.next;
    }

    private boolean checkFlag(boolean[] bl) {
        for (boolean b : bl) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
