import java.util.ArrayList;

public class 链表的奇偶重排 {
    /**
     * 描述
     * https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=188&&tqId=38658&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
     * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
     * 注意是节点的编号而非节点的数值。
     * 示例1
     * 输入：
     * {1,2,3,4,5,6}
     * 复制
     * 返回值：
     * {1,3,5,2,4,6}
     * 复制
     * 说明：
     * 1->2->3->4->5->6->NULL
     * 重排后为
     * 1->3->5->2->4->6->NULL
     */
    public ListNode oddEvenList (ListNode head) {
        if (head == null) return null;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        while (head != null) {
            list1.add(head.val);
            head = head.next;
            if (head != null) {
                list2.add(head.val);
            }
            else {
                break;
            }
            head = head.next;
        }
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        for (int i = 0; i < list1.size(); i++) {
            cur.next = new ListNode(list1.get(i));
            cur = cur.next;
        }
        for (int i = 0; i < list2.size(); i++) {
            cur.next = new ListNode(list2.get(i));
            cur = cur.next;
        }
        return preHead.next;
    }
}
