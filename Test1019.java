import java.util.Arrays;
import java.util.Random;

public class Test1019 {
    // 插入排序 最好时间复杂度为O(n) 最坏时间复杂度为O(n^2) 稳定
    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
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
    // 希尔排序 最好时间复杂度为O(n^1.3) 最坏时间复杂度为O(n^2) 不稳定
    public static void shell(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if (nums[j] > tmp) {
                    nums[j+gap] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+gap] = tmp;
        }
    }
    public static void shellSort(int[] nums) {
        int gap = nums.length/2;
        while (gap > 1) {
            shell(nums, gap);
            gap /= 2;
        }
        shell(nums, 1);
    }
    // 选择排序 时间复杂度为O(n^2) 不受数据影响 不稳定
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int max = 0;
            for (int j = 1; j < nums.length-i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            int tmp = nums[max];
            nums[max] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
    // 冒泡排序 最好时间复杂度O(n) 最坏时间复杂度为O(n^2) 稳定
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length-1-i; j++) {
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
    // 堆排序 时间复杂度为O(n*log2n) 不受数据影响 不稳定
    public static void adjust(int[] nums, int parent, int size) {
        int child = parent*2 + 1;
        while (child < size) {
            if (child+1 < size && nums[child] < nums[child+1]) {
                child++;
            }
            if (nums[child] > nums[parent]) {
                int tmp = nums[child];
                nums[child] = nums[parent];
                nums[parent] = tmp;
                parent = child;
                child = parent*2 + 1;
            } else {
                break;
            }
        }
    }
    public static void createHeap(int[] nums) {
        for (int parent = nums.length/2-1; parent >= 0; parent--) {
            adjust(nums, parent, nums.length);
        }
    }
    public static void heapSort(int[] nums) {
        createHeap(nums);

        int size = nums.length-1;
        while(size > 0) {
            int tmp = nums[0];
            nums[0] = nums[size];
            nums[size] = tmp;
            adjust(nums, 0, size);
            size--;
        }
    }
    // 快速排序 最好时间复杂度为O(n*log2n) 最坏时间复杂度为O(n^2) 不稳定
    public static int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= tmp) {
                end--;
            }
            if (start >= end) {
                nums[start] = tmp;
                break;
            } else {
                nums[start] = nums[end];
            }

            while (start < end && nums[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                nums[end] = tmp;
                break;
            } else {
                nums[end] = nums[start];
            }
        }
        return start;
    }
    public static void quick(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int par = partition(nums, start, end);
        quick(nums, start, par-1);
        quick(nums, par+1, end);
    }
    public static void quickSort(int[] nums) {
        quick(nums, 0, nums.length-1);
    }
    // 归并排序 时间复杂度为O(n*log2n) 不受数据印象 稳定
    public static void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end-start+1];
        int k = 0;
        int s1 = start;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = end;
        while (s1 <= e1 && s2 <= e2) {
            if (nums[s1] <= nums[s2]) {
                tmp[k++] = nums[s1++];
            } else {
                tmp[k++] = nums[s2++];
            }
        }
        while (s1 <= e1) {
            tmp[k++] = nums[s1++];
        }
        while (s2 <= e2) {
            tmp[k++] = nums[s2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[i+start] = tmp[i];
        }
    }
    public static void mergeSortRec(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start+end)/2;
        mergeSortRec(nums, start, mid);
        mergeSortRec(nums, mid+1, end);
        merge(nums, start, mid, end);
    }
    public static void mergeSort(int[] nums) {
        mergeSortRec(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10_0000);
        }
        long start = System.currentTimeMillis();
        mergeSort(nums);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(nums));
    }
}