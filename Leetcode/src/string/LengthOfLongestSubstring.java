package string;
import java.util.*;

//Given a string s, find the length of the longest substring without duplicate characters.
//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//O(n) O(k) size of unique chars

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> unique = new HashSet<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char rightChar = s.charAt(r);
            while ( unique.contains(rightChar)) {
                char leftChar = s.charAt(l);
                unique.remove(leftChar);
                l++;
            }
            res = Math.max(res, r - l + 1);
            unique.add(rightChar);
            r++;
        }
        return res;
    }
}
