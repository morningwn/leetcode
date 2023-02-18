package com.github.morningwn.t0001_t0500.t0001_t0100.t0041_t0050;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/">47. 全排列 II</a>
 *
 * @author moringwn
 * @create in 2022/6/14 16:42
 */
public class T0047 {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);

        Out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> template = new ArrayList<>();
        for (int num : nums) {
            template.add(num);
        }
        result.add(template);
        helper(result, template, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> template, int index) {
        if (index >= template.size()) {
            return;
        }
        for (int i = index + 1; i < template.size(); i++) {
            swap(template, index, i);
            helper(result, template, index + 1);
            result.add(new ArrayList<>(template));
            swap(template, i, index);
        }

        helper(result, template, index + 1);
    }

    private void swap(List<Integer> template, int l, int r) {
        Integer tmp = template.get(l);
        template.set(l, template.get(r));
        template.set(r, tmp);
    }
}
