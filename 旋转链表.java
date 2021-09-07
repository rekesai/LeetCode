public class 旋转链表 {
    /**
     * https://leetcode-cn.com/problems/rotate-list/
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        int count = length - k % length;
        if (count == length) return head;
        tail.next = head;
        ListNode cur = head;
        for (int i = 0; i < count; i++) {
            cur = cur.next;
            tail = tail.next;
        }
        tail.next = null;
        return cur;
    }
}