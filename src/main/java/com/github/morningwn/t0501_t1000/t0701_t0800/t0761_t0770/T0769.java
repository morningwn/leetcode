package com.github.morningwn.t0501_t1000.t0701_t0800.t0761_t0770;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted/">769. 最多能完成排序的块</a>
 *
 * @author morningwn
 * @create in 2022/10/13 11:37
 */
public class T0769 {

    @Test
    public void test() {
        int[] arr = {0, 1, 2, 3, 4};
        int count = maxChunksToSorted(arr);
        Out.print(count);
    }

    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (max == i) {
                count++;
                max = i;
            }
        }

        return count;
    }
}