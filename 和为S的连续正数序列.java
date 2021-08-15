import java.util.ArrayList;

public class 和为S的连续正数序列 {
    /**
     * https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&&tqId=11194&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 返回值描述：
     * 输出所有和为sum的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * 示例1
     * 输入：
     * 9
     * 返回值：
     * [[2,3,4],[4,5]]
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= sum/2; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int tmp = i;
            list.add(tmp);
            int num = tmp;
            while (num < sum) {
                tmp++;
                num += tmp;
                list.add(tmp);
            }
            if (num == sum) {
                ret.add(list);
            }
        }
        return ret;
    }
}
