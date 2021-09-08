public class 最长公共子序列 {

    /**
     *   a b c d e
     * a 1 1 1 1 1
     * c 1 1 2 2 2
     * e 1 1 2 2 3
     *
     */
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
}