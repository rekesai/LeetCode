import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 字符串的排列 {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     * 示例:
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *
     * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
     */
    List<String> list = new ArrayList<>();
    char[] ch = null;
    public String[] permutation(String s) {
        ch = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }
    public void dfs(int index) {
        if (index == ch.length-1) {
            list.add(String.valueOf(ch));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < ch.length; i++) {
            if (!set.contains(ch[i])) {
                set.add(ch[i]);
                swap(i, index);
                dfs(index+1);
                swap(i, index);
            }
        }
    }
    public void swap(int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j]= tmp;
    }
}