public class 反转链表 {
    /**
     * 描述
     * 输入一个链表，反转链表后，输出新链表的表头。
     * 示例1
     * 输入：
     * {1,2,3}
     * 返回值：
     * {3,2,1}
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        ListNode cur = head.next;
        ListNode pre = head;
        pre.next = null;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
}
