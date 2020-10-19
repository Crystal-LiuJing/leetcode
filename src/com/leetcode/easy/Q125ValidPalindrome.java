package com.leetcode.easy;

import com.sun.deploy.util.StringUtils;

public class Q125ValidPalindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p>
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     * <p>
     * Input: "race a car"
     * Output: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        for (; i < j; ) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (Character.isLetterOrDigit(l) && Character.isLetterOrDigit(r)) {
                if (!(l == r)) {
                    return false;
                }
                i++;
                j--;
                continue;
            }
            if (!Character.isLetterOrDigit(l)) {
                i++;
            }
            if (!Character.isLetterOrDigit(r)) {
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q125ValidPalindrome().isPalindrome(" "));
    }
}
