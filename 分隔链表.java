package 链表;

import 链表.ListNode;

public class 分隔链表 {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * 示例 1：
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     *
     * 示例 2：
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     * 链接：https://leetcode-cn.com/problems/partition-list
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                leftTail.next = cur;
                leftTail = leftTail.next;
            }
            else {
                rightTail.next = cur;
                rightTail = rightTail.next;
            }
            cur = cur.next;
        }
        leftTail.next = rightHead.next;
        rightTail.next = null;
        return leftHead.next;
    }
}