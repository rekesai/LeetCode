package 树;

public class 二叉搜索树的第k大节点 {

    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     *
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
     */
    int res, k;
    public void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.right);
        if (k == 0) return;
        if (--k == 0) res = cur.val;
        dfs(cur.left);
    }
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
}