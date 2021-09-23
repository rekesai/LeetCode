public class 矩阵中的路径 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     *
     * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
     *
     * 示例 1：
     * 输入：board = [["A","B","C","E"],
     *              ["S","F","C","S"],
     *              ["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     *
     * 示例 2：
     * 输入：board = [["a","b"],
     *              ["c","d"]], word = "abcd"
     * 输出：false
     *
     * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
     */
    static int[][] direction = {{-1, 0},{1, 0}, {0, -1},{0, 1}};
    public boolean dfs (int a, int b, char[][] matrix, boolean[][] visited, String word, int index) {
        // 不相等直接返回
        if (matrix[a][b] != word.charAt(index)) return false;
        // 满足以上条件且已经是字符串最后一个字符时说明这条路通了
        if (index == word.length()-1) return true;
        // 设置这个点走过了
        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int x = a + direction[i][0];
            int y = b + direction[i][1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && visited[x][y] == false) {
                if(dfs(x, y, matrix, visited, word, index+1)) {
                    return true;
                }
            }
        }
        // 没有走到底说明走不通，归回来的时候要还原路
        visited[a][b] = false;
        return false;
    }
    public boolean hasPath (char[][] matrix, String word) {
        // 用一个boolean数组来记录走过的路
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(i, j, matrix, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}