import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=188&&tqId=38562&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class 判断一个链表是否为回文结构 {
    public boolean isPail(ArrayList list) {
        int left = 0;
        int right = list.size()-1;
        while (left <= right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPail (ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;
        ArrayList<String> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val+"");
            head = head.next;
        }
        return isPail(list);
    }
}
