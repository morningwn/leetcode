package com.github.morningwn.t1001_t1500.t1301_t1400.t1381_t1390;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://leetcode.cn/problems/create-target-array-in-the-given-order/">1389. 按既定顺序创建目标数组</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#Simulation}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2020/7/21 16:15
 */
public class J1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }
}
