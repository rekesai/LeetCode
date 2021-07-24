public class 平衡二叉树 {
    public int treeHight(TreeNode root){
        if(root == null) return 0;
        int left = treeHight(root.left);
        int right = treeHight(root.right);
        return Math.max(left, right)+1;
    }
    // 算出左右子树的高度进行判断，再判断其左子树和右子树的平衡
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int left = treeHight(root.left);
        int right = treeHight(root.right);
        return Math.abs(left-right) < 2 && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }
}
