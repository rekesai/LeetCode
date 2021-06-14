import java.util.HashMap;

public class 两数之和 {
    // 暴力枚举
    public int[] twoSum2(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] == target-nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 哈希表解法
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
