import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1006 {
    public int longestCommonSubsequence(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = new int[ch1.length+1][ch2.length+1];
        for (int i = 0; i < ch1.length+1; i++) {
            for (int j = 0; j < ch2.length+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[ch1.length][ch2.length];
    }

    final int[][] direction = {{1, 0}, {0, 1}};
    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int check(int x, int y) {
        int tmpx = 0, tmpy = 0;
        while (x != 0) {
            tmpx += x%10;
            x = x/10;
        }
        while (y != 0) {
            tmpy += y%10;
            y = y/10;
        }
        return tmpx+tmpy;
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(0, 0);
        queue.offer(root);
        int count = 1;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 2; i++) {
                int x = cur.x + direction[i][0];
                int y = cur.y + direction[i][1];
                if (x < m && y < n && !visited[x][y] && check(x, y) <= k) {
                    queue.offer(new Node(x, y));
                    count++;
                    visited[x][y] = true;
                }
            }
        }
        return count;
    }


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