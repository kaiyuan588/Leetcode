package string;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length < 2) { return new int[]{}; }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }
}
