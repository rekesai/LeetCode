import java.util.ArrayList;

public class 和为S的两个数字 {
    /**
     * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&&tqId=11195&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 描述
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
     * 返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。
     * 返回值描述：
     * 对应每个测试案例，输出两个数，小的先输出。
     * 示例1
     * 输入：
     * [1,2,4,7,11,15],15
     * 返回值：
     * [4,11]
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= sum) {
                break;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i+1; j < array.length; j++) {
                if (array[i]+array[j] == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    if (min > array[i]*array[j]) {
                        ret = list;
                        min = array[i]*array[j];
                    }
                    break;
                }
            }
        }
        return ret;
    }
}
