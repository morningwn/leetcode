package com.github.morningwn.t0501_t1000.t0601_t0700.t0621_t0630;

import cn.hutool.json.JSONUtil;
import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.text.Format;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/maximum-distance-in-arrays/description">624. 数组列表中的最大距离</a>
 *
 * @author morningwn
 * @create in 2025/2/19 14:43
 */
public class J0624 {

    @Test
    public void test() {
        List<List<Integer>> lists = buildCase(10000);
        Out.toFile("/Users/mac/IdeaProjects/leetcode/target/1.json", JSONUtil.toJsonStr(lists));
        System.out.println(maxDistance(lists));
    }

    private List<List<Integer>> buildCase(int count) {
        Random random = new Random();

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 500; j++) {
                list.add(random.nextInt(-10000, 10000));
            }
            list.sort(Integer::compareTo);
            lists.add(list);
        }

        return lists;
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = 0;
        for(int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int n = array.size();
            res = Math.max(res, Math.max(Math.abs(array.get(n - 1) - min), Math.abs(max - array.get(0))));
            min = Math.min(array.get(0), min);
            max = Math.max(array.get(n - 1), max);
        }
        return res;
    }
}