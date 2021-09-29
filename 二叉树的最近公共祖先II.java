package 树;

public class 二叉树的最近公共祖先II {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4] 层序遍历
     *
     * 示例 1:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     *
     * 示例 2:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root为空返回空
        if (root == null) return null;
        // 配合递归
        if (root == p || root == q) return root;
        // 在左子树中找p或者q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中找p或者q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树为空，证明是在右子树中找到了p 或者 q，是哪个无所谓，注定一个是另一个的根节点
        if (left == null) return right;
        // 如果左子树不为空，右子树为空，那就是在左子树中找到了p 或者 q
        if (right == null) return left;
        // 如果两子树都不为空，证明p 和 q 各在左右子树，那公共祖先节点就是当前的root了
        return root;
    }
}
