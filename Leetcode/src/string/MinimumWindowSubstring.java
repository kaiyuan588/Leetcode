package string;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
//The testcases will be generated such that the answer is unique.
//Example 1:
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//Example 2:
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
//LC 76 HARD
//O(m+n) O(k), where k is the number of unique characters in t (both maps are bounded by that)
public class MinimumWindowSubstring {
    public static String minimumWindowSubstring(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> curWindow = new HashMap<>();
        int l = 0, r = 0;
        int required = targetCount.size();
        int curFormed = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (r <  s.length()) {
            char c =  s.charAt(r);
            curWindow.put(c, curWindow.getOrDefault(c, 0) + 1);
            if (targetCount.containsKey(c) && curWindow.get(c).intValue() == targetCount.get(c).intValue()) {
                curFormed++;
            }
            while (required == curFormed) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                char leftChar = s.charAt(l);
                curWindow.put(leftChar, curWindow.get(leftChar) - 1);
                if (targetCount.containsKey(leftChar) && curWindow.get(leftChar) < targetCount.get(leftChar)) {
                    curFormed--;
                }
                l++;
            }
            r++;
        }
        return res;
    }
}
