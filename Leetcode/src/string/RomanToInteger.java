package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int curInt = map.get(s.charAt(i));
            int nextInt = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;
            if (curInt < nextInt) {
                total += (nextInt - curInt);
                i+=2;
                i--;
            } else {
                total += curInt;
            }
        }

        // or write it like
//        for (int i = 0; i < s.length(); i++) {
//            int curInt = map.get(s.charAt(i));
//            int nextInt = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;
//            if (curInt < nextInt) {
//                total -= curInt;
//            } else {
//                total += curInt;
//            }
//        }
        return total;
    }
}
