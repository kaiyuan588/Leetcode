package string;
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.ArrayList;
import java.util.List;

//Example 1:
//
//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
//Example 2:
//
//Input: n = 1
//Output: ["()"]
//O(2^2n) O(2n)
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        gen(n, 0, 0, sb, res);
        return res;
    }
    public void gen(int n, int leftSofar, int rightSofar, StringBuilder sb, List<String> res) {
        if (leftSofar == n && rightSofar == n) {
            res.add(sb.toString());
            return ;
        }
        if (leftSofar < n) {
            sb.append('(');
            gen(n, leftSofar + 1, rightSofar, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if (rightSofar < leftSofar) {
            sb.append(')');
            gen(n, leftSofar, rightSofar + 1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}