import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
//         return array[array.length/2];
        int count = 0;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] == array[i+1]){
                count++;
            }
            else{
                count++;
                if(count > array.length/2){
                    return array[i];
                }
                else{
                    count = 0;
                }
            }
        }
        return array[array.length-1];
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }
            else{
                map.put(array[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > array.length/2){
                return entry.getKey();
            }
        }
        return array[0];
    }
}
