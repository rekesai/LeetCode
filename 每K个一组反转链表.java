import java.util.Scanner;

public class 每K个一组反转链表 {
    /**
     * https://www.nowcoder.com/practice/a632ec91a4524773b8af8694a51109e7?sourceQid=23254&sourceTpId=13
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
    public static ListNode reverseK(ListNode head, int k) {
        // 1.判空
        if (head == null || k == 0) {
            return null;
        }
        // 2.定义一个头结点的前节点
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        // 3. 定义一个前节点和尾节点，用来保存翻转的前前节点以及尾节点
        ListNode pre = preHead;
        ListNode end = preHead;

        // 4. 遍历链表
        while (end.next != null) {
            //  5.获取k个节点后的尾节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 6.如果已经为空，则直接跳出循环
            if (end == null) {
                break;
            }
            // 7.保存前节点，以及尾节点的下一个节点
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            // 8.进行反转，返回翻转后的节点
            ListNode reverseList = reverse(start);
            // 9.拼接头部
            pre.next = reverseList;
            // 10.拼接尾部,此时反转后的start节点，其实是尾节点
            start.next = next;
            // 11.重置
            pre = start;
            end = pre;
        }
        // 12.返回结果
        return preHead.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        ListNode head = null;
        ListNode cur = head;
        for (int i = 0; i < strs.length; i++) {
            if (head == null) {
                head = new ListNode(Integer.parseInt(strs[i]));
                cur = head;
            }
            else {
                ListNode tmp = new ListNode(Integer.parseInt(strs[i]));
                cur.next = tmp;
                cur = cur.next;
            }
        }
        int k = sc.nextInt();
        ListNode newHead = reverseK(head, k);
        while (newHead != null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }
}