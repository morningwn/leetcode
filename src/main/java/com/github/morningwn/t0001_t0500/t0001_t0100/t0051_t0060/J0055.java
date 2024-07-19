package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/jump-game/description/">55. 跳跃游戏</a>
 *
 * @author morningwn
 * @date Created in 2020/4/17 1:15
 */
public class J0055 {

    @Test
    public void test() {

//        //true
//        int[] nums = { 2,3,1,1,4 };
//        //false
//        int[] nums = { 3,2,1,0,4 };
//        //true
//        int[] nums = { 0 };

//        int[] nums = {2, 0, 0, 1 };
//        //true
        int[] nums = {8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5};
        Out.println(canJump(nums));
        Out.println(canJump1(nums));

    }

    public boolean canJump(int[] nums) {
//        if ( nums.length < 2 ){
//            return true;
//        }
        int[] count = new int[nums.length + 1];
        int len = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (count[i] >= i) {
                int tmp = Math.max(count[i], nums[i] + i);
                if (tmp >= len) {
                    return true;
                } else {
                    count[i + 1] = tmp;
                }

            } else {
                return false;
            }
        }
        return false;

    }

    public boolean canJump1(int[] nums) {

        return canJump1(nums, 0);
    }

    public boolean canJump1(int[] nums, int index) {

        if (index == nums.length - 1) {
            return true;
        } else if (index > nums.length - 1) {
            return false;
        } else {
            boolean res = false;
            for (int i = 1; i <= nums[index]; i++) {
                res = res || canJump1(nums, index + i);
            }
            return res;
        }
    }
}
