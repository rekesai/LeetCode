package 树;

public class 二叉搜索树与双向链表II {

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     *       4
     *     /  \
     *    2    5
     *   /  \
     *  1    3
     * 中序遍历就是 1 2 3 4 5
     *
     * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
     * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后  ↔
     * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点，其中5的right指向1,1的left指向5
     * head
     *  1 ↔ 2 ↔ 3 ↔ 4 ↔ 5
     *
     * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
     * 还需要返回链表中的第一个节点的指针。
     *
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
     */
    TreeNode pre = null, head = null;
    public void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (head == null) {
            head = cur;
            pre = head;
        } else {
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        dfs(cur.right);
    }
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
}
