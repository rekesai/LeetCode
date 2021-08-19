import java.util.*;


public class 对称的二叉树 {

    /**
     *https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&&tqId=11211&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 描述
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * 示例1
     * 输入：
     * {8,6,6,5,7,7,5}
     * 返回值：
     * true

     * 示例2
     * 输入：
     * {8,6,9,5,7,7,5}
     * 返回值：
     * false
     */
    // 递归写法
    boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
    boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSame(pRoot.left, pRoot.right);
    }


    // 迭代写法
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
