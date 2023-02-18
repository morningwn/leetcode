package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @description: 搜索插入位置
 * @date Created in 2020/4/27 20:40
 * @version: 1.0
 */
public class T0035 {

    @Test
    public void test() {
        int[] nums = {0};
        Out.println(searchInsert(nums, 1));
    }

    /**
     * 折半查找
     *
     * @param nums   排序的数组
     * @param target 目标值
     * @return 目标值存在返回索引，否则返回目标值插入点索引
     */
    public int searchInsert(int[] nums, int target) {

        //初始化左右边界
        int l = 0, r = nums.length - 1;

        while (l <= r) {

            //计算中间位置的索引
            int m = (l + r) / 2;

            //如果目标值在右侧
            if (nums[m] < target) {
                //判断目标值是否存在数组中，前两个判断均是目标值不在数组中的情况
                if (m < r && nums[m + 1] > target) {
                    return m + 1;
                } else if (m == r) {
                    return m + 1;
                } else {
                    l = m + 1;
                }
                //如果目标值在右侧
            } else if (nums[m] > target) {
                //同上
                if (m > l && nums[m - 1] < target) {
                    return m;
                } else if (m == l) {
                    return m;
                } else {
                    r = m - 1;
                }
            } else {//如果找到了目标值
                return m;
            }
        }
        return 0;
    }
}
