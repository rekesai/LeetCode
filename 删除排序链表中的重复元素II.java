package 链表;

public class 删除排序链表中的重复元素II {

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点
     * 只保留原始链表中没有重复出现的数字。
     * 返回同样按升序排列的结果链表。
     *
     * 示例 1：
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *
     * 示例 2：
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     */
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
}