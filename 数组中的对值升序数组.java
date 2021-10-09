import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组中的对值升序数组 {

    public static int[] getSpacialNum (int num) {
        int[] nums = {1, 5, 9, 10, 16, 19, 25, 27, 29, 37, 65, 75};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (Math.abs(nums[i]-nums[j]) == num && !list.contains(nums[i]+nums[j])) {
                    list.add(nums[i]+nums[j]);
                }
            }
        }
        if (list.size() == 0) {
            return new int[]{0};
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }
    public static void main(String[] args) {
        int[] nums = getSpacialNum(-1);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }
}