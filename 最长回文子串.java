public class 最长回文子串 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     *
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     *
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     */

    // 此方法遍历字符串，每一个字符进行左右扩展，记录最长字符串的左右值

    // 用来向左向右扩展子串的方法
    public int check(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 在进行一次向左向右的扩展之后跳出循环，意味着此时不满足条件，注意返回值
        return right-left-1;
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以此字符为中心进行扩展 - 奇数字符
            int lenOdd = check(s, i, i);
            // 以此字符及后一个字符为中心开始扩展 - 偶数字符
            int lenEven = check(s, i, i+1);
            int curLen = Math.max(lenOdd, lenEven);
            // 如果当前字符串比记录的字符串更长，更改记录
            if (curLen > right-left) {
                if (curLen % 2 == 1) {
                    left = i - curLen/2;
                    right = i + curLen/2;
                }
                else {
                    left = i - curLen/2 + 1;
                    right = i + curLen/2;
                }
            }
        }
        return s.substring(left, right+1);
    }
}