/**
 * https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=188&&tqId=38554&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class 单链表的排序 {
    public ListNode sortInList (ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur != null) {
                if (cur.val < pre.val) {
                    int tmp = cur.val;
                    cur.val = pre.val;
                    pre.val = tmp;
                }
                cur = cur.next;
            }
            pre = pre.next;
        }
        return head;
    }
}