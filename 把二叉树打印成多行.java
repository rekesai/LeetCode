import java.util.*;
public class 把二叉树打印成多行 {
    /**
     * https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&&tqId=11213&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 描述
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * 例如：
     * 给定的二叉树是{1,2,3,#,#,4,5}
     *
     * 该二叉树多行打印层序遍历的结果是
     * [
     * [1],
     * [2,3],
     * [4,5]
     * ]
     *
     * 示例1
     * 输入：
     * {1,2,3,#,#,4,5}
     * 返回值：
     * [[1],[2,3],[4,5]]

     * 示例2
     * 输入：
     * {8,6,10,5,7,9,11}
     * 返回值：
     * [[8],[6,10],[5,7,9,11]]

     * 示例3
     * 输入：
     * {1,2,3,4,5}
     * 返回值：
     * [[1],[2,3],[4,5]]
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek() != null) {
                    list.add(queue.peek().val);
                    queue.offer(queue.peek().left);
                    queue.offer(queue.peek().right);
                }
                queue.poll();
            }
            if (!list.isEmpty()) ret.add(list);
        }
        return ret;
    }
}
