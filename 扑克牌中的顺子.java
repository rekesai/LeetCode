import java.util.Arrays;

public class 扑克牌中的顺子 {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 示例 1:
     * 输入: [1,2,3,4,5]
     * 输出: True
     *  
     * 示例 2:
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
     */
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            // 如果元素为0，大小王数量+1
            if (nums[i] == 0) {
                joker++;
                // 如果有重复元素且不是0就返回false
            } else if (nums[i] == nums[i+1]) {
                return false;
            }
        }
        // 此时nums[joker]表示的就是除0以外的最小元素
        return nums[4]-nums[joker] < 5;
    }
}