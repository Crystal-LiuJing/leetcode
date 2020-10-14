package com.leetcode.easy;


public class Q21NoteMergeTwoSortedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
     * <p>
     *  
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: l1 = [1,2,4], l2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Example 2:
     * <p>
     * Input: l1 = [], l2 = []
     * Output: []
     * Example 3:
     * <p>
     * Input: l1 = [], l2 = [0]
     * Output: [0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思考：链表排序 跳转
     * 缺陷：按照人的方式思考了，应该按照代码的方式思考
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        boolean flag = l1.val <= l2.val;
        ListNode result;
        if (flag) {
            result = l1;
        } else {
            result = l2;
        }
        ListNode cal = result;
        ListNode l1tmp = l1;
        ListNode l2tmp = l2;
        while (cal.next != null) {
            int check = flag ? l2tmp.val : l1tmp.val;
            ListNode temNode = cal.next;
            if (check < temNode.val) {
                if (flag) {
                    l1tmp = cal.next;
                } else {
                    l2tmp = cal.next;
                }
                cal.next = flag ? l2tmp : l1tmp;
                cal = cal.next;
                flag = !flag;
            } else {
                cal = cal.next;
            }
        }
        cal.next = flag ? l2tmp : l1tmp;
        return result;
    }

    /**
     * 典型的想清楚很难，代码很简单
     */
    public ListNode betterTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
