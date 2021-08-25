/**
 * nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=188&&tqId=38610&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * 描述
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * 示例1
 * 输入：
 * [9,3,7],[6,3]
 * 返回值：
 * {1,0,0,0}
 */
public class 两个链表生成相加链表 {
    public ListNode reverse(ListNode head) {
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
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
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
            tmp = val/10;
            cur.next = new ListNode(val%10);
            cur = cur.next;
        }
        if (tmp != 0) {
            cur.next = new ListNode(tmp);
        }
        ListNode ret = reverse(newHead.next);
        return ret;
    }
}
