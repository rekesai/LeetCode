import java.lang.reflect.Array;
import java.util.*;

public class 数组中只出现一次的两个数字 {
    /**
     * 描述
     * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 示例1
     * 输入：
     * [1,4,1,6]
     * 返回值：
     * [4,6]

     * 说明：
     * 返回的结果中较小的数排在前面
     */
    public int[] FindNumsAppearOnce2 (int[] array) {
        int[] ret = new int[2];
        int k = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if(set.contains(array[i])){
                set.remove(array[i]);
            }
            else{
                set.add(array[i]);
            }
        }
        for(Integer i : set){
            ret[k++] = i;
        }
        Arrays.sort(ret);
        return ret;
    }
    public int[] FindNumsAppearOnce1 (int[] array) {
        int[] ret = new int[2];
        int tmp = array[0];
        //将数组中所有数字做异或处理
        //由于相同数字异或结果为0，0与数字tmp异或的结果为tmp
        //所以最终的结果为单独出现的数字的异或结果
        for(int i = 1; i < array.length; i++){
            tmp ^= array[i];
        }
        int m = 1;
        // 找到一个位，两个数在这一位上不同
        while ((m&tmp) == 0){
            m = m<<1;
        }
        //根据第m这一位的值将原数组分为两组，同样的数字异或就不用管了，两个不同的数字会被分开最终筛选出来
        for(int i : array){
            if((m&i) == 0){
                ret[0] ^= i;
            }
            else {
                ret[1] ^= i;
            }
        }
        Arrays.sort(ret);
        return ret;
    }
}
