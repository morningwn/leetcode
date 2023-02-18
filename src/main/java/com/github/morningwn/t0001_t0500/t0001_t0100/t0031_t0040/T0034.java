package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @date Created in 2020/5/26 17:28
 * @version: 1.0
 */
public class T0034 {

    @Test
    public void test() {
        int[] nums = {};
        int target = 1;
        int[] res = searchRange(nums, target);
        Out.println(res[0] + "\t " + res[1]);
    }

    /**
     * 二分查询，返回目标值的范围，不存在就返回{-1, -1}
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        //初始化左右边界
        int l = 0, r = nums.length - 1;

        while (l <= r) {

            //得到中间值
            int m = (l + r) / 2;

            //判断中间值的大小，进行下一步操作
            if (nums[m] > target) {
                //当中间值大于目标值时，判断左侧是否还存在比中间值大或者相等的值
                //若存在则可以进行下一次循环，不在就返回结果{-1, -1}
                if (m > 0 && nums[m - 1] >= target) {
                    r = m - 1;
                } else {
                    return new int[]{-1, -1};
                }
            } else if (nums[m] < target) {
                //中间值小于目标值，判断右侧是否存在比中间值小或者相等的值
                //若存在则可以进行下一次循环，不在就返回结果{-1, -1}
                if (m + 1 < nums.length && nums[m + 1] <= target) {
                    l = m + 1;
                } else {
                    return new int[]{-1, -1};
                }
            } else {
                //查询目标值的范围，返回结果
                l = m;
                r = m;
                while (l > 0 && nums[l - 1] == nums[l]) {
                    l--;
                }
                while (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r++;
                }
                return new int[]{l, r};
            }
        }

        return new int[]{-1, -1};
    }

}
