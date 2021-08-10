public class 数组中的逆序对 {
    /**
     * 描述
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数count。
     * 并将count对1000000007取模的结果输出。 即输出P%1000000007
     *
     * 输入描述：
     * 题目保证输入的数组中没有的相同的数字
     * 示例1
     * 输入：
     * [1,2,3,4,5,6,7,0]
     * 返回值：
     * 7
     */
    public int count = 0;
    public void mergeSort(int[] array, int start, int end){
        if(start >= end) return;
        int mid = (start+end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        mergeOne(array, start, mid, end);
    }
    public void mergeOne(int[] array, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int left = start;
        int right = mid+1;
        int k = 0;
        while(left <= mid && right <= end){
            if(array[left] <= array[right]){
                temp[k++] = array[left++];
            }
            else{
                temp[k++] = array[right++];
                count = (count + (mid-left+1)) % 1000000007;
            }
        }
        while(left <= mid){
            temp[k++] = array[left++];
        }
        while(right <= end){
            temp[k++] = array[right++];
        }
        for(int i = 0; i < k; i++){
            array[start+i] = temp[i];
        }
    }
    public int InversePairs(int [] array) {
        mergeSort(array, 0, array.length-1);
        return count;
    }
}