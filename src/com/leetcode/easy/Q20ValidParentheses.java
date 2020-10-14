package com.leetcode.easy;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q20ValidParentheses {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *  
     * <p>
     * Example 1:
     * <p>
     * Input: s = "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: s = "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: s = "{[]}"
     * Output: true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 思路：栈 加减乘除计算的简化
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()).equals(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    /**
     * leetcode 上的鬼才写法 真正的时间复杂度o(1)
     */
    public boolean betterIsValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c :
                s.toCharArray()) {
            switch (c) {
                case '(':
                    stack[head++] = ')';
                    break;
                case '{':
                    stack[head++] = '}';
                    break;
                case '[':
                    stack[head++] = ']';
                    break;
                case ')':
                case '}':
                case ']':
                    if (head == 0 || stack[--head] != c) {
                        return false;
                    }
                    break;
            }
        }
        return head == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Q20ValidParentheses().isValid("[]{}"));
    }
}
