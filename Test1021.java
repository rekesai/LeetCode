import 链表.ListNode;

public class Test1021 {
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode end = preHead;
        ListNode start = null;
        ListNode next = null;
        while (left > 1) {
            pre = pre.next;
            left--;
        }
        start = pre.next;
        while (right > 0) {
            end = end.next;
            right--;
        }
        next = end.next;
        end.next = null;
        pre.next = reverse(start);
        start.next = next;
        return preHead.next;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
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

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        int rotate = length - k%length;
        tail.next = head;
        ListNode cur = head;
        while (rotate > 0) {
            cur = cur.next;
            tail = tail.next;
            rotate--;
        }
        tail.next = null;
        return cur;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return preHead.next;
    }
}