import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 按之字形顺序打印二叉树 {
    // 队列解法
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flg = true;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null) continue;
                if(flg){
                    list.add(node.val);
                }
                else{
                    list.add(0, node.val);
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if(!list.isEmpty()){
                ret.add(list);
            }
            flg = !flg;
        }
        return ret;
    }

    // 双栈解法
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        boolean flg = true;
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode cur = s1.pop();
                if(cur != null){
                    list.add(cur.val);
                    s2.push(cur.left);
                    s2.push(cur.right);
                }
            }
            if(!list.isEmpty()) ret.add(list);
            ArrayList<Integer> list2 = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode cur = s2.pop();
                if(cur != null){
                    list2.add(cur.val);
                    s1.push(cur.right);
                    s1.push(cur.left);
                }
            }
            if(!list2.isEmpty()) ret.add(list2);
        }
        return ret;
    }
}
