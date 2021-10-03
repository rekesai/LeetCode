package 树;

public class 二叉搜索树的后序遍历序列 {
    /**
     *
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
     * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * 参考以下这颗二叉搜索树：
     *
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     *
     * 示例 1：
     * 输入: [1,6,3,2,5]
     * 输出: false
     *
     * 示例 2：
     * 输入: [1,3,2,6,5]
     * 输出: true
     *
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof。
     */
    public boolean check(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int m = i;
        while (postorder[m] < postorder[j]) {
            m++;
        }
        int n = m;
        while (postorder[m] > postorder[j]) {
            m++;
        }
        return m == j && check(postorder, i, n-1) && check(postorder, n, j-1);
    }
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length-1);
    }
}
