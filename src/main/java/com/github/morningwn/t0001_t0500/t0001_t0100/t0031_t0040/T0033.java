package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @description: 搜索旋转排序数组
 * @date Created in 2020/4/27 14:56
 * @version: 1.0
 */
public class T0033 {

    @Test
    public void test() {
        int[] nums = {3, 1};
//        int[] nums = { 4,5,6,7,0,1,2 };
        Out.println(search(nums, 1));
    }

    /**
     * 折半查找
     *
     * @param nums   已翻转的排序的数组
     * @param target 目标值
     * @return 目测值存在为索引，不存在为-1
     */
    public int search(int[] nums, int target) {

        //初始化左右两侧的边界
        int l = 0, r = nums.length - 1;

        while (l <= r) {

            //求中间的索引
            int m = (l + r) / 2;

            //判断是否已经得到结果
            if (nums[m] == target) {
                return m;
            }

            //如果前半段有序
            if (nums[l] <= nums[m]) {
                //当结果在前半段中
                if (nums[l] <= target && nums[m] > target) {
                    r = m - 1;
                } else {//否则就是后半段
                    l = m + 1;
                }
            } else {//如果后半段有序
                //当结果在后半段中
                if (nums[r] >= target && nums[m] < target) {
                    l = m + 1;
                } else {//否则就是后半段
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 折半查找
     *
     * @param nums   已排序的数组
     * @param target 目标值
     * @return 目测值存在为索引，不存在为-1
     */
    public int search1(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] < target) {
                if (m < r && nums[m + 1] > target) {
                    return -1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] > target) {
                if (m > l && nums[m - 1] < target) {
                    return -1;
                } else {
                    r = m - 1;
                }
            } else {
                return m;
            }
        }
        return -1;

    }
}
