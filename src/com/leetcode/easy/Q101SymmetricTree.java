package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q101SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * <p>
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     *  
     * <p>
     * But the following [1,2,2,null,3,null,3] is not:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *  
     * <p>
     * Follow up: Solve it both recursively and iteratively.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        getNumber(root.left, true, leftList);
        getNumber(root.right, false, rightList);
        if (leftList.size() != rightList.size()) {
            return false;
        }
        for (int i = 0; i < leftList.size(); i++) {
            if (leftList.get(i) != rightList.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void getNumber(TreeNode root, boolean left, List<Integer> numList) {
        if (root == null) {
            numList.add(0);
            return;
        }
        numList.add(root.val);
        if (left) {
            getNumber(root.left, left, numList);
            getNumber(root.right, left, numList);
        } else {
            getNumber(root.right, left, numList);
            getNumber(root.left, left, numList);
        }
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }

    /**
     * 思路：分析出
     */
    public boolean betterIsSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(2);
        root.left = rootLeft;
        root.right = rootRight;
        System.out.println(new Q101SymmetricTree().betterIsSymmetric(root));
    }
}
