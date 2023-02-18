package com.github.morningwn.t0001_t0500.t0201_t0300.t0251_t0260;

/**
 * @author morningwn
 * @description: 只出现一次的数字 III
 * @date Created in 2020/5/14 0:27
 * @version: 1.0
 */
public class T0260 {
    public T0260() {
    }

    public int[] singleNumber(int[] nums) {

        //存储整个数组的异或结果
        int xor = 0;

        //计算异或结果
        for (int num : nums) {
            xor ^= num;
        }

        //存储第一个不为零的数的位置
        int mark = 1;
        //找到从第到高算第一个不为0的位
        while ((mark & xor) == 0) {
            mark <<= 1;
        }

        //存储结果
        int[] res = new int[2];
        //根据这一位不同，将结果分为两类，分开异或就能得到结果
        for (int num : nums) {
            if ((mark & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }

    public void test() {

    }
}
