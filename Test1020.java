import 链表.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Test1020 {

    public int lengthOfLongestSubstring(String s) {
        int size = 0;
        int left = 0;
        int right = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(left++));
            }
            while (right+1 < s.length() && !set.contains(s.charAt(right+1))) {
                set.add(s.charAt(++right));
            }
            size = Math.max(size, set.size());
        }
        return size;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = preHead;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return preHead.next;
    }
}