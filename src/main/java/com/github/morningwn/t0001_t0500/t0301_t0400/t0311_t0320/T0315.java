package com.github.morningwn.t0001_t0500.t0301_t0400.t0311_t0320;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author morningwn
 * @description: 计算右侧小于当前元素的个数
 * @date Created in 2020/7/11 16:05
 * @version: 1.0
 */
public class T0315 {

    @Test
    public void test() {

//        int[] nums = {5,2,6,1};
        int[] nums = {34, 5, 2, 4, 6, 8, 98, 4, 2, 43, 54, 6, 78, 9, 45, 23, 23, 4, 5, 34, 56, 6};
        Out.println(countSmaller(nums));
    }

    /**
     * @author morningwn
     * @date 2020/7/11 16:58
     * @description: 使用折半插入排序
     * @param: nums
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new LinkedList<>();
        list.add(nums[nums.length - 1]);
        res.add(0);

        for (int i = nums.length - 2; i >= 0; i--) {

            int id = serch(list, nums[i]);
            list.add(id, nums[i]);
            res.add(0, id);
            Out.println(nums[i] + "\t id:" + id + "\t " + list);
        }

        return res;
    }

    /**
     * @author morningwn
     * @date 2020/7/11 16:25
     * @description: 折半查询
     * @param: list
     * @param: num
     * @return: int
     */
    public int serch(List<Integer> list, int num) {
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (list.get(m) == num) {
                while (m > l && list.get(m - 1) == num) {
                    m--;
                }
                return m;
            } else if (list.get(m) < num) {
                if (m + 1 > r) {
                    return m + 1;
                } else {
                    if (list.get(m + 1) > num) {
                        return m + 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                if (m - 1 < l) {
                    return m;
                } else {
                    if (list.get(m - 1) < num) {
                        return m;
                    } else {
                        r = m - 1;
                    }
                }
            }
        }

        return 0;
    }

    /**
     * @author morningwn
     * @date 2020/7/11 16:17
     * @description: 暴力循环，运行超时
     * @param: nums
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> list = new LinkedList<>();
        if (nums.length == 0 || nums == null) {
            return list;
        }
        list.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = 0;

            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            list.add(0, count);
        }

        return list;
    }

}
//        [14, 5, 0, 1, 4, 6, 15, 1, 0, 8, 9, 2, 9, 3, 6, 3, 3, 0, 0, 1, 1, 0]
//        [14, 5, 0, 1, 4, 6, 15, 1, 0, 8, 9, 2, 9, 3, 6, 3, 3, 0, 0, 1, 1, 0]