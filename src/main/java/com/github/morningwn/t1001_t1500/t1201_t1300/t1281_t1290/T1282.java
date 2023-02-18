package com.github.morningwn.t1001_t1500.t1201_t1300.t1281_t1290;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/">1282. 用户分组</a>
 *
 * @author morningwn
 * @create in 2022/8/12 9:47
 */
public class T1282 {

    @Test
    public void test() {
        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> lists = groupThePeople(groupSizes);

        Out.println(lists);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> dictionary = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> group = dictionary.get(groupSizes[i]);
            if (group == null) {
                group = new ArrayList<>();
                dictionary.put(groupSizes[i], group);
            }
            group.add(i);

            Out.println(dictionary);
            if (group.size() == groupSizes[i]) {
                res.add(group);
                dictionary.put(groupSizes[i], new ArrayList<>(groupSizes[i]));
            }
        }

        return res;
    }
}
