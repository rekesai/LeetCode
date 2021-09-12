public class 最大交换 {

    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * 示例 1 :
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     *
     * 示例 2 :
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-swap
     */
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] nums = str.toCharArray();

        // 建立一个字典来记录0-9数字在给定数字（num）中最后出现的位置，是用来存放位置的
        int[] need = new int[10];
        for (int i = 0; i < nums.length; i++) {
            need[nums[i] - '0'] = i;
        }

        // 从左至右查找给定数字
        for (int i = 0; i < nums.length; i++) {
            // 从最大的数字9开始查找，条件是这个数字比外循环的那个数字大
            for (int j = 9; j > nums[i]-'0'; j--) {
                // 如果当前数字比外循环数字大，而且它在num中的位置还比这个数字的位置靠右，交换
                if (need[j] > i) {

                    char tmp = nums[need[j]];
                    nums[need[j]] = nums[i];
                    nums[i] = tmp;
                    str = String.valueOf(nums);
                    return Integer.parseInt(str);
                }
            }
        }
        return num;
    }
}
