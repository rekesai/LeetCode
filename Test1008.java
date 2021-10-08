public class Test1008 {

    // 插入排序，创造有序空间(0, i)与无序空间(i, nums.length) 时间复杂度为O(n^2) 稳定
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i-1;
            int tmp = nums[i];
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

    // 希尔排序，先达成局部有序，在达成整体有序，时间复杂度为O(n^1.3-1.5)，不稳定
    public static void shellSort(int[] nums) {
        int[] gap = {5, 3, 1};
        for (int i = 0; i < 3; i++) {
            shell(nums, gap[i]);
        }
    }
    public static void shell(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int j = i-gap;
            int tmp = nums[i];
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

    // 选择排序，时间复杂度为O(n^2) 不稳定
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    // 冒泡排序，稳定，最坏时间复杂度O(n^2)
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 5, 1, 3, 1, 7, 8, 9, 2, 45, 32, -1};
        for (int i: nums) {
            System.out.print(i+" ");
        }
        System.out.println();
        bubbleSort(nums);
        for (int i: nums) {
            System.out.print(i+" ");
        }
    }
}