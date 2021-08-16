public class 链表中环的入口结点 {

    /**
     * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&&tqId=11208&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 描述
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
     * 输入描述：
     * 输入分为2段，第一段是入环前的链表部分，第二段是链表环的部分，后台将这2个会组装成一个有环或者无环单链表
     * 返回值描述：
     * 返回链表的环的入口结点即可。而我们后台程序会打印这个节点

     * 示例1
     * 输入：
     * {1,2},{3,4,5}
     * 返回值：
     * 3
     * 说明：
     * 返回环形链表入口节点，我们后台会打印该环形链表入口节点，即3

     * 示例2
     * 输入：
     * {1},{}
     * 返回值：
     * "null"
     * 说明：
     * 没有环，返回null，后台打印"null"

     * 示例3
     * 输入：
     * {},{2}
     * 返回值：
     * 2
     * 说明：
     * 只有环形链表节点2，返回节点2，后台打印2
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}