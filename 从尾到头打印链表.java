import java.util.ArrayList;
public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode cur = listNode;
        int length = 0;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        int[] nums = new int[length];
        for(int i = 0; i < length; i++){
            nums[i] = listNode.val;
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = length-1; i >= 0; i--){
            ret.add(nums[i]);
        }
        return ret;
    }
}
