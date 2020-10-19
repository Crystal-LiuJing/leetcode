package com.leetcode.easy;


public class Q108ConvertSortedArrayToBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     * <p>
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * <p>
     * Example:
     * <p>
     * Given the sorted array: [-10,-3,0,5,9],
     * <p>
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思路：经典构建二叉搜索树 BST 分治 递归
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int med = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[med]);
        treeNode.left = dfs(nums, left, med - 1);
        treeNode.right = dfs(nums, med + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 78};
        int[] nums = {-10, -3, 0, 5, 9};
        new Q108ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);
    }
}
