public class Test827 {
    public ListNode ReverseList(ListNode head) {
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
    public ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int tmp = 0;
        while (head1 != null || head2 != null) {
            int val = tmp;
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            cur.next = new ListNode(val%10);
            cur = cur.next;
            tmp = val/10;
        }
        if(tmp != 0) cur.next = new ListNode(tmp);
        pre = reverse(pre.next);
        return pre;
    }
    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null) return null;
        if (k <= 0) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode end = preHead;
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
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (head == null) return null;
        if (n <= 0) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = pre.next;;
        ListNode next = cur;
        while (n != 0) {
            next = next.next;
            n--;
        }
        while (next != null) {
            pre = pre.next;;
            cur = cur.next;
            next = next.next;
        }
        if (cur == head) {
            return head.next;
        }
        if (cur.next == null) {
            pre.next = null;
            return head;
        }
        pre.next = cur.next;
        return head;
    }
}