public class test94 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null) return null;
        if (k <= 0) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode end = pre;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            ListNode cur = reverse(start);
            pre.next = cur;
            start.next = next;
            pre = start;
            end = pre;
        }
        return preHead.next;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != cur2) {
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            else {
                cur1 = pHead2;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
            else {
                cur2 = pHead1;
            }
        }
        return cur1;
    }
}
