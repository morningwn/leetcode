package com.github.morningwn.t0001_t0500.t0001_t0100.t0071_t0080;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href=""></a>
 *
 * @author morningwn
 * @date
 */
public class T0078 {

    @Test
    public void test() {
        int[] nums = {1, 2};
        Out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {

        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, len); i++) {

            char[] index = Integer.toString(i, 2).toCharArray();
            List<Integer> list = new ArrayList<>();

            for (int j = index.length - 1, k = len - 1; j >= 0; j--, k--) {
                if (index[j] == '1') {
                    list.add(nums[k]);
                }
            }
            res.add(list);
        }

        return res;
    }

}
