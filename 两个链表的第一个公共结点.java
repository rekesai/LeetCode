public class 两个链表的第一个公共结点 {
    /**
     * 描述
     * 输入两个无环的单链表，找出它们的第一个公共结点。
     * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     *
     * 示例1
     * 输入：
     * {1,2,3},{4,5},{6,7}
     * 复制
     * 返回值：
     * {6,7}
     * 复制
     * 说明：
     * 第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分
     * 这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
     * 示例2
     * 输入：
     * {1},{2,3},{}
     * 返回值：
     * {}
     * 说明：
     * 2个链表没有公共节点 ,返回null，后台打印{}
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        while(pHead1 != null){
            ListNode cur = pHead2;
            while(cur != null){
                if(pHead1 == cur){
                    return cur;
                }
                else{
                    cur = cur.next;
                }
            }
            pHead1 = pHead1.next;
        }
        return null;
    }
}
