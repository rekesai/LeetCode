public class Test1007 {

    // 插入排序
    // 最好时间复杂度O(n)，最坏时间复杂度O(n^2) 稳定，越有序越快
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (nums[j] > tmp) {
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = tmp;
        }
    }

    // 希尔排序
    // 不稳定，最坏时间复杂度O(n^1.3)-O(n^1.5) 作为插入排序的优化版本，希尔排序先达成局部的有序，再逐渐达成整体有序
    public static void shellSort(int[] nums) {
        int[] gap = {5, 3, 1};
        for (int i = 0; i < gap.length; i++) {
            shell(nums, gap[i]);
        }
    }
    public static void shell(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i-gap;
            for (; j >= 0; j -= gap) {
                if (nums[j] > tmp) {
                    nums[j+gap] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+gap] = tmp;
        }
    }

    // 选择排序
    // 不稳定，最坏时间复杂度O(n^2) 选择排序为双循环嵌套，每次比较大小交换
    public static void selectSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 5, 1, 3, 1, 7, 8, 9, 2, 45, 32, -1};
        for (int i: nums) {
            System.out.print(i+" ");
        }
        System.out.println();
        selectSort(nums);
        for (int i: nums) {
            System.out.print(i+" ");
        }
    }
}