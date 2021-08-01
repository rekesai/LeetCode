import java.util.Arrays;

public class 重建二叉树 {
    /**
     * 给定某二叉树的前序遍历和中序遍历，请重建出该二叉树并返回它的头结点。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
     *
     * 提示:
     * 1.0 <= pre.length <= 2000
     * 2.vin.length == pre.length
     * 3.-10000 <= pre[i], vin[i] <= 10000
     * 4.pre 和 vin 均无重复元素
     * 5.vin出现的元素均出现在 pre里
     * 6.只需要返回根结点，系统会自动输出整颗树做答案对比
     * 示例1
     * 输入：
     * [1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6]
     * 返回值：
     * {1,2,3,4,#,5,6,#,7,#,#,8}

     * 说明：
     * 返回根节点，系统会输出整颗二叉树对比结果
     * 示例2
     * 输入：
     * [1],[1]
     * 返回值：
     * {1}

     * 示例3
     * 输入：
     * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
     * 返回值：
     * {1,2,5,3,4,6,7}
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++){
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
                break;
            }
        }
        return root;
    }
}
