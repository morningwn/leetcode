package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @description: 二进制中1的个数
 * @date Created in 2020/7/4 11:02
 * @version: 1.0
 */
public class T0015 {

    @Test
    public void test() {
        Out.println(hammingWeight(127));

    }

    /**
     * @author morningwn
     * @date 2020/7/4 15:14
     * @description: n&(n-1)会直接跳过所有为零的数
     * @param: n 一个二进制数
     * @return: int 1的个数
     */
    public int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }


    /**
     * @author morningwn
     * @date 2020/7/4 15:11
     * @description: 使用&符号，n&1，当其最后一位为零时结果为0，最后一位为1，结果为1
     * @version: 2.0
     * @param: n 一个二进制数
     * @return: int 1的个数
     */
    public int hammingWeight2(int n) {
        int count = 0;

        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }

        return count;
    }

    /**
     * @author morningwn
     * @date 2020/7/4 15:06
     * @description: 使用加法处理，第三十二位不为零的特殊情况记得处理
     * @version: 1.0
     * @param: n 输入一个二进制书
     * @return: int 输出1的个数
     */
    public int hammingWeight1(int n) {

        int count = 0;
        boolean flag = false;
        int bit = 1 << 30;

        //判断第三十二位是否为1，并对其处理
        if (n < 0) {
            n = -(n + 1);
            flag = true;
        }

        //计算每一个值
        while (n > 1) {
            if (bit <= n) {
                count++;
                n -= bit;
            }
            bit = bit >> 1;
        }

        //最后一位是否为1
        if (n == 1) {
            count++;
        }

        //第三十二位为1的时候，结果为32-count
        if (flag) {
            return 32 - count;
        } else {
            return count;
        }

    }

}
