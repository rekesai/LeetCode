import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 把数组排成最小的数 {
    /**
     * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&&tqId=11185&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * 描述
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * 示例1
     * 输入：
     * [3,32,321]
     * 返回值：
     * "321323"
     */

    // 把字符串比较变成数字比较版本
    public boolean swap(int[] numbers, int i, int j) {
        long x = Long.parseLong(numbers[i]+""+numbers[j]);
        long y = Long.parseLong(numbers[j]+""+numbers[i]);
        if (x > y) {
            int tmp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tmp;
            return true;
        }
        return false;
    }
    public String PrintMinNumber(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            boolean flg = true;
            for (int j = 0; j < numbers.length-1-i; j++) {
                if (swap(numbers, j, j+1)) {
                    flg = false;
                }
            }
            if (flg) break;
        }
        StringBuilder ret = new StringBuilder();
        for (int i: numbers) {
            ret.append(i);
        }
        return ret.toString();
    }

    // 重写比较器写法（正宗）
    public String PrintMinNumber1(int [] numbers) {
        StringBuilder ret = new StringBuilder();
        ArrayList<Integer> list= new ArrayList<Integer>();
        for(int i = 0; i < numbers.length; i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer str1,Integer str2){
                String s1 = str1+""+str2;
                String s2 = str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        for(int i : list){
            ret.append(i);
        }
        return ret.toString();
    }
}
