import java.util.LinkedList;
import java.util.Queue;

public class 机器人的运动范围 {

    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     *
     *  
     *
     * 示例 1：
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     *
     * 示例 2：
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     *
     * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
     */
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
}
