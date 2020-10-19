package com.leetcode.easy;

public class Q88MergeSortedArray {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     *  
     * <p>
     * Constraints:
     * <p>
     * -10^9 <= nums1[i], nums2[i] <= 10^9
     * nums1.length == m + n
     * nums2.length == n
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 基本思想：从前往后比较当前与数列的第一个元素插入
     * 更好的解法：从后往前压，比较更大的一个写入当前指针位置
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        while (j < n) {
            while (i < m + n && nums1[i] <= nums2[j]) {
                i++;
            }
            if (i >= m + n) {
                break;
            }
            k = m + j;
            while (k > i) {
                nums1[k] = nums1[k - 1];
                k--;
            }
            nums1[i] = nums2[j];
            j++;
            i++;
        }
        while (j < n) {
            nums1[m + j] = nums2[j++];
        }
    }

    /**
     * 更好的解法：从后往前压，比较更大的一个写入当前指针位置
     */
    public void betterMerge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0 && i >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 8, 9, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
//        new Q88MergeSortedArray().merge(nums1, 4, nums2, 3);
        new Q88MergeSortedArray().betterMerge(nums1, 3, nums2, 3);
        for (int i = 0; i < 6; i++) {
            System.out.println(nums1[i]);
        }
    }
}
