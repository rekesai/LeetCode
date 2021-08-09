public class 链表中倒数最后k个结点 {

    /**
     * 描述
     * 输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
     * 如果该链表长度小于k，请返回一个长度为 0 的链表。
     * 示例1
     * 输入：
     * {1,2,3,4,5},1
     * 返回值：
     * {5}
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if(pHead == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(k-1 != 0){
            fast = fast.next;
            k--;
            if(fast == null) return null;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}