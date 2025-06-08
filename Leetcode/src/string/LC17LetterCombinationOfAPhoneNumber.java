package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//
//Example 1:
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:
//
//Input: digits = ""
//Output: []
//Example 3:
//
//Input: digits = "2"
//Output: ["a","b","c"]
//T: O(4^n) S: O(n × 4^n)
public class LC17LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
        char[] arr = digits.toCharArray();
        int[] nums = new int[arr.length];
        for (int i =0; i < arr.length; i++) {
            nums[i] = (int)(arr[i] - '0');
        }
        dfs(nums, 0, map, new StringBuilder(), res);
        return res;
    }
    public void dfs(int[] nums, int index, Map<Integer, String> map, StringBuilder sb, List<String> res) {
        if (index == nums.length) {
            res.add(sb.toString());
            return ;
        }
        String cur = map.get(nums[index]);
        char[] tmp = cur.toCharArray();

        for (int i = 0; i < tmp.length; i++) {
            char c = tmp[i];
            sb.append(c);
            dfs(nums, index+1, map, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
