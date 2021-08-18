public class 距震中的路径 {
    /**
     * 描述
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 例如  a  b  c  e
     *      s  f  c  s
     *      a  d  e  e
     *  矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径
     *  因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

     * 示例1
     * 输入：
     * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
     * 返回值：
     * true

     * 示例2
     * 输入：
     * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcb"
     * 返回值：
     * false
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
