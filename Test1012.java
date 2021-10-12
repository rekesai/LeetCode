import java.util.Arrays;
import java.util.Random;

public class Test1012 {
    // 插入排序 时间复杂度最好O(n) 最坏O(n^2) 稳定
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

    // 希尔排序 时间复杂度最好O(n)基于数据有序  最坏O(n^1.3)基于数据无序 不稳定
    public static void shellSort(int[] nums) {
        int gap = nums.length/2;
        while (gap > 1) {
            shell(nums, gap);
            gap /= 2;
        }
        shell(nums, 1);
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

    // 选择排序 不稳定 每次选择出一个最大数字放在无序空间最后 不受数据影响时间复杂度为O(n^2)
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

    // 冒泡排序 稳定 基于数据是否有序，时间复杂度最好O(n),最坏O(n^2)
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


    // 堆排序 时间复杂度O(nlog2n) 不稳定
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void adjust(int[] nums, int parent, int size) {
        // 取到此节点的左孩子
        int child = parent*2 + 1;
        while (child < size) {
            // 为了取到左右孩子的最大值 - 如果还有右孩子并且右孩子比左孩子大，取右孩子的值
            if (child+1 < size && nums[child] < nums[child+1]) {
                child++;
            }
            // 判断是否需要交换，如不需要则已经是大顶堆了因为是从最后面的父节点开始判断的，直接跳出
            if (nums[child] > nums[parent]) {
                swap(nums, child, parent);
                parent = child;
                child = parent*2 + 1;
            } else {
                break;
            }
        }
    }
    // 建立大堆，先找到最后一个子树的父节点作为parent进入调整
    public static void createHeap(int[] nums){
        for (int parent = nums.length/2-1; parent >= 0; parent--) {
            adjust(nums, parent, nums.length);
        }
    }
    public static void heapSort(int[] nums) {
        // 1.建立大堆
        createHeap(nums);
        // 2.排序
        // 这里的size既是需要交换的数据位置，也是调整数组时的最大范围
        // 当交换完一个数据之后，那个数据就不用动了，而是调整数组除了他以外的其他数据形成大堆，再次交换倒数第二个位置和0位置的数据
        // 如此往复达成排序的效果
        int size = nums.length-1;
        while (size > 0) {
            swap(nums, 0, size);
            adjust(nums, 0, size);
            size--;
        }
    }

    // 快速排序 不稳定
    // 思想：从数组中去一个值作为基准par，将左右大于等于他的值放在par位置前面，将大于小于他的值放在par位置后面，再分别递归两边，分治达成有序
    public static int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= tmp) {
                end--;
            }
            if (start == end) {
                nums[start] = tmp;
                break;
            } else {
                nums[start] = nums[end];
            }
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            if (start == end) {
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


    public static void heapSort2(int[] nums) {
        createHeap(nums);

        int size = nums.length-1;
        while (size > 0) {
            swap(nums, 0, size);
            adjust2(nums, 0, size);
            size--;
        }
    }
    public static void createHeap2(int[] nums) {
        for (int parent = nums.length/2-1; parent >= 0; parent--) {
            adjust2(nums, parent, nums.length);
        }
    }
    public static void adjust2(int[] nums, int parent, int size) {
        int child = parent*2 + 1;
        while (child < size) {
            if (child+1 < size && nums[child] < nums[child+1]) {
                child++;
            }
            if (nums[child] > nums[parent]) {
                swap(nums, child, parent);
                parent = child;
                child = parent*2 + 1;
            } else {
                break;
            }
        }
    }


    public static int partition2(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= tmp) {
                end--;
            }
            if (start == end) {
                nums[start] = tmp;
                break;
            } else {
                nums[start] = nums[end];
            }

            while (start < end && nums[start] <= tmp) {
                start++;
            }
            if (start == end) {
                nums[end] = tmp;
                break;
            } else {
                nums[end] = nums[start];
            }
        }
        return start;
    }
    public static void quick2(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int par = partition2(nums, start, end);
        quick2(nums, start, par-1);
        quick2(nums, par+1, end);
    }
    public static void quickSort2(int[] nums) {
        quick2(nums, 0, nums.length-1);
    }


    public static void main(String[] args) {
        int[] nums = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10_0000);
        }
        long start = System.currentTimeMillis();
        quickSort2(nums);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(nums));
    }
}