import java.util.Random;

public class Test1011 {
    //插入排序 最好O(n) 最坏O(n^2) 稳定
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i-1;
            for (; j >=0; j--) {
                if (nums[j] > tmp) {
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = tmp;
        }
    }

    // 希尔排序，直接插入排序的优化，先达成局部有序，在逐渐达成整体有序 时间复杂度最好是在有序的情况下O(n) 最坏O(n^1.3-1.5) 不稳定
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

    // 选择排序 时间复杂度O(n^2)，不受数据影响  不稳定
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int max = 0;
            for (int j = 1; j < nums.length-i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            int tmp = nums[nums.length-1-i];
            nums[nums.length-1-i] = nums[max];
            nums[max] = tmp;
        }
    }

    // 冒泡排序 时间复杂度最好O(n)基于数据有序 最坏O(n^2)基于数据无序 稳定
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
    public static void heapSort(int[] array){
        creatHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(0, end, array);
            end--;
        }
    }
    public static void creatHeap(int[] array){
        //p是每棵子树的根节点
        for(int p = (array.length-1-1)/2; p >= 0; p--){
            adjustDown(p, array.length, array);
        }
    }
    public static void adjustDown(int parent, int len, int[] array){
        int child = parent*2 + 1;
        while(child < len){
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = parent*2 + 1;
            }
            else{
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10_0000);
        }
        System.out.println();
        long a = System.currentTimeMillis();
        heapSort(nums);
        System.out.println(System.currentTimeMillis()-a);
        for (int i: nums) {
            System.out.print(i+" ");
        }
    }
}