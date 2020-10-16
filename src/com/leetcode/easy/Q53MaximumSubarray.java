package com.leetcode.easy;

public class Q53MaximumSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * <p>
     * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * <p>
     *  
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Example 2:
     * <p>
     * Input: nums = [1]
     * Output: 1
     * Example 3:
     * <p>
     * Input: nums = [0]
     * Output: 0
     * Example 4:
     * <p>
     * Input: nums = [-1]
     * Output: -1
     * Example 5:
     * <p>
     * Input: nums = [-2147483647]
     * Output: -2147483647
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思路：想清楚什么时候应该添加该元素
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i] + currentMax, nums[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        new Q53MaximumSubarray().maxSubArray(nums);
    }
}
