package com.github.morningwn.t2501_.t5901_t6000.t5901_t5910;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 5907. 下一个更大的数值平衡数
 *
 * @author morningwn
 * @date Created in 2021/10/24 11:15
 */
public class T5907 {

    @Test
    public void test() {
        int num = 23;
        Out.println(nextBeautifulNumber(num));
    }

    public int nextBeautifulNumber(int n) {

        int num = n + 1;

        while (true) {
            if (judge(num)) {
                return num;
            } else {
                num++;
            }
        }
    }

    public boolean judge(int n) {
        int[] count = new int[10];
        int tmp = n;

        while (tmp > 0) {
            count[tmp % 10]++;
            tmp /= 10;
        }

        if (count[0] != 0) {
            return false;
        }

        for (int i = 1; i < 10; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }

        return true;
    }
}
