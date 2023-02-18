package com.github.morningwn.t0001_t0500.t0001_t0100.t0041_t0050;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/4 15:40
 */
public class T0045 {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 4};//4
//        int[] nums = {2,3,0,1,4};//2
//        int[] nums = {2,1};//1
//        int[] nums = {5, 6,4,4,6,9,  4,4,7,4,4,8,2,6,8,   1,5,9,6,5,2,7,9,   7,9,6,9,4,1,6,8,8,   4,4,2,0,3,8,5};//5
//        int[] nums = {3, 4,3,2, 5,4, 3};//3
        Out.println(jump(nums));
    }

    /**
     * 最优解，迭代算法
     *
     * @param nums 一个数组
     * @return 最少的步数
     */
    public int jump(int[] nums) {

        //处理特殊情况
        if (nums.length <= 1) {
            return 0;
        }

        //分别初始化代表结果的，当前所在位置，以及当前位置可以向前走的步数
        int res = 0;
        int index = 0;
        int stap = nums[0];

        //循环，直到结束
        while (index < nums.length - 1) {

            //判断当前位置是否可以直接到达终点
            if (index + stap >= nums.length - 1) {
                return res + 1;
            }

            //存储下一次要去的位置（相对当前位置），下一个位置可以向前走的步数
            int it = 0;
            int st = 0;

            //判断得到当前位置的下一步的最优解（能够走到的最靠前的位置）
            for (int i = 1; index + i < nums.length && i <= stap; i++) {
                if (it + st <= i + nums[index + i]) {
                    it = i;
                    st = nums[index + i];
                }
            }
            index += it;
            stap = st;
            res++;
        }

        return res;
    }

    /**
     * 递归算法，妥妥的超时
     */
    public int jump1(int[] nums) {

        if (nums.length <= 1) {
            return 0;
        }
        int min = Short.MAX_VALUE;
        for (int i = 1; i <= nums[0]; i++) {
            min = Math.min(min, 1 + nextJump1(nums, i));
        }
        return min;
    }

    public int nextJump1(int[] nums, int index) {
        Out.println(index);
        if (index >= nums.length - 1) {
            return 0;
        }
        int min = Short.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {
            min = Math.min(min, 1 + nextJump1(nums, index + i));
        }
        return min;
    }

}
