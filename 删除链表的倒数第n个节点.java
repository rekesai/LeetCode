/**
 * https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=188&&tqId=38587&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * 描述
 * 给定一个链表，删除链表的倒数第 nn 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
 * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
 * 备注：
 * 题目保证 nn 一定是有效的
 * 请给出时间复杂度为\ O(n) O(n) 的算法
 * 示例1
 * 输入：
 * {1,2},2
 * 返回值：
 * {2}
 */
public class 删除链表的倒数第n个节点 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (head == null) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;
        ListNode next = cur;
        while (n != 0) {
            next = next.next;
            n--;
        }
        while (next != null) {
            pre = pre.next;
            cur = cur.next;
            next = next.next;
        }
        // 要删除的是否是最后一个节点
        if (cur.next == null) {
            pre.next = null;
            return preHead.next;
        }
        // 要删除的是否是第一个节点
        if (cur == head) {
            return head.next;
        }
        // 普通中间节点
        pre.next = cur.next;
        return preHead.next;
    }
}
