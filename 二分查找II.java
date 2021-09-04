public class 二分查找II {

    /**
     * https://www.nowcoder.com/practice/4f470d1d3b734f8aaf2afb014185b395?tpId=188&&tqId=38588&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
     * 描述
     * 请实现有重复数字的升序数组的二分查找
     * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
     * 示例1
     * 输入：
     * [1,2,4,4,5],4
     * 返回值：
     * 2
     * 说明：
     * 从左到右，查找到第1个为4的，下标为2，返回2
     */
    public int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] > target) {
                right = mid-1;
            }
            else if (nums[mid] < target) {
                left = mid+1;
            }
            else {
                while (nums[mid] == target) {
                    if (mid == 0) return 0;
                    mid--;
                }
                return mid+1;
            }
        }
        return -1;
    }
}
