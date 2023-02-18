package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

public class T0016 {

    public static int threeSumClosest(int[] nums, int target) {

        int result;

        //将result初始化
        if (nums.length >= 3) {
            result = nums[0] + nums[1] + nums[2];
        } else {
            return 0;
        }

        //将数组排序
        Arrays.sort(nums);

        //按照顺序遍历所有数
        for (int k = 0; k < nums.length - 2; k++) {

            //l和r分别指向剩余所有数的最小值和最大值
            int l = k + 1, r = nums.length - 1;

            //从两边到中间，依次遍历，得到最小值是nums[k]的所有数对
            while (l < r) {

                int tmp = nums[k] + nums[l] + nums[r];

                //判断结果是否更优
                if (Math.abs(tmp - target) < Math.abs(result - target)) {
                    result = tmp;
                }

                //三数之和偏大，r减一
                if (tmp > target) {
                    r--;
                    //三数之和偏小，l加一
                } else {
                    l++;
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        Out.println(threeSumClosest(nums, 1));    //2

        int[] nums1 = {1, 1, -1, -1, 3};
        Out.println(threeSumClosest(nums1, -1));    //-1

    }
}