package com.github.morningwn.t0001_t0500.t0201_t0300.t0261_t0270;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 268. 丢失的数字
 * <link>https://leetcode-cn.com/problems/missing-number/</link>
 *
 * @author moringwn
 * @date 2021/11/5 上午11:17
 */
public class T0268 {

    @Test
    public void test() {
        int[] nums = {0};

        Out.println(missingNumber(nums));
    }

    /**
     * 使用异或搞定问题
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res ^= (i ^ nums[i]);
        }

        return res;
    }

    /**
     * 在原有数组上面做修改，记录当前位置
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {

        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] < nums.length) {
                tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
