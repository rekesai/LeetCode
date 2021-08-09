import java.util.ArrayList;
public class 调整数组位置使奇数位于偶数前面 {
    /**
     * 描述
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 示例1
     * 输入：
     * [1,2,3,4]
     * 返回值：
     * [1,3,2,4]

     * 示例2
     * 输入：
     * [2,4,6,5,7]
     * 返回值：
     * [5,7,2,4,6]
     */
    public int[] reOrderArray (int[] array) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                list1.add(array[i]);
            }
            else{
                list2.add(array[i]);
            }
        }
        int i = 0;
        int j = 0;
        while(i < list1.size()){
            array[i] = list1.get(i);
            i++;
        }
        while(j < list2.size()){
            array[i++] = list2.get(j++);
        }
        return array;
    }
}