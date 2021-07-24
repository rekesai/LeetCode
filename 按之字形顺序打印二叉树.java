
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
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
}
