public class 二叉树的下一个结点 {
    /**
     * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&&tqId=11210&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 描述
     * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。下图为一棵有9个节点的二叉树。树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
     *
     * 示例:
     * 输入:{8,6,10,5,7,9,11},8
     * 返回:9
     * 解析:这个组装传入的子树根节点，其实就是整颗树，中序遍历{5,6,7,8,9,10,11}
     * 根节点8的下一个节点就是9，应该返回{9,10,11}，后台只打印子树的下一个节点
     * 所以只会打印9，如下图，其实都有指向左右孩子的指针，还有指向父节点的指针，下图没有画出来

     * 输入描述：
     * 输入分为2段，第一段是整体的二叉树，第二段是给定二叉树节点的值
     * 后台会将这2个参数组装为一个二叉树局部的子树传入到函数GetNext里面，用户得到的输入只有一个子树根节点
     * 返回值描述：
     * 返回传入的子树根节点的下一个节点，后台会打印输出这个节点
     *
     * 示例1
     * 输入：
     * {8,6,10,5,7,9,11},8
     * 返回值：
     * 9

     * 示例2
     * 输入：
     * {8,6,10,5,7,9,11},6
     * 返回值：
     * 7

     * 示例3
     * 输入：
     * {1,2,#,#,3,#,4},4
     * 返回值：
     * 1

     * 示例4
     * 输入：
     * {5},5
     * 返回值：
     * "null"
     * 说明：
     * 不存在，后台打印"null"
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        // 如果当前结点的右子树不为空
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 当前结点无右子树时，判断结点是父结点的左子树还是右子树,这里的next指的是父节点
        while (pNode.next != null) {
            // 如果当前节点是父节点的左子树，那就直接返回当前节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            // 如果当前节点是父节点的右子树，就去判断父节点是左子树还是右子树
            pNode = pNode.next;
        }
        return null;
    }
}
