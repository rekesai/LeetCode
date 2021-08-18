public class 删除链表中重复的节点 {
    /**
     * 描述
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * 示例1
     * 输入：
     * {1,2,3,3,4,4,5}
     * 返回值：
     * {1,2,5}
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode cur = pHead;
        ListNode tmpHead = new ListNode(-1);
        ListNode newHead = tmpHead;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }
            else{
                tmpHead.next = cur;
                tmpHead = tmpHead.next;
                cur = cur.next;
            }
        }
        tmpHead.next = null;
        return newHead.next;
    }
}
