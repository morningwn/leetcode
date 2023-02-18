package com.github.morningwn.t1001_t1500.t1301_t1400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @date Created in 2020/7/21 16:15
 */
public class T1389 {


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
