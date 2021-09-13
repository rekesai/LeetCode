public class 删除有序数组中的重复项 {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            while (fast < nums.length && nums[slow] == nums[fast]) {
                fast++;
            }
            if (fast == nums.length) {
                break;
            }
            slow++;
            nums[slow] = nums[fast];
        }
        return slow+1;
    }
}
