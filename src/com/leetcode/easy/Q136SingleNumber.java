package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Q136SingleNumber {
    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * <p>
     * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
     * <p>
     *  
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,2,1]
     * Output: 1
     * Example 2:
     * <p>
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     * Example 3:
     * <p>
     * Input: nums = [1]
     * Output: 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/single-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思路：如果出现第二次就不记录
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    /**
     * 思路：位运算，异或的原理，相同为0，不同为1
     */
    public int betterSingleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //异或
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q136SingleNumber().betterSingleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
