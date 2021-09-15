import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 之字形打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flg = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    if (flg) {
                        list.add(cur.val);
                    }
                    else {
                        list.add(0, cur.val);
                    }
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            flg = !flg;
            if (list.size() != 0) res.add(list);
        }
        return res;
    }
}
