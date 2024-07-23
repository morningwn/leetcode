package com.github.morningwn.t0001_t0500.t0101_t0200.t0121_t0130;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">125. 验证回文串</a>
 *
 * @author morningwn
 * @date Created in 2024/7/23 18:26
 */
public class J0125 {

    @Test
    public void test() {
        Assert.assertEquals(true, isLettle('c'));
        Assert.assertEquals(true, isLettle('a'));
        Assert.assertEquals(true, isLettle('z'));
        Assert.assertEquals(true, isLettle('A'));
        Assert.assertEquals(true, isLettle('b'));
        Assert.assertEquals(true, isLettle('Z'));
        Assert.assertEquals(true, isLettle('3'));
        Assert.assertEquals(false, isLettle(' '));
        Assert.assertEquals(false, isLettle(','));
        Assert.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(false, isPalindrome("race a car"));
        Assert.assertEquals(true, isPalindrome(" "));
        Assert.assertEquals(true, isPalindrome("aa"));
        Assert.assertEquals(false, isPalindrome("0P"));

    }

    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (!isLettle(charArray[left])) {
                left++;
                continue;
            }
            if (!isLettle(charArray[right])) {
                right--;
                continue;
            }
            if ((isDigit(charArray[left]) || isDigit(charArray[right])) && charArray[left] != charArray[right]) {
                return false;
            }
            if (charArray[left] != charArray[right] &&
                charArray[left] - 32 != charArray[right] &&
                charArray[left] != charArray[right] - 32) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isLettle(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || isDigit(c);
    }
    
    private boolean isDigit(char c) {
        return '0' <= c && c<= '9';
    }
}