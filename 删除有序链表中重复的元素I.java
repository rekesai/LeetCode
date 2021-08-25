/**
 * https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79?tpId=188&&tqId=38643&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * 描述
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为   1→1→2,返回    1→2.
 * 给出的链表为   1→1→2→3→3,返回    1→2→3.
 * 示例1
 * 输入：
 * {1,1,2}
 * 返回值：
 * {1,2}
 */
public class 删除有序链表中重复的元素I {
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null) return null;
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return preHead.next;
    }
}
