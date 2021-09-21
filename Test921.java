import 链表.ListNode;
import 链表.Node;

import java.util.HashMap;

public class Test921 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        int count = length - k % length;
        if (length == count) return head;
        tail.next = head;
        ListNode cur = head;
        for (int i = 0; i < count; i++) {
            cur = cur.next;
            tail = tail.next;
        }
        tail.next = null;
        return cur;
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


    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        //先建立新节点，将其与旧节点按照链表的顺序通过map建立联系，并赋上相应的val  Map<key, val>
        while(cur != null){
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }

        //令cur重新指回head，将新节点与旧节点之间的next、random关系也复制一遍
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回新链表的头部
        return map.get(head);
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
