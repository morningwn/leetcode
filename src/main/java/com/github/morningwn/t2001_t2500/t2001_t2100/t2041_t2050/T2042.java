package com.github.morningwn.t2001_t2500.t2001_t2100.t2041_t2050;

import cn.hutool.core.lang.UUID;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/">2042. 检查句子中的数字是否递增</a>
 *
 * @author morningwn
 * @create in 2023/1/3 13:03
 */
public class T2042 {

    @Test
    public void test() {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        Out.println(areNumbersAscending(s));

        System.out.println(UUID.fastUUID().toString(true));
        System.out.println(UUID.fastUUID().toString(true));
        System.out.println(UUID.fastUUID().toString(true));
        System.out.println(UUID.fastUUID().toString(true));
    }

    public boolean areNumbersAscending(String s) {
        char[] chars = s.toCharArray();
        int bfNum = 0;
        int cur = 0;
        for (char aChar : chars) {
            if ('0' <= aChar && aChar <= '9') {
                cur = cur * 10 + aChar - '0';
            } else if (aChar == ' ' && cur != 0) {
                if (bfNum >= cur) {
                    return false;
                }
                bfNum = cur;
                cur = 0;
            }
        }
        if (cur != 0) {
            return bfNum < cur;
        }
        return true;
    }
}
