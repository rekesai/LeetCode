import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中
     * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
     *
     */

    // 使用map将原节点和新节点形成键值关系，再设置每个新节点的next和random
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


    // 给原链表中的每个节点后加一个新节点，最后再分开
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        // 在原链表的每个节点之后建立新的节点并连接起来
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        // 修改新节点的random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 将原节点和新节点分开，题目要求不能修改原链表
        cur = head.next;
        Node pre = head;
        Node newHead = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            pre = pre.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        // 处理原链表最后一个节点的next
        pre.next = null;
        return newHead;
    }
}