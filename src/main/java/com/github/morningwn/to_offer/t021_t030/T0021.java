package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @description: 调整数组顺序使奇数位于偶数前面
 * @date Created in 2020/7/6 14:44
 * @version: 1.0
 */
public class T0021 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Out.println(Arrays.toString(exchange(nums)));
    }

    /**
     * @author morningwn
     * @date 2020/7/6 14:44
     * @description: 循环
     * @param: nums 输入数组
     * @return: int[] 调整过顺序的数组
     */
    public int[] exchange(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                index++;
            }
        }

        return nums;
    }

}
