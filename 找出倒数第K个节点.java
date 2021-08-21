import java.util.Scanner;

public class 找出倒数第K个节点 {
    /**
     * https://www.nowcoder.com/practice/0cff324157a24a7a8de3da7934458e34?sourceQid=23254&sourceTpId=13
     * 描述
     * 找出单向链表中的一个节点，该节点到尾指针的距离为K。链表的倒数第0个结点为链表的尾指针。要求时间复杂度为O(n)。
     * 链表结点定义如下：
     * class ListNode {
     *    int val;
     *    ListNode next;
     * }
     * 链表节点的值初始化为1，2，3，4，5，6，7。
     * 输入描述：
     * 该节点到尾指针的距离K
     * 输出描述：
     * 返回该单向链表的倒数第K个节点，输出节点的值
     * 示例1
     * 输入：
     * 2
     * 输出：
     * 6
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 8; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = new ListNode();
        ListNode tail = cur.next;
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode fast = head;
        ListNode slow = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
    }
}