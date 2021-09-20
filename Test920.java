import 链表.ListNode;

public class Test920 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                pre.next = cur1;
                pre = pre.next;
                cur1 = cur1.next;
            }
            else {
                pre.next = cur2;
                pre = pre.next;
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            pre.next = cur1;
            pre = pre.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            pre.next = cur2;
            pre = pre.next;
            cur2 = cur2.next;
        }
        return preHead.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            while (left <= right && nums[left]%2 == 1) {
                left++;
            }
            while (left <= right && nums[right]%2 == 0) {
                right--;
            }
            if (left > right) {
                break;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left]+nums[right] < target) {
                left++;
            }
            else if (nums[left]+nums[right] > target) {
                right--;
            }
            else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i--) {
            if (!strs[i].equals("")) {
                sb.append(strs[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.trimToSize();
    }
}