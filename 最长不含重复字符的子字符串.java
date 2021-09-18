import java.util.ArrayList;
import java.util.List;

public class 最长不含重复字符的子字符串 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
     */
    public int lengthOfLongestSubstring(String s) {
        int m = s.length();
        int res = 0;
        for (int i = 0; i < m; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < m; j++) {
                if (!list.contains(s.charAt(j))) {
                    list.add(s.charAt(j));
                }
                else {
                    break;
                }
            }
            res = Math.max(res, list.size());
        }
        return res;
    }
}
