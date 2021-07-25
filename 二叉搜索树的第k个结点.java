import java.util.Stack;
public class 二叉搜索树的第k个结点 {
    // 题目中给出的二叉搜索树序列为层序遍历，此处采用的是中序遍历解法，利用栈来求出第k个小的节点
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k < 1) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                if(--k == 0) return cur;
                cur = cur.right;
            }
        }
        return null;
    }
}
