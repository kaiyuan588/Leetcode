package Google.LastThreeMonth;

import java.util.HashMap;
import java.util.Map;
public class TwoSum {
    public int[] TwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int substract = target - nums[i];
            if (map.containsKey(substract)) {
                return new int[]{i, map.get(substract)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
