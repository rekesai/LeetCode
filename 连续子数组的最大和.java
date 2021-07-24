public class 连续子数组的最大和 {
    /**
     * 描述
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
     * 示例1
     * 输入：
     * [1,-2,3,10,-4,7,2,-5]
     * 复制
     * 返回值：
     * 18
     * 复制
     * 说明：
     * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
     * 典型的动态规划。
     * dp[n]代表以当前元素为截止点的连续子序列的最大和，如果dp[n-1]>0，dp[n]=dp[n]+dp[n-1]，
     * 因为当前数字加上一个正数一定会变大；如果dp[n-1]<0，dp[n]不变，
     * 因为当前数字加上一个负数一定会变小。使用一个变量max记录最大的dp值返回即可。
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        for(int i = 1; i < array.length; i++){
            array[i] += Math.max(array[i-1], 0);
            sum = Math.max(sum, array[i]);
        }
        return sum;
    }

}
