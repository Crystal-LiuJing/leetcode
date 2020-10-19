package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q155MinStack {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * <p>
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *  
     * <p>
     * Example 1:
     * <p>
     * Input
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * <p>
     * Output
     * [null,null,null,null,-3,null,0,-2]
     * <p>
     * Explanation
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top();    // return 0
     * minStack.getMin(); // return -2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class MinStack {
        private Integer min = Integer.MAX_VALUE;
        private List<Integer> elements;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            elements = new ArrayList<>();
        }

        public void push(int x) {
            elements.add(x);
            min = Math.min(min, x);
        }

        public void pop() {
            int top = top();
            elements.remove(elements.size() - 1);
            if (top == min) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < elements.size(); i++) {
                    min = Math.min(elements.get(i), min);
                }
            }
        }

        public int top() {
            return elements.get(elements.size() - 1);
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.top();    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
