package string;

import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//An input string is valid if:
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//        Example 1:
//        Input: s = "()"
//        Output: true
//        Example 2:
//        Input: s = "()[]{}"
//        Output: true
//        Example 3:
//        Input: s = "(]"
//        Output: false
//        Example 4:
//        Input: s = "([])"
//        Output: true
public class LC20ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] stack = new char[s.length()];
        int top = -1;
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) { return false; }
                char open = stack[top--];
                if (c == ')' && open != '(') {
                    return false;
                } else if (c == '}' && open != '{') {
                    return false;
                } else if (c == ']' && open != '[') {
                    return false;
                }
            }
        }
        return top == -1;
//        Stack<Character> stack = new Stack<>();
//        for (char c: s.toCharArray()) {
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else {
//                if (c == ')') {
//                    if (!stack.isEmpty() && stack.peek() == '(') {
//                        stack.pop();
//                    } else {
//                        return false;
//                    }
//                }
//                if (c == ']') {
//                    if (!stack.isEmpty() && stack.peek() == '[') {
//                        stack.pop();
//                    } else {
//                        return false;
//                    }
//                }
//                if (c == '}') {
//                    if (!stack.isEmpty() && stack.peek() == '{') {
//                        stack.pop();
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//        return stack.isEmpty();
    }
}
