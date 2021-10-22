import 链表.ListNode;

public class Test1022 {

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = preHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return preHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
            }
            if (cur == null) {
                pre.next = null;
                break;
            }
            pre.next = cur;
            pre = cur;
            cur = pre.next;
        }
        return preHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode end = preHead;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return preHead.next;
    }
}
