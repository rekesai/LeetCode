import java.util.*;

public class 从上往下打印二叉树 {
    /**
     * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&&tqId=11175&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 描述
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 示例1
     * 输入：
     * {5,4,#,3,#,2,#,1}
     * 返回值：
     * [5,4,3,2,1]
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                ret.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return ret;
    }
}
