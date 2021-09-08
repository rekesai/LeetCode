public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int m = s.length();
        int n = t.length();
        // 建立字典，记录需要的t字符串中的字符（可能重复）
        int[] need = new int[128];
        for (int i = 0; i < n; i++) {
            need[chart[i]]--;
        }

        String res = "";
        // 设置好左窗口和右窗口，以及有效字符串数的初始值，开始滑动右窗口
        for (int i = 0, j = 0, count = 0; j < m; j++) {
            // 滑动右窗口，将字符串s的相应字符加入字典
            need[chars[j]]++;
            // 如果此时字典中的这个字符数量小于0，或等于0（之前记录的字符串t中的字符，可能有重复字符）
            // 有效字符串数+1，如果不是需要的字符就不加
            if (need[chars[j]] <= 0) {
                count++;
            }
            // 如果这个时候有效字符串长度等于字符串t了 并且 左窗口有不必要的字符存在
            // 进入循环，开始减少左窗口不必要的字符
            while (count == n && need[chars[i]] > 0) {
                need[chars[i++]]--;
            }
            // 验证一下，找到符合条件的子串
            if (count == n) {
                // 如果res是空的（第一次找到符合条件的子串），或者新找到的子串比上一个找到的子串短，记下新的子串
                if (res.equals("") || res.length() > j-i+1) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }


    public String minWindow2(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;
        // 建立字典，记录需要的t字符串中的字符（可能重复）
        int[] need = new int[128];
        for (int i = 0; i < chart.length; i++) {
            need[chart[i]]--;
        }

        String res = "";
        // 设置好左窗口和右窗口，以及有效字符串数的初始值，开始滑动右窗口
        for (int i = 0, j = 0, count = 0; j < n; j++) {
            // 滑动右窗口，将字符串s的相应字符加入字典
            need[chars[j]]++;
            // 如果此时字典中的这个字符数量小于0，或等于0（之前记录的字符串t中的字符，可能有重复字符）
            // 有效字符串数+1，如果不是需要的字符就不加
            if (need[chars[j]] <= 0) {
                count++;
            }

            // 如果这个时候有效字符串长度等于字符串t了 并且 左窗口有不必要的字符存在
            // 进入循环，开始减少左窗口不必要的字符
            while (count == m && need[chars[i]] > 0) {
                need[chars[i++]]--;
            }
            // 验证一下，找到符合条件的子串
            if (count == m) {
                // 如果res是空的（第一次找到符合条件的子串），或者新找到的子串比上一个找到的子串短，记下新的子串
                if (res.equals("") || res.length() > j - i + 1) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
