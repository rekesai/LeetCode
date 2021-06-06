import java.util.ArrayList;

public class 整数反转 {
    /**给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     假设环境不允许存储 64 位整数（有符号或无符号）
     示例 1：
     输入：x = 123
     输出：321
     示例 2：
     输入：x = -123
     输出：-321
     示例 3：
     输入：x = 120
     输出：21
     示例 4：
     输入：x = 0
     输出：0
     提示：
     -231 <= x <= 231 - 1
     链接：https://leetcode-cn.com/problems/reverse-integer
     *
     */
    public static int reverse2(int x){
        long ret = 0;
        while(x != 0){
            ret = ret*10 + x%10;
            x = x/10;
        }
        return (int)ret == ret ? (int)ret : 0;
    }

    public static int reverse(int x) {
        //先检测正数负数
        boolean flag = true;
        if(x < 0){
            x = -x;
            flag = false;
        }
        //将每一位放入数组中，顺序逆转过来
        ArrayList<Integer> list = new ArrayList<>();
        while(x/10 != 0){
            list.add(x%10);
            x /= 10;
        }
        list.add(x);
        //将数字在加起来
        long ret = 0;
        for(int i = 0; i < list.size(); i++){
            ret += Math.pow(10, list.size()-i-1)*list.get(i);
        }
        if(!flag){
            ret = -ret;
        }
        //不允许大于int的数字出现
        return (int)ret == ret ? (int)ret : 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
