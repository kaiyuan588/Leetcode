package string;

import java.util.HashMap;
import java.util.Map;
//Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//
//        '.' Matches any single character.​​​​
//        '*' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).
//
//
//
//Example 1:
//
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
//Example 2:
//
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//Example 3:
//
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
//O(M*N) O(M+N)
//aab c*a*b
public class LC10RegularExpressionMatching {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch2(s, p, 0, 0);
    }
    public boolean isMatch2(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        String key = i + "-" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        // i might be out of bound
        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        // is a *
        if (j+1 < p.length() && p.charAt(j+1) == '*') {
            boolean useStar = (match && isMatch2(s, p, i+1, j));
            boolean dontUseStar = isMatch2(s, p, i, j+2);
            cache.put(key, useStar || dontUseStar);
            return cache.get(key);
        } else if (match) {
            cache.put(key, isMatch2(s, p, i+1, j+1));
            return cache.get(key);
        }
        cache.put(key, false);
        return cache.get(key);
    }
}
