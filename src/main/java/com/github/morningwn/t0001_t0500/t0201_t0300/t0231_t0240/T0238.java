package com.github.morningwn.t0001_t0500.t0201_t0300.t0231_t0240;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/6/4 11:00
 */
public class T0238 {
    @Test
    public void test() {
//        int[] nums = {1,2,3,4};
        int[] nums = {0, 1};
        int[] res = productExceptSelf(nums);
        for (int num : res) {
            Out.println(num);
        }
    }

    /**
     * 优化过的
     */
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        int[] res = new int[len];
        res[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            res[len - i - 1] = res[len - i] * nums[len - i];
        }

        int count = 1;
        for (int i = 0; i < len; i++) {
            res[i] *= count;
            count *= nums[i];
        }
        return res;
    }

    /**
     * 未优化
     */
    public int[] productExceptSelf1(int[] nums) {

        int len = nums.length;

        //存储结果
        int[] res = new int[len];

        //分别存储第i个数左侧数的乘积和右侧数的乘积
        int[] countls = new int[len];
        int[] countrs = new int[len];

        //先将第一个置1
        countls[0] = 1;
        countrs[len - 1] = 1;

        //计算
        for (int i = 1; i < len; i++) {
            countls[i] = countls[i - 1] * nums[i - 1];
            countrs[len - i - 1] = countrs[len - i] * nums[len - i];
        }

        //计算最终的结果
        for (int i = 0; i < len; i++) {
            Out.println(countls[i] + "\t " + countrs[i]);
        }
        for (int i = 0; i < len; i++) {
            res[i] = countls[i] * countrs[i];
        }
        return res;
    }

}
