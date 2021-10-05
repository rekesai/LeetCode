import 链表.ListNode;
import 链表.Node;

import java.util.HashMap;
import java.util.Map;

public class Test1005 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }


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


    public boolean check(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int m = i;
        while (postorder[m] < postorder[j]) {
            m++;
        }
        int n = m;
        while (postorder[m] > postorder[j]) {
            m++;
        }
        return m == j && check(postorder, i, n-1) && check(postorder, n, j-1);
    }
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length-1);
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


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