package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/2 15:06
 */
public class T0011 {

    @Test
    public void test() {

//        int[] nums = {3,4,5,1,2};
//        int[] nums = {2,2,2,0,1};
//        int[] nums = {1,2,3,4,5,6};
//        int[] nums = {4,5,6,1,2,3,4};
//        int[] nums = {3,4};
//        int[] nums = {10,1,10,10,10};

        int[] nums = {1, 2, 3, 0, 1, 1};
        Out.println(minArray(nums));
    }

    /**
     * @param numbers 旋转排序数组
     * @return int 数组最小值
     * @author morningwn
     * @date 2020/7/2 18:30
     * @description: 二分法查询
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }

        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (numbers[m] > numbers[r]) {
                l = m + 1;
            } else if (numbers[m] < numbers[r]) {
                r = m;
            } else {
                r--;
            }
        }

        return numbers[l];

    }

    /**
     * @param numbers 旋转排序数组
     * @return int 最小值
     * @author morningwn
     * @date 2020/7/2 18:29
     * @description: 暴力循环得到结果
     * @version: 1.0
     */
    public int minArray1(int[] numbers) {
        int min = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

}
