import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 乱序字符串 {
    /**
     * 如果两个字符串长度相等，其中包含的字母种类相等，相应的字母个数也相等，只是顺序不同，这样两个字符串称作乱序字符串
     * 给定一个字符串数组，其中有许多字符串，请你找出其中的乱序字符串
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = {"abc", "bca", "acb", "asd", "abbe"};
        ArrayList<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String str = String.valueOf(tmp);
            list.add(str);
            int count = map.getOrDefault(str, 0);
            map.put(str, count+1);
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) > 1) {
                result.add(strs[i]);
                System.out.println(strs[i]);
            }
        }
    }
}
